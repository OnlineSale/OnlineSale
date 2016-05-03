package com.shop.dao;

import com.shop.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}