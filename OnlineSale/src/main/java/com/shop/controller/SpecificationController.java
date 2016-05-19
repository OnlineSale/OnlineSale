package com.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Specification;
import com.shop.service.SpecificationService;
import com.shop.util.Message;

/**
 * @author chuankun
 *@2016年5月7日 下午2:40:42
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class SpecificationController {
	
	@Resource 
	private SpecificationService specificationService;
	@	RequestMapping("/addSpecification")
	@ResponseBody
	public Object addSpecification(HttpServletRequest request){
		String goodId = request.getParameter("goodId");
		String specificationName = request.getParameter("specificationName");
		String price = request.getParameter("price");
		String stoke = request.getParameter("stoke");
		if(goodId==null||specificationName==null||price==null||stoke==null){
			return Message.getMessageParmNull();
		}
		Specification record = new Specification();
		record.setGoodid(Integer.valueOf(goodId));
		record.setPrice(Double.valueOf(price));
		record.setStoke(Integer.valueOf(stoke));
		
		specificationService.addSpecification(record);
		return Message.getMessage();
	}
	@RequestMapping("/updateSpecification")
	@ResponseBody
	public Object updateSpecification(String specificationId,String goodId,String specificationName,String price,String stoke){
		if(specificationId==null||goodId==null||specificationName==null||price==null||stoke==null){
			return Message.getMessageParmNull();
		}
		Specification record = new Specification();
		record.setSpecificationid(Integer.valueOf(specificationId));
		record.setGoodid(Integer.valueOf(goodId));
		record.setPrice(Double.valueOf(price));
		record.setSpecificationname(specificationName);
		record.setStoke(Integer.valueOf(stoke));
		specificationService.updateSpecification(record);
		
		return Message.getMessage();
	}
	@RequestMapping("/deleteSpecification")
	@ResponseBody
	public Object deleteSpecification(String specificationId){
		if(specificationId==null){
			return Message.getMessageParmNull();
		}
		specificationService.deleteSpecification(Integer.valueOf(specificationId));
		return Message.getMessage();
	}
}
