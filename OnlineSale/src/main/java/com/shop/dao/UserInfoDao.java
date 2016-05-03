package com.shop.dao;

import com.shop.model.RegisterInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuan on 16-5-3.
 */
public interface UserInfoDao {
    public Integer getSumOfSameUserName(@Param("userName") String userName);

    void addNewUser(RegisterInfo registerInfo);
}
