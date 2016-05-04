package com.shop.controller;

import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月28日 上午9:11:13
 *	TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/regist")
	@ResponseBody
	public Object regist(HttpServletRequest request){
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		if(username==null||password==null){
			return " 空";
		}else{
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		userService.addUser(user);
		return "ok";
		}
	}
//

}
