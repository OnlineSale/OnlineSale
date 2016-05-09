package com.shop.service;

import java.util.List;

import com.shop.model.Category;

public interface CategoryService {

	public int addCategory(Category record);
	public int updateCategory(Category record);
	public int deleteCateGory(Integer id);
	public Category findByName(String categoryName);
	public List findAll();
}
