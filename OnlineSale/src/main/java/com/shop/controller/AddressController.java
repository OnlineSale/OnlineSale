package com.shop.controller;

import com.shop.model.DefaultAddress;
import com.shop.service.DefaultAddressService;
import com.shop.util.Message;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xiechur
 *@2016年5月28日
 * email:1406561459@qq.com
 */
@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource
	private DefaultAddressService addressService;
	//增加收货地址
	@RequestMapping("/add")
	@ResponseBody
	public Object addAddress(DefaultAddress address){
		if(address.getDetailAddress()==null||address.getPhone()==null||address.getReceiver()==null||
				address.getRoughAddress()==null||address.getUserId()==null){
			return Message.getMessageParmNull();
		}
		try {
			addressService.addAddress(address);
		}catch (TooManyResultsException e){
			e.printStackTrace();
		}finally {
			return Message.getMessage();
		}
	}
	//更新收货地址
	@RequestMapping("/update")
	@ResponseBody
	public Object updateAddress(DefaultAddress address){
		if(address.getDetailAddress()==null||address.getPhone()==null||address.getReceiver()==null||
				address.getRoughAddress()==null||address.getUserId()==null||address.getDefaultAddressId()==null){
			return Message.getMessageParmNull();
		}
		try {
			addressService.updateAddress(address);
		}catch (TooManyResultsException e){
			e.printStackTrace();
		}finally {
			return Message.getMessage();
		}
	}
	//删除收货地址
	@RequestMapping("/delete")
	@ResponseBody
	public Object deleteAddress(Integer defaultAddressId,Integer userId){
		if(defaultAddressId==null){
			return Message.getMessageParmNull();
		}
		if (addressService.deleteAddress2(defaultAddressId, userId)==1){
			return Message.getMessage();
		}
		else{
			return Message.getMessageParmNull();
		}
	}
	//设置默认
	@RequestMapping("/setDefault")
	@ResponseBody
	public Object setDefaultAddress(Integer defaultAddressId,Integer userId){
		if(defaultAddressId==null||userId==null){
			return Message.getMessageParmNull();
		}

		addressService.setDefaultAddress(defaultAddressId, userId);
		return Message.getMessage();
	}
	//查看所有收货地址
	@RequestMapping("/get")
	@ResponseBody
	public Object ge(Integer userId){
		if(userId==null){
			return Message.getMessageParmNull();
		}
		return Message.getMessage(addressService.getAddressByUer(userId));
	}
}
