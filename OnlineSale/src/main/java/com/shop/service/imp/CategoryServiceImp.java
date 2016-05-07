package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CategoryMapper;
import com.shop.model.Category;
import com.shop.service.CategoryService;

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

	public int addCategory(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(record);
	}

	public int updateCategory(Category record) {
		// TODO Auto-generated method stub
		
		return categoryMapper.updateByPrimaryKey(record);
	}

	public int deleteCateGory(Category record) {
		// TODO Auto-generated method stub
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
