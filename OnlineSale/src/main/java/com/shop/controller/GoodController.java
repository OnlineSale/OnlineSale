package com.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Good;
import com.shop.service.GoodService;
import com.shop.util.Message;

/**
 * @author chuankun
 *@2016年5月6日 下午8:23:27
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class GoodController {
	
	@Resource
	private GoodService goodService;
	
	@RequestMapping("/addGood")
	@ResponseBody
	public Object addGood(HttpServletRequest request){
		String id = request.getParameter("subCategoryId");
		String goodName =request.getParameter("goodName");
		String stoke = request.getParameter("stoke");
		String goodState = request.getParameter("goodState");
		if(id==null||goodName==null||stoke==null||goodState==null){
			return Message.getMessageParmNull();
		}
		String goodDesc = request.getParameter("goodDesc");
		String brand = request.getParameter("brand");
		String goodLable = request.getParameter("goodLable");
		String goodImage = request.getParameter("goodImage");
		if(goodDesc==null){ //判断参数是否为空
			goodDesc="";
		}else if(brand==null){
			brand="";
		}else if(goodLable==null){
			goodImage="";
		}else if(goodImage==null){
			goodImage="";
		}
		Good good = new Good();
		good.setBrand(brand);
		good.setClassid(Integer.valueOf(id));
		good.setGooddesc(goodDesc);
		good.setGoodimage(goodImage);
		good.setGoodlable(goodLable);
		good.setStoke(Integer.valueOf(stoke));
		good.setGoodname(goodName);
		good.setGoodstate(goodState);
		goodService.addGood(good);
		return Message.getMessage();
	}

}
