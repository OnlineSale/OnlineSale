package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.model.DefaultAddress;

public interface DefaultAddressMapper {
    int deleteByPrimaryKey(Integer defaultAddressId);

    int insert(DefaultAddress record);

    int insertSelective(DefaultAddress record);

    DefaultAddress selectByPrimaryKey(Integer defaultAddressId);

    int updateByPrimaryKeySelective(DefaultAddress record);

    int updateByPrimaryKey(DefaultAddress record);
    
    //补充
    DefaultAddress selectUserDefaultAddress(@Param("userId")Integer userId);
    List selectByUserId(@Param("userId")Integer userId);
}