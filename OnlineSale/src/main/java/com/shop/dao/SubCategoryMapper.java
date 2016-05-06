package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.model.Category;
import com.shop.model.SubCategory;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer subcategoryid);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    SubCategory selectByPrimaryKey(Integer subcategoryid);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);
    //补充
    SubCategory selectByName(@Param("name")String name);
    List selectByCategoryId(@Param("id") Integer id);
}