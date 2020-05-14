package com.test.answer.dao.mapper;

import com.test.answer.dao.model.PointsInfo;
import com.test.answer.dao.model.PointsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PointsInfoMapper {
    int countByExample(PointsInfoExample example);

    int deleteByExample(PointsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointsInfo record);

    int insertSelective(PointsInfo record);

    List<PointsInfo> selectByExampleWithRowbounds(PointsInfoExample example, RowBounds rowBounds);

    List<PointsInfo> selectByExample(PointsInfoExample example);

    PointsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointsInfo record, @Param("example") PointsInfoExample example);

    int updateByExample(@Param("record") PointsInfo record, @Param("example") PointsInfoExample example);

    int updateByPrimaryKeySelective(PointsInfo record);

    int updateByPrimaryKey(PointsInfo record);
}