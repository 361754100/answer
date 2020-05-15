package com.test.answer.service;

import com.test.answer.dao.HrClockHistoryDao;
import com.test.answer.dao.model.HrClockHistory;
import com.test.answer.enums.ResultCodeEnum;
import com.test.answer.request.HrClockHistoryEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class HrClockHistoryService {

    @Autowired
    private HrClockHistoryDao hrClockHistoryDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(HrClockHistoryEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        //TODO...添加的时候需要判断当天打卡记录是否已存在

        HrClockHistory info = new HrClockHistory();
        info.setClockIn(req.getClockIn());
        info.setClockOut(req.getClockOut());
        info.setUserId(req.getUserId());
        info.setState(req.getState());

        int cnt = hrClockHistoryDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(HrClockHistoryEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        HrClockHistory info = new HrClockHistory();
        info.setClockIn(req.getClockIn());
        info.setClockOut(req.getClockOut());
        info.setUserId(req.getUserId());
        info.setState(req.getState());

        int cnt = hrClockHistoryDao.updateData(req.getId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
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
     * 查询单个结果
     * @return
     */
    public ListQueryWrapper listAll() {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        List<HrClockHistory> result = hrClockHistoryDao.listAll();
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecords(result);
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }
}
