package com.shop.service;

import java.util.List;

import com.shop.model.SubCategory;

public interface SubCategoryService {

	public void addSubCategory(SubCategory record);
	public void updateSubCategory(SubCategory record);
	public  SubCategory findByName(String name);
	public List findByCategory(Integer id);
	public void deleteSubCategory(Integer id);
}
