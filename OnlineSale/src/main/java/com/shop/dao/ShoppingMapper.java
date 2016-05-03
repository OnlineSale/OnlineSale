package com.shop.dao;

import com.shop.model.Shopping;

public interface ShoppingMapper {
    int deleteByPrimaryKey(Integer shoppingid);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(Integer shoppingid);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}