package com.shop.dao;

import com.shop.model.Carriage;

public interface CarriageMapper {
    int deleteByPrimaryKey(Integer carriageid);

    int insert(Carriage record);

    int insertSelective(Carriage record);

    Carriage selectByPrimaryKey(Integer carriageid);

    int updateByPrimaryKeySelective(Carriage record);

    int updateByPrimaryKey(Carriage record);
}