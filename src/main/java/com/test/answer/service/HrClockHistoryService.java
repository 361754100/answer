package com.test.answer.service;

import com.test.answer.dao.HrClockConfigDao;
import com.test.answer.dao.HrClockHistoryDao;
import com.test.answer.dao.dto.HrClockHistoryReportDto;
import com.test.answer.dao.model.HrClockConfig;
import com.test.answer.dao.model.HrClockHistory;
import com.test.answer.enums.HrClockHisStateEnum;
import com.test.answer.enums.ResultCodeEnum;
import com.test.answer.request.HrClockHistoryEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import com.test.answer.utils.DateUtils;
import com.test.answer.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class HrClockHistoryService {

    @Autowired
    private HrClockConfigDao hrClockConfigDao;

    @Autowired
    private HrClockHistoryDao hrClockHistoryDao;

    /**
     * 保存考勤记录
     * @param req
     * @return
     */
    public CommonWrapper saveOrUpdateInfo(HrClockHistoryEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        HrClockHistory info = new HrClockHistory();
        info.setClockIn(DateUtils.parseStrToDate(req.getClockIn(), "yyyy-MM-dd HH:mm:ss"));
        info.setClockOut(DateUtils.parseStrToDate(req.getClockOut(), "yyyy-MM-dd HH:mm:ss"));
        info.setUserId(req.getUserId());
        int state = this.getClockState(req.getClockIn(), req.getClockOut());
        info.setState(state);

        // 添加的时候需要判断当天打卡记录是否已存在
        HrClockHistory existHis = hrClockHistoryDao.queryUserHistory(info.getUserId(), info.getClockIn());

        int cnt = 0;
        if(existHis != null) {
            cnt = hrClockHistoryDao.updateData(existHis.getId(), info);
        } else {
            cnt = hrClockHistoryDao.saveData(info);
        }

        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 获取考勤状态
     * @param clockIn
     * @param clockOut
     * @return
     */
    public int getClockState(String clockIn, String clockOut) {
        int state = HrClockHisStateEnum.NORMAL.getCode();

        HrClockConfig clockConfig = hrClockConfigDao.getHrClockConfig();
        if(clockConfig == null) {
            clockConfig = new HrClockConfig();
            clockConfig.setClockInTime("09:00:00");
            clockConfig.setClockOutTime("18:00:00");
        }
        String configClockIn = clockConfig.getClockInTime();
        String configClockOut = clockConfig.getClockOutTime();

        String clockInTime = clockIn.substring(11, 19);
        String clockOutTime = "";
        if(!StringUtils.isEmpty(clockOut)) {
            clockOutTime = clockOut.substring(11, 19);
        }
        if(configClockIn.compareTo(clockInTime) >= 0) {

            if(!StringUtils.isEmpty(clockOutTime)) {

                if(configClockOut.compareTo(clockOutTime) > 0) {
                    state = HrClockHisStateEnum.EARLY.getCode();
                }
                else if(configClockOut.compareTo(clockOutTime) < 0) {
                    state = HrClockHisStateEnum.HARD.getCode();
                }
            }
        }
        else {
            state = HrClockHisStateEnum.LATE.getCode();
        }
        return state;
    }

    /**
     * 删除记录
     * @param recordIds
     * @return
     */
    public CommonWrapper deleteInfo(List<Integer> recordIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = hrClockHistoryDao.delData(recordIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param pName     名称关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String pName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = hrClockHistoryDao.queryPageTotal(pName);
        List<HrClockHistory> result = hrClockHistoryDao.queryPage(pageNo, pageSize, pName);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(Integer recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        HrClockHistory condition = new HrClockHistory();
        condition.setId(recordId);

        List<HrClockHistory> result = hrClockHistoryDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 统计考勤记录
     * @return
     */
    public ListQueryWrapper reportClockHistory(String startTime, String endTime) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        List<HrClockHistoryReportDto> result = hrClockHistoryDao.reportClockHistory(startTime, endTime);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecords(result);
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }
}
