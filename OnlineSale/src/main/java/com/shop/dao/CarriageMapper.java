package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.model.Carriage;

public interface CarriageMapper {
    int deleteByPrimaryKey(Integer carriageid);

    int insert(Carriage record);

    int insertSelective(Carriage record);

    Carriage selectByPrimaryKey(Integer carriageid);

    int updateByPrimaryKeySelective(Carriage record);

    int updateByPrimaryKey(Carriage record);

    //补充  by chuankun
    
    Carriage selectByName(@Param("name") String name);
    List selectAll();
}