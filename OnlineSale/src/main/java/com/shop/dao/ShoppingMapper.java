package com.shop.dao;

import com.shop.bean.ShoppingBean;
import com.shop.model.Shopping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingMapper {
    int deleteByPrimaryKey(Integer shoppingid);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(Integer shoppingid);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);

    Shopping findShoppingByUserIdAndGoodId(@Param("userid")int  userid,@Param("goodid")int goodid);

    List<ShoppingBean> findShoppingByUserId(@Param("userid")int userid);

}