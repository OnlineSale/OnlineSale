package com.shop.service;

import com.shop.model.User;

/**
* Created by dell on 2016/5/12.
*/
public interface ShoppingService {
    Object addGoodToShopping(User user,int goodid,int number);
    Object deleteGoodFromShopping(User user,int goodid);
    Object showShopping(User user);
}
