package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CategoryMapper;
import com.shop.model.Category;
import com.shop.model.SubCategory;
import com.shop.service.CategoryService;
import com.shop.service.SubCategoryService;

/**
 * 商品大类的实现
 * 主要有增加，删除，修改
 * @author chuankun
 *@2016年5月5日 下午10:19:45
 * email:yichuankun@qq.com
 */
@Service
public class CategoryServiceImp implements CategoryService{
	
	@Resource
	private CategoryMapper categoryMapper;
	@Resource
	private SubCategoryService subCategoryService;

	public int addCategory(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(record);
	}

	public int updateCategory(Category record) {
		// TODO Auto-generated method stub
		
		return categoryMapper.updateByPrimaryKey(record);
	}

	/* 
	 * 这样可能会造成系统资源较大消耗，后期可以考虑优化删除
	 * (non-Javadoc)
	 * @see com.shop.service.CategoryService#deleteCateGory(java.lang.Integer)
	 */
	public int deleteCateGory(Integer id) {
		// TODO Auto-generated method stub
		categoryMapper.deleteByPrimaryKey(id);
		List<SubCategory>  list  = subCategoryService.findByCategory(id);
		for(SubCategory record:list ){
			subCategoryService.deleteSubCategory(record.getSubcategoryid());
		}
		return 0;
	}

	public Category findByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByName(categoryName);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAll();
	}

	

}
