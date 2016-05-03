package com.shop.dao;

import com.shop.model.SubCategory;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer subcategoryid);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    SubCategory selectByPrimaryKey(Integer subcategoryid);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);
}