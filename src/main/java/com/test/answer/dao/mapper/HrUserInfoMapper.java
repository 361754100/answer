package com.test.answer.dao.mapper;

import com.test.answer.dao.model.HrUserInfo;
import com.test.answer.dao.model.HrUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HrUserInfoMapper {
    int countByExample(HrUserInfoExample example);

    int deleteByExample(HrUserInfoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(HrUserInfo record);

    int insertSelective(HrUserInfo record);

    List<HrUserInfo> selectByExampleWithRowbounds(HrUserInfoExample example, RowBounds rowBounds);

    List<HrUserInfo> selectByExample(HrUserInfoExample example);

    HrUserInfo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") HrUserInfo record, @Param("example") HrUserInfoExample example);

    int updateByExample(@Param("record") HrUserInfo record, @Param("example") HrUserInfoExample example);

    int updateByPrimaryKeySelective(HrUserInfo record);

    int updateByPrimaryKey(HrUserInfo record);
}