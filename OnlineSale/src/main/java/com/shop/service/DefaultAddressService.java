package com.shop.service;

import com.shop.model.DefaultAddress;

import java.util.List;

public interface DefaultAddressService {
	
	public void addAddress(DefaultAddress record);
	public void updateAddress(DefaultAddress record);
	public void changeDefaultAddress(Integer addressId,Integer userId);
	public void deleteAddress(Integer addressId);
	public List getAddressByUer(Integer userId);

	//补充
	public void setDefaultAddress(Integer addressId,Integer userId);
	public int deleteAddress2(Integer addressId,Integer userId);

}
