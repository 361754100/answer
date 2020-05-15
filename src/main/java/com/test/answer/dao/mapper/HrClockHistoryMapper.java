package com.test.answer.dao.mapper;

import com.test.answer.dao.dto.HrClockHistoryReportDto;
import com.test.answer.dao.model.HrClockHistory;
import com.test.answer.dao.model.HrClockHistoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HrClockHistoryMapper {
    int countByExample(HrClockHistoryExample example);

    int deleteByExample(HrClockHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrClockHistory record);

    int insertSelective(HrClockHistory record);

    List<HrClockHistory> selectByExampleWithRowbounds(HrClockHistoryExample example, RowBounds rowBounds);

    List<HrClockHistory> selectByExample(HrClockHistoryExample example);

    HrClockHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrClockHistory record, @Param("example") HrClockHistoryExample example);

    int updateByExample(@Param("record") HrClockHistory record, @Param("example") HrClockHistoryExample example);

    int updateByPrimaryKeySelective(HrClockHistory record);

    int updateByPrimaryKey(HrClockHistory record);

    /**
     * 考勤记录统计
     * @param params
     * @return
     */
    List<HrClockHistoryReportDto> reportClockHistory(Map<String, Object> params);
}