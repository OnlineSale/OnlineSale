package com.shop.controller;

import com.shop.authentication.service.AuthenticationService;
import com.shop.model.*;
import com.shop.service.LogInOutService;
import com.shop.service.RegisterService;
import com.shop.service.SMSService;
import com.shop.util.BindingResultErrorResolver;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public static final String KEY_PHONE="phone";
    public static final String KEY_RESET_VALIDE_CODE="resetValidCode";
    public static final String KEY_RESET_PHONE="resetPhone";

    public static final String STATUS_SUCCESS="success";
    public static final String STATUS_FAILED="fail";
    public static final String STATUS_AUTHENTICATION_FAIL="authenticationFail";
    public static final String[] ERRORS_AUTHENTICATION={"authentication failed"};

    public static final String KEY_USER_INFO="userInfo";

    @Resource
    RegisterService registerService;

    @Resource
    LogInOutService logInOutService;

    @Resource
    AuthenticationService authenticationService;

    @Resource
    SMSService smsService;

    @RequestMapping("/signup")
    @ResponseBody
    public Object handleSignUp(@Valid RegisterInfo registerInfo, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return getErrorResult(bindingResult);
        }
        String realValidCode=(String)session.getAttribute(KEY_VALID_CODE);
        registerInfo.setRealValidCode(realValidCode);
        String phoneNum=(String)session.getAttribute(KEY_PHONE);
        registerInfo.setPhoneNumber(phoneNum);
        return registerService.register(registerInfo);
    }



    @RequestMapping("/login")
    @ResponseBody
    public Object login(@Valid LoginInfo loginInfo, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return getErrorResult(bindingResult);
        }
        Map<String,Object> result=new HashMap<String, Object>();
        UserInfo userInfo=logInOutService.login(loginInfo,session);
        if(!authenticationService.authenticateForLogin(userInfo,session)){
            result.put(KEY_STATUS,STATUS_FAILED);
            return result;
        }
        result.put(KEY_STATUS,STATUS_SUCCESS);
        result.put(KEY_USER_INFO,userInfo);
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
        result.put(KEY_STATUS,STATUS_AUTHENTICATION_FAIL);
        result.put(KEY_ERRORS,ERRORS_AUTHENTICATION);
        //result.put(KEY_RETURN_URL,RETURN_URL);
        return result;
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

    @RequestMapping("/getNewValidCode")
    public void getNewValidCode(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        logInOutService.generateNewValidCode(request,response,session);
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Object checkUserName(String userName){
        return registerService.checkUserName(userName);
    }

    @RequestMapping("/sendSMSValidCode")
    @ResponseBody
    public Object sendSMSValidCode(@RequestParam("phone") String phoneNum, HttpSession session){
        Map<String ,Object> result=new HashMap<String, Object>();
        String realValidCode=smsService.sendValidMessage(phoneNum);
        if(realValidCode==null){
            result.put(KEY_STATUS,STATUS_FAILED);
            return result;
        }
        session.setAttribute(KEY_VALID_CODE,realValidCode);
        session.setAttribute(KEY_PHONE,phoneNum);
        result.put(KEY_STATUS,STATUS_SUCCESS);
        return result;
    }

    @RequestMapping("/sendResetValidCode")
    @ResponseBody
    public Object sendResetValidCode(@RequestParam("userName")String userName,HttpSession session){
        Result result=new Result();
        String phone=registerService.getPhoneNumberByUserName(userName);
        if(phone==null){
            result.setStatusFail();
            result.setError("该用户不存在");
        }else{
            String realValidCode=smsService.sendValidMessage(phone);
            result.setStatusSuccess();
            session.setAttribute(KEY_RESET_VALIDE_CODE,realValidCode);
            session.setAttribute(KEY_RESET_PHONE,phone);
        }
        return result;
    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    public Object resetPassword(@Valid ResetInfo resetInfo,BindingResult bindingResult,HttpSession session){
        Result result=new Result();
        if(bindingResult.hasErrors()){
            result.setStatusFail();
            String error= BindingResultErrorResolver.getErrorFromBindingResult(bindingResult);
            result.setError(error);
            return result;
        }
        String realValidCode= (String) session.getAttribute(KEY_RESET_VALIDE_CODE);
        String resetPhone=(String)session.getAttribute(KEY_RESET_PHONE);
        resetInfo.setRealValidCode(realValidCode);
        resetInfo.setResetPhone(resetPhone);
        if(registerService.resetPassword(resetInfo)){
            result.setStatusSuccess();
        }else{
            result.setStatusFail();
            result.setError("重置失败");
        }
        return result;
    }
}
