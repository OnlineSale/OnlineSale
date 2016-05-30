package com.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.DefaultAddress;
import com.shop.service.DefaultAddressService;
import com.shop.util.Message;

/**
 * @author chuankun
 *@2016年5月14日 上午11:42:51
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class DefaultAddressController {

	@Resource
	private DefaultAddressService addressService;
	@RequestMapping("/addDefaultAddress")
	@ResponseBody
	public Object addAddress(DefaultAddress record){
		if(record.getDetailAddress()==null||record.getPhone()==null||record.getReceiver()==null||
				record.getRoughAddress()==null||record.getUserId()==null){
			return Message.getMessageParmNull();
		}
		
		addressService.addAddress(record);
		return Message.getMessage();
	}
	@RequestMapping("/updateDefaultAddress")
	@ResponseBody
	public Object updateAddress(DefaultAddress record){
		if(record.getDetailAddress()==null||record.getPhone()==null||record.getReceiver()==null||
				record.getRoughAddress()==null||record.getUserId()==null||record.getDefaultAddressId()==null){
			return Message.getMessageParmNull();
		}
		addressService.updateAddress(record);
		return Message.getMessage();
	}
	@RequestMapping("/deleteDefaultAddress")
	@ResponseBody
	public Object deleteAddress(Integer defaultAddressId){
		if(defaultAddressId==null){
			return Message.getMessageParmNull();
		}
		addressService.deleteAddress(defaultAddressId);
		return Message.getMessage();
	}
	@RequestMapping("/changeDefaultAddress")
	@ResponseBody
	public Object changeDefaultAddress(Integer defaultAddressId,Integer userId){
		if(defaultAddressId==null||userId==null){
			return Message.getMessageParmNull();
		}
		addressService.changeDefaultAddress(defaultAddressId, userId);
		return Message.getMessage();
	}
	@RequestMapping("/getDefaultAddress")
	@ResponseBody
	public Object getAddresses(Integer userId){
		if(userId==null){
			return Message.getMessageParmNull();
		}
		return Message.getMessage(addressService.getAddressByUer(userId));
	}
}
