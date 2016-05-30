package com.shop.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by yuan on 16-5-28.
 */
public interface UserGroupDao {


    /**
     * 添加用户进默认的用户组
     * @param userId 用户id
     * @return
     */
    public int addUserToDefaultGroup(@Param("userId")Integer userId);

}
