package com.shop.dao;

import com.shop.model.Specification;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer specificationid);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer specificationid);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}