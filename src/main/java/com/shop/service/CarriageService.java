package com.shop.service;

import java.util.List;

import com.shop.model.Carriage;

public interface CarriageService {

	public Carriage findByName(String name);
	public void addCarriage(Carriage record);
	public void updateCarriage(Carriage record);
	public void deleteCarriage(Integer id);
	public List findAll();
}
