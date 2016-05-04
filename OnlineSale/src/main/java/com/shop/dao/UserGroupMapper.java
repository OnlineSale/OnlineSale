package com.shop.dao;

import com.shop.model.UserGroup;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}