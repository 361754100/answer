package com.test.answer.dao;

import com.test.answer.dao.mapper.PointsInfoMapper;
import com.test.answer.dao.model.PointsInfo;
import com.test.answer.dao.model.PointsInfoExample;
import com.test.answer.utils.RowBoundsUtil;
import com.test.answer.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PointsInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(PointsInfoDao.class);

    @Autowired
    private PointsInfoMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(PointsInfo record) {
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
    public int updateData(Integer recordId, PointsInfo record) {
        int cnt = 0;
        try {
            PointsInfoExample example = new PointsInfoExample();
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
            PointsInfoExample example = new PointsInfoExample();
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
     * @param pName
     * @return
     */
    public List<PointsInfo> queryPage(int pageNo, int pageSize, String pName) {
        int offset = (pageNo-1)*pageSize;

        PointsInfoExample example = new PointsInfoExample();
        PointsInfoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(pName)) {
            criteria.andPnameLike("%"+ pName + "%");
        }

        List<PointsInfo> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param pName
     * @return
     */
    public int queryPageTotal(String pName) {
        PointsInfoExample example = new PointsInfoExample();
        PointsInfoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(pName)) {
            criteria.andPnameLike("%"+ pName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<PointsInfo> queryList(PointsInfo condition) {
        List<PointsInfo> result = null;

        PointsInfoExample example = new PointsInfoExample();
        PointsInfoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(condition.getPname())) {
            criteria.andPnameLike("%"+ condition.getPname() + "%");
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
    public List<PointsInfo> listAll() {
        PointsInfoExample example = new PointsInfoExample();

        List<PointsInfo> result = mapper.selectByExample(example);
        return result;
    }
    
}
