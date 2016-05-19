package com.shop.service.imp;

import com.shop.bean.ShoppingBean;
import com.shop.dao.GoodMapper;
import com.shop.dao.ShoppingMapper;
import com.shop.dao.UserMapper;
import com.shop.model.Good;
import com.shop.model.Shopping;
import com.shop.model.User;
import com.shop.service.ShoppingService;
import com.shop.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* Created by dell on 2016/5/12.
*/
@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private UserMapper userMapper;

    private Shopping shopping;
    @Override
    public Object addGoodToShopping(User user,int goodid,int number) {
        //先查看user是否登录   还要添加代码,拦截user
        Good good = goodMapper.selectByPrimaryKey(goodid);
        int userId = user.getUserid();
        if (good == null) {
            return Message.getMessage(0,"找不到这个商品","");
        } else {
            shopping  = shoppingMapper.findShoppingByUserIdAndGoodId(userId,goodid);
            System.out.println(shopping.toString());
            if (shopping == null) {
                shopping = new Shopping();
                shopping.setGoodid(goodid);
                shopping.setUserid(user.getUserid());
                shopping.setGoodnumber(number);
                shopping.setShoptime(new Date().toString());
                shoppingMapper.insert(shopping);
            } else {
                number = number + shopping.getGoodnumber();
                shopping.setGoodnumber(number);
                shoppingMapper.updateByPrimaryKey(shopping);
            }
            List<ShoppingBean> shoppingBeans = shoppingMapper.findShoppingByUserId(userId);
            if (shoppingBeans.size() <= 0){
                return Message.getMessageParmNull();
            }else{
                return Message.getMessage(1, "",shoppingBeans);
            }
        }
    }

    @Override
    public Object deleteGoodFromShopping(User user, int goodid) {
        //拦截user
        int userId = user.getUserid();
        int result = shoppingMapper.deleteByPrimaryKey(userId);
        if (result > 0){
            List<ShoppingBean> shoppingBeans = shoppingMapper.findShoppingByUserId(userId);
            return Message.getMessage(1,"",shoppingBeans);
        }else {
            return Message.getMessage(0,"删除购物车失败","");
        }
    }

    @Override
    public Object showShopping(User user) {
        //拦截user
        int userId = user.getUserid();
        List<ShoppingBean> shoppingBeans = shoppingMapper.findShoppingByUserId(userId);
        if (shoppingBeans.size() <= 0) {
            return Message.getMessageParmNull();
        } else {
            return Message.getMessage(1, "", shoppingBeans);
        }
    }
}
