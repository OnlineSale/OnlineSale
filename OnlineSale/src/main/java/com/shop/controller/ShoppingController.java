package com.shop.controller;

import com.shop.model.User;
import com.shop.service.ShoppingService;
import com.shop.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Created by dell on 2016/5/12.
*/
@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

//    @RequestMapping("/")

    @RequestMapping("add/{goodid}")
    @ResponseBody
    public Object addGoodToShopping(@PathVariable int goodid,int number,User user) {
        //判断用户是否登录
//        User user = UserThreadLocal.get();
//        if (user == null) {
//        }else {
//            this.shoppingService.addGoodToShopping(user,goodid,number);
//        }
        return shoppingService.addGoodToShopping(user,goodid,number);
    }

    @RequestMapping("/delete/{goodid}")
    @ResponseBody
    public Object deleteGoodFromShopping(@PathVariable("goodid")int goodid,User user) {
        return shoppingService.deleteGoodFromShopping(user,goodid);
    }

    @RequestMapping("/show")
    @ResponseBody
    public Object showShopping(User user){
        //获取当前的用户user,如果没有登录
        if(user == null){
            return Message.getMessageParmNull();
        }
        return shoppingService.showShopping(user);
    }
}
