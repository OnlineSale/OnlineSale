package com.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Category;
import com.shop.service.CategoryService;
import com.shop.util.Message;

/**
 * 创建大类
 * @author chuankun
 *@2016年5月5日 下午10:24:47
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class CategoryController {

	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("/addCategory")
	@ResponseBody
	public Object addCategory(HttpServletRequest request,HttpServletResponse response){
//		Cookie cookie = new Cookie("test", "hello,good morning");
//		cookie.setMaxAge(-1);
		String categoryName = request.getParameter("categoryName");
		if(categoryName==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(categoryService.findByName(categoryName)!=null){
			return Message.getMessage(0, "分类名称已存在！", "");
		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = format.format(now);
		Category  record = new Category();
		record.setCategoryname(categoryName);
		record.setCreatetime(date);
		 categoryService.addCategory(record);
//		 response.addCookie(cookie);
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("categoryId", categoryService.findByName(categoryName).getCategoryid().toString());
		return Message.getMessage(1, "", map);
		
	}
	@RequestMapping("/updateCategory")
	@ResponseBody
	public Object updateCategory(HttpServletRequest request){
		String categoryId = request.getParameter("categoryId");
		String categoryName = request.getParameter("categoryName");
		if(categoryId==null||categoryName==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = format.format(now);
		Category record = new Category();
		record.setCategoryid(Integer.valueOf(categoryId));
		record.setCategoryname(categoryName);
		record.setCreatetime(date);
		categoryService.updateCategory(record);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/getAllCategory")
	@ResponseBody
	public Object getAllCategory(HttpServletRequest request){
		List<Category> list = categoryService.findAll();
		return Message.getMessage(1, "", list);
	}
	
	
	@RequestMapping("/deleteCategory")
	@ResponseBody
	public Object deleteCategory(String categoryId){
//		String categoryId = request.getParameter("categoryId");
		if(categoryId==null){
			return Message.getMessageParmNull();
		}
		categoryService.deleteCateGory(Integer.valueOf(categoryId));
		return Message.getMessage();
	}
	
}
