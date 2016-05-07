package com.shop.service;

import com.shop.model.Specification;

public interface SpecificationService {
	
	public void addSpecification(Specification record);
	public void updateSpecification(Specification record);
	public void deleteSpecification(Integer id);

}
