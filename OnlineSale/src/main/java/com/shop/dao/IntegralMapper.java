package com.shop.dao;

import com.shop.model.Integral;

public interface IntegralMapper {

	public Integral selectById(int id);
	public int delete(Integral integral);
	public int deleteById(int id);
	public int save(Integral integral);
}
