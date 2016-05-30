package com.shop.service.imp;

import com.shop.dao.OrderMapper;
import com.shop.model.Order;
import com.shop.model.User;
import com.shop.service.OrderService;
import com.shop.util.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dell on 2016/5/24.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Object showOrder(User user) {
        int userId = user.getUserid();
        List<Order> orders = orderMapper.findOrderByUserId(userId);
        if(orders.size() == 0){
            return Message.getMessage(0, "没有订单", "");
        }
        return Message.getMessage(1, "'", orders);
    }

    @Override
    public Object showOrderById(int orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }
}
