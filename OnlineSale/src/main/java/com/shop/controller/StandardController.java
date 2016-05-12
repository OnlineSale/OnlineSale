package com.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Standard;
import com.shop.service.StandardService;
import com.shop.util.Message;

/**创建2级目录
 * @author chuankun
 *@2016年5月11日 下午11:14:01
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class StandardController {

	@Resource
	private StandardService standardService;
	@RequestMapping("/addStandard")
	@ResponseBody
	public Object addStandard(String specificationId,String standardName,String price,String stoke){
		if(specificationId==null||standardName==null||price == null||stoke==null){
			return Message.getMessageParmNull();
		}
		Standard record = new Standard();
		record.setPrice(Double.valueOf(price));
		record.setStandardname(standardName);
		record.setStoke(Integer.valueOf(stoke));
		record.setSpecificationid(Integer.valueOf(specificationId));
		standardService.addStandard(record);
		return Message.getMessage();
	}
	@RequestMapping("/updateStandard")
	@ResponseBody
	public Object updateStandard(String standardId,String specificationId,String standardName,String price,String stoke){
		if(standardId==null||specificationId==null||standardName==null||price == null||stoke==null){
			return Message.getMessageParmNull();
		}
		Standard record = new Standard();
		record.setStandardid(Integer.valueOf(standardId));
		record.setPrice(Double.valueOf(price));
		record.setStandardname(standardName);
		record.setStoke(Integer.valueOf(stoke));
		record.setSpecificationid(Integer.valueOf(specificationId));
		standardService.updateStandard(record);
		return Message.getMessage();
	}
	@RequestMapping("/deleteStandard")
	@ResponseBody
	public Object deleteStandard(String standardId){
		if(standardId==null){
			Message.getMessageParmNull();
		}
		standardService.deleteStandard(Integer.valueOf(standardId));	
		return Message.getMessage();
	}
}
