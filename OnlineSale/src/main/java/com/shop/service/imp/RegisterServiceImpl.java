package com.shop.service.imp;

import com.shop.dao.UserInfoDao;
import com.shop.model.RegisterInfo;
import com.shop.service.RegisterService;
import com.shop.util.MD5tool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuan on 16-5-3.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private static final String KEY_RESULT_STATE="status";
    private static final String STATE_SUCCESS="success";
    private static final String STATE_FAILD="failed";

    private static final String KEY_ERROR_INFO="errors";
    private static final String[] ERROR_DUPLICATE_USER_NAME={"已经存在重复的用户名"};
    private static final String[] ERROR_VALID_CODE={"验证码错误"};
    @Resource
    UserInfoDao userInfoDao;

    public Object register(RegisterInfo registerInfo) {
        Map<String,Object> result=new HashMap<String, Object>();
        //判断短信验证码是否正确
        /*String realValidCode=registerInfo.getRealValidCode();
        String checkedValidCode=registerInfo.getValidCode();
        if(false&&!checkedValidCode.equals(realValidCode)){
            result.put(KEY_RESULT_STATE,STATE_FAILD);
            result.put(KEY_ERROR_INFO,ERROR_VALID_CODE);
            return result;
        }*/
        //判断数据库是否已经存在重复的用户名
        int sum=userInfoDao.getSumOfSameUserName(registerInfo.getUserName());
        if(sum>0){
            result.put(KEY_RESULT_STATE,STATE_FAILD);
            result.put(KEY_ERROR_INFO,ERROR_DUPLICATE_USER_NAME);
            return result;
        }
        String passWord=registerInfo.getPassWord();
        passWord= MD5tool.createPassword(passWord);
        registerInfo.setPassWord(passWord);
        userInfoDao.addNewUser(registerInfo);
        result.put(KEY_RESULT_STATE,STATE_SUCCESS);
        result.put(KEY_ERROR_INFO,null);
        return result;
    }
}
