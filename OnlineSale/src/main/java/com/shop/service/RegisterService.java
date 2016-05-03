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
}
