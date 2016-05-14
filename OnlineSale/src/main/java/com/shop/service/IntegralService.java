package com.shop.service;

import com.shop.model.Integral;

public interface IntegralService {

	boolean saveIntegral(Integral integral);

	Integral findByUserId(int userid);

	boolean update(Integral integral);

}
