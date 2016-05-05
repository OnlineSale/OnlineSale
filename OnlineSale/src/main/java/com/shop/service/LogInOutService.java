package com.shop.service;

import com.shop.model.LoginInfo;
import com.shop.model.UserInfo;

/**
 * Created by yuan on 16-5-5.
 */
public interface LogInOutService {
    /**
     * 提供用户登陆服务
     * @param loginInfo
     * @return 登陆成功则返回非null的User对象,反之返回null
     */
    public UserInfo login(LoginInfo loginInfo);
}
