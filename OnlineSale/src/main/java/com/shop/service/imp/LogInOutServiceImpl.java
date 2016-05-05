package com.shop.service.imp;

import com.shop.dao.UserInfoDao;
import com.shop.model.LoginInfo;
import com.shop.model.UserInfo;
import com.shop.service.LogInOutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuan on 16-5-5.
 */
@Service
public class LogInOutServiceImpl implements LogInOutService {

    @Resource
    UserInfoDao userInfoDao;

    public UserInfo login(LoginInfo loginInfo) {
        UserInfo userInfo=null;
        String userName=loginInfo.getUserName();
        String passWord=loginInfo.getPassWord();
        userInfo=userInfoDao.getUserInfo(userName,passWord);
        return userInfo;
    }
}
