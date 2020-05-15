package com.test.answer.dao;

import com.test.answer.dao.mapper.PointsRelationMapper;
import com.test.answer.dao.model.PointsRelation;
import com.test.answer.dao.model.PointsRelationExample;
import com.test.answer.utils.RowBoundsUtil;
import com.test.answer.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

@Repository
public class PointsRelationDao {

    private static final Logger logger = LoggerFactory.getLogger(PointsRelationDao.class);

    @Autowired
    private PointsRelationMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(PointsRelation record) {
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
    public int updateData(Integer recordId, PointsRelation record) {
        int cnt = 0;
        try {
            PointsRelationExample example = new PointsRelationExample();
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
            PointsRelationExample example = new PointsRelationExample();
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
    public List<PointsRelation> queryPage(int pageNo, int pageSize, String pName) {
        int offset = (pageNo-1)*pageSize;

        PointsRelationExample example = new PointsRelationExample();

        List<PointsRelation> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param pName
     * @return
     */
    public int queryPageTotal(String pName) {
        PointsRelationExample example = new PointsRelationExample();

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<PointsRelation> queryList(PointsRelation condition) {
        List<PointsRelation> result = null;

        PointsRelationExample example = new PointsRelationExample();
        PointsRelationExample.Criteria criteria = example.createCriteria();

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
    public List<PointsRelation> listAll() {
        PointsRelationExample example = new PointsRelationExample();

        List<PointsRelation> result = mapper.selectByExample(example);
        return result;
    }


    /**
     * 查询与起点距离最短的点
     * @return
     */
    public PointsRelation queryShortPointRelation(int startPoint, int distanceRadius, List<Integer> excludePoints) {
        PointsRelation relation = null;

        PointsRelationExample example = new PointsRelationExample();
        PointsRelationExample.Criteria criteria = example.createCriteria();
        criteria.andStartPointEqualTo(startPoint);
        criteria.andEndPointNotIn(excludePoints);
        criteria.andDistanceLessThanOrEqualTo(distanceRadius);
        example.setOrderByClause("distance asc");

        List<PointsRelation> result = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            relation = result.get(0);
        }

        return relation;
    }

    /**
     * 查询两点间的距离
     * @return
     */
    public PointsRelation queryPointRelation(int startPoint, int endPoint) {
        PointsRelation relation = null;

        PointsRelationExample example = new PointsRelationExample();
        PointsRelationExample.Criteria criteria = example.createCriteria();
        criteria.andStartPointEqualTo(startPoint);
        criteria.andEndPointEqualTo(endPoint);

        List<PointsRelation> result = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            relation = result.get(0);
        }

        return relation;
    }
}
