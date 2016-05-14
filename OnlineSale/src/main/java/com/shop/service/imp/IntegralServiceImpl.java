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

}
