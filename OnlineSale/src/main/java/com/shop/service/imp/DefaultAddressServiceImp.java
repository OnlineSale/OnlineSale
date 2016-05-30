package com.shop.service.imp;

import com.shop.dao.DefaultAddressMapper;
import com.shop.model.DefaultAddress;
import com.shop.service.DefaultAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
		List<DefaultAddress> addressList = addressMapper.selectByUserId(userId);
		//如果只有一个地址，设置为默认@xiechur
		if (addressList.size()==1){
			for (DefaultAddress address:addressList){
				address.setIsDefault(1);
				addressMapper.updateByPrimaryKey(address);
			}
		}
		return addressList;
	}

	@Override
	public void setDefaultAddress(Integer addressId,Integer userId) {
		List<DefaultAddress> addressList = addressMapper.selectByUserId(userId);
		DefaultAddress address;
		if(addressId!=null){
			for (DefaultAddress defaultAddress:addressList){
				defaultAddress.setIsDefault(0);
				addressMapper.updateByPrimaryKey(defaultAddress);
			}
			address = addressMapper.selectByPrimaryKey(addressId);
			if(address==null){
				System.out.println("地址为空！");
				return ;
			}
			address.setIsDefault(1);
			addressMapper.updateByPrimaryKey(address);
		}else {
			System.out.println("地址为空！");
			return ;
		}
	}
	//前端删除地址
	public int deleteAddress2(Integer addressId,Integer userId) {
		if (userId == null || addressId == null){
			System.out.println("参数有误，无法删除地址");
		}
		return addressMapper.deleteByKeyAndUserId(userId,addressId);
	}
}
