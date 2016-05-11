package com.shop.service;

import com.shop.model.LoginInfo;
import com.shop.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-5-5.
 */
public interface LogInOutService {
    /**
     * 提供用户登陆服务
     * @param loginInfo
     * @param session
     * @return 登陆成功则返回非null的User对象,反之返回null
     */
    public UserInfo login(LoginInfo loginInfo, HttpSession session);

    /**
     * 生成新验证码
     * @param request
     * @param response
     * @param session
     */
    public void generateNewValidCode(HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
