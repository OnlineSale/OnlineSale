package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.model.Standard;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer standardid);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer standardid);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
    
    //补充
    List selectBySpecificationId(@Param("specificationId") Integer specificationId);
}