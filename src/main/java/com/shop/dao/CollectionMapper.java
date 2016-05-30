package com.shop.dao;

import com.shop.model.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}