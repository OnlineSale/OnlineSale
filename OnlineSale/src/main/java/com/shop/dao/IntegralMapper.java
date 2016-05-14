package com.shop.dao;

import org.apache.ibatis.annotations.Param;

import com.shop.model.Integral;

public interface IntegralMapper {

	public Integral selectById(int id);
	public int delete(Integral integral);
	public int deleteById(int id);
	public int save(Integral integral);
	public Integral findByUserId(@Param("userid") Integer userid);
	public int update(Integral integral);
	
}
