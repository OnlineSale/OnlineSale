package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.GoodMapper;
import com.shop.dao.SubCategoryMapper;
import com.shop.model.Category;
import com.shop.model.Good;
import com.shop.model.SubCategory;
import com.shop.service.SubCategoryService;

/**
 * 创建小类
 * @author chuankun
 *@2016年5月6日 上午11:00:25
 * email:yichuankun@qq.com
 */
@Service
public class SubCategoeyServiceImp implements SubCategoryService{

	@Resource
	private SubCategoryMapper subCategoryMapper;
	@Resource
	private GoodMapper goodMapper;
	
	public void addSubCategory(SubCategory record){
		subCategoryMapper.insert(record);
	}

	public void updateSubCategory(SubCategory record) {
		// TODO Auto-generated method stub
		subCategoryMapper.updateByPrimaryKey(record);
	}

	public SubCategory findByName(String name) {
		// TODO Auto-generated method stub
		return subCategoryMapper.selectByName(name);
	}

	public List findByCategory(Integer id) {
		// TODO Auto-generated method stub
		return subCategoryMapper.selectByCategoryId(id);
	}

	public void deleteSubCategory(Integer id) {
		// TODO Auto-generated method stub
	
			subCategoryMapper.deleteByPrimaryKey(id);
			List<Good> list  = goodMapper.selectBySubCategoryId(id);
			for(Good good:list){
				goodMapper.deleteByPrimaryKey(good.getGoodid());
			}
		
	}

	
}
