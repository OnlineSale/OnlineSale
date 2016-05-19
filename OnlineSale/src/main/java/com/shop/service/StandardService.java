package com.shop.service;

import java.util.List;

import com.shop.model.Standard;

public interface StandardService {
	
		public List findBySpecificationId(Integer specificationId);
		public void addStandard(Standard record);
		public void updateStandard(Standard record);
		public void deleteStandard(Integer standardId);
}
