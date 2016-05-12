package com.shop.dao;

import com.shop.model.DefaultAddress;

public interface DefaultAddressMapper {
    int deleteByPrimaryKey(Integer defaultAddressId);

    int insert(DefaultAddress record);

    int insertSelective(DefaultAddress record);

    DefaultAddress selectByPrimaryKey(Integer defaultAddressId);

    int updateByPrimaryKeySelective(DefaultAddress record);

    int updateByPrimaryKey(DefaultAddress record);
}