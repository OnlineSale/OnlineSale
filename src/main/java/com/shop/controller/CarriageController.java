package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Carriage;
import com.shop.service.CarriageService;
import com.shop.util.Message;

/**
 * @author chuankun
 *@2016年5月14日 上午8:34:02
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class CarriageController {

	@Resource
	private CarriageService carriageService;
	
	@RequestMapping("/addCarriage")
	@ResponseBody
	public Object addCarriage(String carriageName,Double carriagePrice,String destination){
		if(carriageName==null||carriagePrice==null||destination==null){
			return Message.getMessageParmNull();
		}
		if(carriageService.findByName(carriageName)!=null){  //判断模板名是否已存在
			return Message.getMessage(0, "模板名已存在！", "");
		}
		Carriage record =  new Carriage();
		record.setCarriagename(carriageName);
		//record.setCarriageprice(carriagePrice);
		record.setDestination(destination);
		carriageService.addCarriage(record);
		return Message.getMessage();
	}
	
	@RequestMapping("/updateCarriage")
	@ResponseBody
	public Object updateCarriage(Integer carriageId,String carriageName,Double carriagePrice,String destination){
		if(carriageId==null||carriageName==null||carriagePrice==null||destination==null){
			return Message.getMessageParmNull();
		}
		Carriage record = new Carriage();
		record.setCarriageid(carriageId);
		record.setCarriagename(carriageName);
//		record.setCarriageprice(carriagePrice);
		record.setDestination(destination);
		
		carriageService.updateCarriage(record);
		
		return Message.getMessage();
	}
	
	@RequestMapping("/deleteCarriage")
	@ResponseBody
	public Object deleteCarriage(Integer carriageId){
		if(carriageId==null){
			return Message.getMessageParmNull(); 
		}
		carriageService.deleteCarriage(carriageId);
		return Message.getMessage();
	}
	@RequestMapping("/getCarriage")
	@ResponseBody
	public Object getCarriage(){//返回所有运费模板
		List<Carriage> list = carriageService.findAll();
		return Message.getMessage(0, "", list);
	}

}
