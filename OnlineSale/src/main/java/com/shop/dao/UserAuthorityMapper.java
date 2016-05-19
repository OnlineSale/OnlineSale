package com.shop.dao;

import com.shop.model.UserAuthority;

public interface UserAuthorityMapper {
    int deleteByPrimaryKey(Integer usergroup);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(Integer usergroup);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);
}