package com.shop.controller;

import com.shop.model.RegisterInfo;
import com.shop.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-5-3.
 */
@Controller
public class RegisterController {
    public static final String KEY_VALID_CODE="validCode";

    @Resource
    RegisterService registerService;

    @RequestMapping("signup")
    @ResponseBody
    public Object handleSignUp(RegisterInfo registerInfo, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){

        }
        String realValidCode=(String)session.getAttribute(KEY_VALID_CODE);
        registerInfo.setRealValidCode(realValidCode);
        return registerService.register(registerInfo);
    }


}
