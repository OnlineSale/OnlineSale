package com.shop.service;

import com.shop.model.User;

/**
 * Created by dell on 2016/5/24.
 */

public interface OrderService {

    Object showOrder(User user);
    Object showOrderById(int orderid);

}
