package com.test.answer.dao;

import com.test.answer.dao.mapper.HrClockConfigMapper;
import com.test.answer.dao.mapper.HrClockConfigMapper;
import com.test.answer.dao.model.HrClockConfig;
import com.test.answer.dao.model.HrClockConfigExample;
import com.test.answer.utils.RowBoundsUtil;
import com.test.answer.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HrClockConfigDao {

    private static final Logger logger = LoggerFactory.getLogger(HrClockConfigDao.class);

    @Autowired
    private HrClockConfigMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(HrClockConfig record) {
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
    public int updateData(Integer recordId, HrClockConfig record) {
        int cnt = 0;
        try {
            HrClockConfigExample example = new HrClockConfigExample();
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
            HrClockConfigExample example = new HrClockConfigExample();
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
     * @return
     */
    public List<HrClockConfig> queryPage(int pageNo, int pageSize) {
        int offset = (pageNo-1)*pageSize;

        HrClockConfigExample example = new HrClockConfigExample();

        List<HrClockConfig> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param pName
     * @return
     */
    public int queryPageTotal(String pName) {
        HrClockConfigExample example = new HrClockConfigExample();


        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<HrClockConfig> queryList(HrClockConfig condition) {
        List<HrClockConfig> result = null;

        HrClockConfigExample example = new HrClockConfigExample();

        result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 查询所有
     * @return
     */
    public List<HrClockConfig> listAll() {
        HrClockConfigExample example = new HrClockConfigExample();

        List<HrClockConfig> result = mapper.selectByExample(example);
        return result;
    }
    
}
