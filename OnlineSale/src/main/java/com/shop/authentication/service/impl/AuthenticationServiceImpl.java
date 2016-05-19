package com.shop.authentication.service.impl;

import com.shop.authentication.model.AuthenticateInfo;
import com.shop.authentication.service.AuthenticationService;
import com.shop.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-5-5.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final static String KEY_AUTHENTICATION="authenticationKey";
    public boolean authenticateForLogin(UserInfo userInfo, HttpSession session){
        if(userInfo==null)
            return false;
        AuthenticateInfo authenticateInfo=new AuthenticateInfo();
        authenticateInfo.setUserId(userInfo.getUserId());
        session.setAttribute(KEY_AUTHENTICATION,authenticateInfo);
        return true;
    }

    public int authenticatePermission(HttpSession session) {
        AuthenticateInfo authenticateInfo=null;
        try{
            authenticateInfo= (AuthenticateInfo) session.getAttribute(KEY_AUTHENTICATION);
            if(authenticateInfo==null)
                return ERROR;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public void clearAuthenticationForLogout(HttpSession session) {
        session.removeAttribute(KEY_AUTHENTICATION);
        session.invalidate();
    }
}
