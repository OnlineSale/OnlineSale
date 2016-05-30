package com.shop.service.imp;

import com.shop.service.SMSService;
import com.shop.util.JavaSmsApi;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * Created by yuan on 16-5-3.
 */
@Service
public class SMSServiceImpl implements SMSService {
    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后获取
    String apikey = "4ae132c1fb5a12effbb0e4a2175dc654";
    String company="一千零一夜";


    String seedStr="0123456789";
    int validCodeLength=4;


    public String sendValidMessage(String phoneNumber){
        String message=generateValidMessage(validCodeLength);
        long tpl_id = 1;
        //设置对应的模板变量值
        try {
            String tpl_value = URLEncoder.encode("#code#", ENCODING) + "="
                    + URLEncoder.encode(message, ENCODING) + "&"
                    + URLEncoder.encode("#company#", ENCODING) + "="
                    + URLEncoder.encode(company, ENCODING);
            //模板发送的调用示例
            System.out.println(tpl_value);
            System.out.println(JavaSmsApi.tplSendSms(apikey, tpl_id, tpl_value, phoneNumber));
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return message;
    }

    /**
     * 生成随机手机验证码
     * @return
     */
    private String generateValidMessage(int size){
        StringBuffer sb=new StringBuffer();
        int len=seedStr.length();
        for(int i=0;i<size;i++){
            char c=seedStr.charAt((int)(Math.random()*len));
            sb.append(c);
        }
        return sb.toString();
    }

    public String sendResetValidMessage(String phoneNumber){
        return sendValidMessage(phoneNumber);
    }
}
