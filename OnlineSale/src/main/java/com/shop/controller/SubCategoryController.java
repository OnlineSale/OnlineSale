package com.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.SubCategory;
import com.shop.service.SubCategoryService;
import com.shop.util.Message;

/**
 * @author chuankun
 *@2016年5月6日 上午11:07:38
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/manage")
public class SubCategoryController {

	@Resource
	private SubCategoryService subCategoryService;
	
	@RequestMapping("/addSubCategory")
	@ResponseBody
	public Object addSubCategory(HttpServletRequest request){
		String name = request.getParameter("subCategoryName");
		String categoryId  = request.getParameter("categoryId");
		String subCategoryDesc = request.getParameter("subCategoryDesc");
		if(name==null&&categoryId==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(subCategoryService.findByName(name)!=null){
			return Message.getMessage(0, "小类已存在!", "");
		}
		if(subCategoryDesc==null){
			subCategoryDesc = "";
		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = format.format(now);
		SubCategory record = new SubCategory();
		record.setCreatetime(date);
		record.setSubcategorydesc(subCategoryDesc);
		record.setCategoryid(Integer.valueOf(categoryId));
		record.setSubcategoryname(name);
		subCategoryService.addSubCategory(record);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/updateSubCategory")
	@ResponseBody
	public Object updateSubCategory(HttpServletRequest request){
		String name = request.getParameter("subCategoryName");
		String categoryId  = request.getParameter("categoryId");
		String subCategoryDesc = request.getParameter("subCategoryDesc");
		String subCategoryId = request.getParameter("subCategoryId");
		if(name==null&&categoryId==null&&subCategoryId==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(subCategoryService.findByName(name)!=null){
			return Message.getMessage(0, "小类已存在!", "");
		}
		if(subCategoryDesc==null){
			subCategoryDesc = "";
		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = format.format(now);
		SubCategory record = new SubCategory();
		record.setSubcategoryid(Integer.valueOf(subCategoryId));
		record.setCreatetime(date);
		record.setSubcategorydesc(subCategoryDesc);
		record.setCategoryid(Integer.valueOf(categoryId));
		record.setSubcategoryname(name);
		subCategoryService.updateSubCategory(record);
		return Message.getMessage(1, "", "");
	}
	
	@RequestMapping("/getSubCategoryByCategoryId")
	@ResponseBody
	public Object getAllByCategoryId(HttpServletRequest request){
		String id = request.getParameter("categoryId");
		if(id==null){
			return Message.getMessage(0,"参数为空！","");
		}
		List<SubCategory> list = subCategoryService.findByCategory(Integer.valueOf(id));
		
		return Message.getMessage(1, "", list);
	}
}