package com.shop.service;

import java.util.List;

import com.shop.model.Good;

public interface GoodService {

	public void addGood(Good good);
	public void updateGood(Good good);
	public void deleteGood(Integer id);
	public List findBySubcategoryId(Integer subCategoryId);
	public List findByCategoryId(Integer categoryId);
}
