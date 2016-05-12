package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.GoodBean;
import com.shop.dao.GoodMapper;
import com.shop.model.Good;
import com.shop.service.GoodService;

/**
 * @author chuankun
 *@2016年5月6日 下午8:19:16
 * email:yichuankun@qq.com
 */
@Service
public class GoodServiceImp implements GoodService{
	
	@Resource
	private GoodMapper goodMapper;

	public void addGood(Good good) {
		// TODO Auto-generated method stub
		goodMapper.insert(good);
	}
	
	

	public void deleteGood(Integer id) {
		// TODO Auto-generated method stub
		goodMapper.deleteByPrimaryKey(id);
	}

	public List findBySubcategoryId(Integer subCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}



	public void updateGood(GoodBean record) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByPrimaryKey(record.getGoodId());
		good.setClassid(record.getSubCategoryId());
		good.setGoodname(record.getGoodName());
		good.setStoke(record.getStoke());
		good.setGoodstate(record.getGoodState());
		good.setGooddesc(record.getGoodDesc());
		good.setBrand(record.getBrand());
		good.setGoodlable(record.getGoodLable());
		good.setGoodimage(record.getGoodImage());
		goodMapper.updateByPrimaryKey(good);
	}

}
