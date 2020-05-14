package com.test.answer.dao.mapper;

import com.test.answer.dao.model.PointsRelation;
import com.test.answer.dao.model.PointsRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PointsRelationMapper {
    int countByExample(PointsRelationExample example);

    int deleteByExample(PointsRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointsRelation record);

    int insertSelective(PointsRelation record);

    List<PointsRelation> selectByExampleWithRowbounds(PointsRelationExample example, RowBounds rowBounds);

    List<PointsRelation> selectByExample(PointsRelationExample example);

    PointsRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointsRelation record, @Param("example") PointsRelationExample example);

    int updateByExample(@Param("record") PointsRelation record, @Param("example") PointsRelationExample example);

    int updateByPrimaryKeySelective(PointsRelation record);

    int updateByPrimaryKey(PointsRelation record);
}