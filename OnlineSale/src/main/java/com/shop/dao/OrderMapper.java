package com.shop.dao;

import com.shop.bean.OrderBean;
import com.shop.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //补充
    List<Order> findOrderByUserId(@Param("userid")Integer userid);

    OrderBean selectByOrderId(String orderid);
}