package com.shop.controller;

import com.shop.model.RegisterInfo;
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
public class RegisterController {
    public static final String KEY_VALID_CODE="validCode";

    @Resource
    RegisterService registerService;

    @RequestMapping("register")
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
        errorResult.put("errors",errorList);
        errorResult.put("status","faild");
        return errorResult;
    }


}
