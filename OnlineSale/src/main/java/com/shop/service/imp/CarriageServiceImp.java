package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CarriageMapper;
import com.shop.model.Carriage;
import com.shop.service.CarriageService;

/**
 * @author chuankun
 *@2016年5月14日 上午8:30:21
 * email:yichuankun@qq.com
 */
@Service
public class CarriageServiceImp implements CarriageService{
	
	@Resource
	private CarriageMapper carriageMapper;

	public Carriage findByName(String name) {
		// TODO Auto-generated method stub
		
		return carriageMapper.selectByName(name);
	}

	public void addCarriage(Carriage record) {
		// TODO Auto-generated method stub
		carriageMapper.insert(record);
	}

	public void updateCarriage(Carriage record) {
		// TODO Auto-generated method stub
		carriageMapper.updateByPrimaryKey(record);
	}

	public void deleteCarriage(Integer id) {
		// TODO Auto-generated method stub
		carriageMapper.deleteByPrimaryKey(id);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return carriageMapper.selectAll();
	}

}
