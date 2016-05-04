package com.shop.dao;

import com.shop.model.Standard;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer standardid);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer standardid);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}