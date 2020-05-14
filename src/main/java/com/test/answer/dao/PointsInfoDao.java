package com.test.answer.dao;

import com.test.answer.dao.mapper.PointsInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointsInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(PointsInfoDao.class);

    @Autowired
    private PointsInfoMapper mapper;

    //TODO...

}
