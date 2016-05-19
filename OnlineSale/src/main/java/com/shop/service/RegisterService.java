package com.shop.service;

import com.shop.model.RegisterInfo;

/**
 * 提供用户注册相关的服务
 * Created by yuan on 16-5-3.
 */
public interface RegisterService {

    /**
     * 注册用户
     * @param registerInfo
     * @return
     */
    public Object register(RegisterInfo registerInfo);

    /**
     * 检查用户名格式是否正确以及是否与数据库已有的用户名重复
     * @param userName
     * @return
     */
    public Object checkUserName(String userName);
}
