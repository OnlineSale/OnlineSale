package com.shop.controller;

import com.shop.authentication.service.AuthenticationService;
import com.shop.model.LoginInfo;
import com.shop.model.RegisterInfo;
import com.shop.model.UserInfo;
import com.shop.service.LogInOutService;
import com.shop.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuan on 16-5-3.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    public static final String KEY_VALID_CODE="validCode";
    public static final String KEY_STATUS="status";
    public static final String KEY_ERRORS="errors";
    public static final String STATUS_SUCCESS="success";
    public static final String STATUS_FAILED="failed";
    public static final String ERRORS_AUTHENTICATION="authentication failed";

    @Resource
    RegisterService registerService;

    @Resource
    LogInOutService logInOutService;

    @Resource
    AuthenticationService authenticationService;

    @RequestMapping("/signup")
    @ResponseBody
    public Object handleSignUp(@Valid RegisterInfo registerInfo, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return getErrorResult(bindingResult);
        }
        String realValidCode=(String)session.getAttribute(KEY_VALID_CODE);
        registerInfo.setRealValidCode(realValidCode);
        return registerService.register(registerInfo);
    }

    private Object getErrorResult(BindingResult bindingResult){
        Map<String,Object> errorResult=new HashMap<String, Object>();
        List<ObjectError> errors=bindingResult.getAllErrors();
        String errorMessage=null;
        List<String> errorList=new LinkedList<String>();
        for(ObjectError error:errors){
            errorMessage=error.getDefaultMessage();
            errorList.add(errorMessage);
        }
        errorResult.put(KEY_ERRORS,errorList);
        errorResult.put(KEY_STATUS,STATUS_FAILED);
        return errorResult;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@Valid LoginInfo loginInfo, BindingResult bindingResult, HttpSession session){
        Map<String,Object> result=new HashMap<String, Object>();
        UserInfo userInfo=logInOutService.login(loginInfo);
        if(!authenticationService.authenticateForLogin(userInfo,session)){
            result.put(KEY_STATUS,STATUS_FAILED);
            return result;
        }
        result.put(KEY_STATUS,STATUS_SUCCESS);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpSession session){
        Map<String,Object> result=new HashMap<String,Object>();
        authenticationService.clearAuthenticationForLogout(session);
        result.put(KEY_STATUS,STATUS_SUCCESS);
        return result;
    }

    @RequestMapping("/authenticateFailed")
    @ResponseBody
    public Object redirect(){
        Map<String,Object> result=new HashMap<String, Object>();
        result.put(KEY_STATUS,STATUS_FAILED);
        result.put(KEY_ERRORS,ERRORS_AUTHENTICATION);
        //result.put(KEY_RETURN_URL,RETURN_URL);
        return result;
    }


}
