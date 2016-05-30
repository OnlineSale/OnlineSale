package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.DefaultAddressMapper;
import com.shop.model.DefaultAddress;
import com.shop.service.DefaultAddressService;

/**
 * @author chuankun
 *@2016年5月14日 上午11:36:51
 * email:yichuankun@qq.com
 */
@Service
public class DefaultAddressServiceImp implements DefaultAddressService{
	
	@Resource
	private DefaultAddressMapper addressMapper;

	public void addAddress(DefaultAddress record) {
		// TODO Auto-generated method stub
		
		addressMapper.insert(record);
		DefaultAddress record2 = addressMapper.selectUserDefaultAddress(record.getUserId());
		if(record2!=null){
			record.setIsDefault(0);
			addressMapper.updateByPrimaryKey(record2);
		}
	}

	public void updateAddress(DefaultAddress record) {
		// TODO Auto-generated method stub
		addressMapper.updateByPrimaryKey(record);
		DefaultAddress record2 = addressMapper.selectUserDefaultAddress(record.getUserId());
		if(record2!=null){
			record.setIsDefault(0);
			addressMapper.updateByPrimaryKey(record2);
		}
	}

	public void changeDefaultAddress(Integer addressId, Integer userId) {
		// TODO Auto-generated method stub
		DefaultAddress record = addressMapper.selectUserDefaultAddress(userId);
		if(record!=null){
			record.setIsDefault(0);
			addressMapper.updateByPrimaryKey(record);
		}else {
			record = addressMapper.selectByPrimaryKey(addressId);
			if(record==null){
				System.out.println("地址为空！");
				return ;
			}
			record.setIsDefault(1);
			addressMapper.updateByPrimaryKey(record);
			
		}
	}

	public void deleteAddress(Integer addressId) {
		// TODO Auto-generated method stub
		addressMapper.deleteByPrimaryKey(addressId);
	}

	public List getAddressByUer(Integer userId) {
		// TODO Auto-generated method stub
		return addressMapper.selectByUserId(userId);
	}

}
