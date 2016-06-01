package com.shop.dao;

import com.shop.model.Logistics;

public interface LogisticsMapper {
    int deleteByPrimaryKey(String logisticsid);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    Logistics selectByPrimaryKey(String logisticsid);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKey(Logistics record);
}