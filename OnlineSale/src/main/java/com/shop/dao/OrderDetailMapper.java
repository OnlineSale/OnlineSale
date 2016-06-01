package com.shop.dao;

import com.shop.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}