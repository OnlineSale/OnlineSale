package com.shop.service;

import java.util.List;

import com.shop.bean.GoodBean;
import com.shop.model.Good;

public interface GoodService {

	public void addGood(Good good);
	public void updateGood(GoodBean record);
	public void deleteGood(Integer id);
	public List findBySubcategoryId(Integer subCategoryId);
	public List findByCategoryId(Integer categoryId);
	
	public List findByState(String state,Integer page,Integer number);
	public String changeGoodState(Integer goodId,String state);
	public int getGoodsNumber(String state);
}
