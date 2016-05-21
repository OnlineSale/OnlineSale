package com.shop.service;

/**
 * Created by yuan on 16-5-3.
 */
public interface SMSService {
    /**
     * 发送短信验证码
     * @param phoneNumber 接收的手机号
     * @return 短信验证码
     */
    public String sendValidMessage(String phoneNumber) ;

}
