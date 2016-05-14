package com.shop.service;

import java.util.List;

import com.shop.model.DefaultAddress;

public interface DefaultAddressService {
	
	public void addAddress(DefaultAddress record);
	public void updateAddress(DefaultAddress record);
	public void changeDefaultAddress(Integer addressId,Integer userId);
	public void deleteAddress(Integer addressId);
	public List getAddressByUer(Integer userId);

}
