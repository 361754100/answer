package com.test.answer.dao;

import com.test.answer.dao.dto.HrClockHistoryReportDto;
import com.test.answer.dao.mapper.HrClockHistoryMapper;
import com.test.answer.dao.model.HrClockHistory;
import com.test.answer.dao.model.HrClockHistoryExample;
import com.test.answer.utils.DateUtils;
import com.test.answer.utils.RowBoundsUtil;
import com.test.answer.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HrClockHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(HrClockHistoryDao.class);

    @Autowired
    private HrClockHistoryMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(HrClockHistory record) {
        int cnt = 0;
        try {
            cnt = mapper.insertSelective(record);
        } catch (Exception e) {
            logger.error("save data error...", e);
        }
        return cnt;
    }

    /**
     * 查询用户当天打卡记录
     * @param userId
     * @param date
     * @return
     */
    public HrClockHistory queryUserHistory(String userId, Date date) {
        HrClockHistory history = null;

        String startTime = DateUtils.parseDateToStr(date, "yyyy-MM-dd") + " 00:00:00";
        String endTime = DateUtils.parseDateToStr(date, "yyyy-MM-dd") + " 23:59:59";

        Date startDate = DateUtils.parseStrToDate(startTime, "yyyy-MM-dd HH:mm:ss");
        Date endDate = DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss");

        HrClockHistoryExample example = new HrClockHistoryExample();
        example.createCriteria().andUserIdEqualTo(userId)
                .andClockInBetween(startDate, endDate);

        List<HrClockHistory> result = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            history = result.get(0);
        }
        return history;
    }

    /**
     * 修改记录
     * @param recordId
     * @param record
     * @return
     */
    public int updateData(Integer recordId, HrClockHistory record) {
        int cnt = 0;
        try {
            HrClockHistoryExample example = new HrClockHistoryExample();
            example.createCriteria().andIdEqualTo(recordId);

            cnt = mapper.updateByExampleSelective(record, example);
        } catch (Exception e) {
            logger.error("update data error...", e);
        }
        return cnt;
    }

    /**
     * 删除记录
     * @param recordIds
     * @return
     */
    public int delData(List<Integer> recordIds) {
        int cnt = 0;
        try {
            HrClockHistoryExample example = new HrClockHistoryExample();
            example.createCriteria().andIdIn(recordIds);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    public List<HrClockHistory> queryPage(int pageNo, int pageSize, String userId) {
        int offset = (pageNo-1)*pageSize;

        HrClockHistoryExample example = new HrClockHistoryExample();
        HrClockHistoryExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(userId)) {
            criteria.andUserIdLike("%"+ userId + "%");
        }

        List<HrClockHistory> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param userId
     * @return
     */
    public int queryPageTotal(String userId) {
        HrClockHistoryExample example = new HrClockHistoryExample();
        HrClockHistoryExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(userId)) {
            criteria.andUserIdLike("%"+ userId + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<HrClockHistory> queryList(HrClockHistory condition) {
        List<HrClockHistory> result = null;

        HrClockHistoryExample example = new HrClockHistoryExample();
        HrClockHistoryExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(condition.getUserId())) {
            criteria.andUserIdLike("%"+ condition.getUserId() + "%");
        }

        if(condition.getId() != null) {
            criteria.andIdEqualTo(condition.getId());
        }

        result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 查询所有
     * @return
     */
    public List<HrClockHistory> listAll() {
        HrClockHistoryExample example = new HrClockHistoryExample();

        List<HrClockHistory> result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 考勤统计
     * @return
     */
    public List<HrClockHistoryReportDto> reportClockHistory(String startTime, String endTime) {
        Map<String, Object> params = new HashMap<>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);

        List<HrClockHistoryReportDto> result = mapper.reportClockHistory(params);
        return result;
    }
}
