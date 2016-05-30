package com.shop.controller;

import com.shop.model.User;
import com.shop.service.OrderService;
import com.shop.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dell on 2016/5/24.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

//    @RequestMapping("/create")
//    @ResponseBody
//    public Object createOrder(String remark,int userid,){
//
//    }
    @RequestMapping("/show")
    @ResponseBody
    public Object showOrder(User user) {
        if (user == null){
            return Message.getMessage(0, "用户为空", "");
        }
        return orderService.showOrder(user);
    }
}
