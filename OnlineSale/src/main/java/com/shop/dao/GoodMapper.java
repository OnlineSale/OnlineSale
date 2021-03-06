package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.model.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer goodid);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer goodid);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
    
    //补充
    List selectBySubCategoryId(@Param("subCategoryId") Integer subCategoryId);
    List selectGoodsByState(@Param("state") String state,@Param("page") Integer page,@Param("number")Integer number);
    
    int selectGoodsNumber(@Param("state")String state);
}