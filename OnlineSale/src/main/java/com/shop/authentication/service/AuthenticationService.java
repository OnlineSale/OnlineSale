package com.shop.authentication.service;

import com.shop.model.UserInfo;

import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-5-5.
 */
public interface AuthenticationService {
    public final static int ERROR=1;
    public final static int DENY=2;
    public final static int SUCCESS=3;
    public boolean authenticateForLogin(UserInfo userInfo, HttpSession session);
    public int authenticatePermission(HttpSession session);

    void clearAuthenticationForLogout(HttpSession session);
}
