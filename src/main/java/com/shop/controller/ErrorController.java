package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuan on 16-5-26.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    public static final String keyStatus="status";
    public static final String keyData="data";
    public static final String keyError="error";

    @RequestMapping("/500")
    @ResponseBody
    Object handler500Error(){
        Map<String,Object> result=new HashMap<String, Object>();
        result.put(keyStatus,"500");
        result.put(keyData,null);
        result.put(keyError,"服务器错误");
        return result;
    }

    @RequestMapping("/404")
    @ResponseBody
    Object handler404Error(){
        Map<String,Object> result=new HashMap<String, Object>();
        result.put(keyStatus,"404");
        result.put(keyData,null);
        result.put(keyError,"找不到请求的资源");
        return result;
    }

    @RequestMapping("/400")
    @ResponseBody
    Object handler400Error(){
        Map<String,Object> result=new HashMap<String, Object>();
        result.put(keyStatus,"400");
        result.put(keyData,null);
        result.put(keyError,"参数错误");
        return result;
    }


}
