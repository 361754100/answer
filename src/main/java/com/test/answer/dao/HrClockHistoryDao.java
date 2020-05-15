package com.test.answer.dao;

import com.test.answer.dao.mapper.HrClockHistoryMapper;
import com.test.answer.dao.model.HrClockHistory;
import com.test.answer.dao.model.HrClockHistoryExample;
import com.test.answer.utils.RowBoundsUtil;
import com.test.answer.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    
}
