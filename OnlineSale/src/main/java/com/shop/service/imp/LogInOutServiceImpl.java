package com.shop.service.imp;

import com.shop.dao.UserInfoDao;
import com.shop.model.LoginInfo;
import com.shop.model.UserInfo;
import com.shop.service.LogInOutService;
import com.shop.util.MD5tool;
import com.shop.util.ValidCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-5-5.
 */
@Service
public class LogInOutServiceImpl implements LogInOutService {

    public static final String KEY_VALID_CODE="loginValidCode";


    @Resource
    UserInfoDao userInfoDao;

    @Autowired
    ValidCodeGenerator validCodeGenerator;

    public UserInfo login(LoginInfo loginInfo,HttpSession session) {
        UserInfo userInfo=null;
        if(!checkValidCode(loginInfo,session)){
            return userInfo;
        }
        String userName=loginInfo.getUserName();
        String passWord=loginInfo.getPassWord();
        passWord= MD5tool.createPassword(passWord);
        userInfo=userInfoDao.getUserInfo(userName,passWord);
        return userInfo;
    }

    /**
     * 生成新的登陆验证码
     * @param request
     * @param response
     * @param session
     */
    public void generateNewValidCode(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String validCode=validCodeGenerator.getRandcode(request,response);
        session.setAttribute(KEY_VALID_CODE,validCode);
    }

    /**
     * 检查登陆验证码
     * @param loginInfo
     * @param session
     * @return
     */
    private boolean checkValidCode(LoginInfo loginInfo,HttpSession session){
        String checkedValidCode=loginInfo.getValidCode();
        String realValidCode=(String)session.getAttribute(KEY_VALID_CODE);
        session.removeAttribute(KEY_VALID_CODE);
        return realValidCode!=null&&realValidCode.equalsIgnoreCase(checkedValidCode);
    }
}
