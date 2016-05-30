package com.shop.dao;

import com.shop.model.DefaultAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DefaultAddressMapper {
    int deleteByPrimaryKey(Integer defaultAddressId);

    int insert(DefaultAddress record);

    int insertSelective(DefaultAddress record);

    DefaultAddress selectByPrimaryKey(Integer defaultAddressId);

    int updateByPrimaryKeySelective(DefaultAddress record);

    int updateByPrimaryKey(DefaultAddress record);
    
    //补充
    DefaultAddress selectUserDefaultAddress(@Param("userId")Integer userId);
    List selectByUserId(@Param("userId")Integer userId);

    int deleteByKeyAndUserId(@Param("userId")Integer userId,@Param("defaultAddressId")Integer defaultAddressId);
}