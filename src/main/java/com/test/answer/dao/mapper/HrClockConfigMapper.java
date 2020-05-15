package com.test.answer.dao.mapper;

import com.test.answer.dao.model.HrClockConfig;
import com.test.answer.dao.model.HrClockConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HrClockConfigMapper {
    int countByExample(HrClockConfigExample example);

    int deleteByExample(HrClockConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrClockConfig record);

    int insertSelective(HrClockConfig record);

    List<HrClockConfig> selectByExampleWithRowbounds(HrClockConfigExample example, RowBounds rowBounds);

    List<HrClockConfig> selectByExample(HrClockConfigExample example);

    HrClockConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrClockConfig record, @Param("example") HrClockConfigExample example);

    int updateByExample(@Param("record") HrClockConfig record, @Param("example") HrClockConfigExample example);

    int updateByPrimaryKeySelective(HrClockConfig record);

    int updateByPrimaryKey(HrClockConfig record);
}