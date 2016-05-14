package com.shop.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.IntegralMapper;
import com.shop.model.Integral;
import com.shop.service.IntegralService;

@Service
public class IntegralServiceImpl implements IntegralService {

	@Autowired
	private IntegralMapper integralMapper;
	
	@Override
	public boolean saveIntegral(Integral integral) {
		try{
			integralMapper.save(integral);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Integral findByUserId(int userid) {
		Integral integral = new Integral();
		try{
			integral = integralMapper.findByUserId(userid);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return integral;
	}

	@Override
	public boolean update(Integral integral) {
		try{
			integralMapper.update(integral);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
