package com.shop.dao;

import com.shop.model.RegisterInfo;
import com.shop.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuan on 16-5-3.
 */
public interface UserInfoDao {
    public Integer getSumOfSameUserName(@Param("userName") String userName);

    int addNewUser(RegisterInfo registerInfo);

    public UserInfo getUserInfo(@Param("userName")String userName,@Param("passWord")String passWord);
}
