package com.shop.controller;

import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
//
//	@RequestMapping("/regist")
//	@ResponseBody
//	public Object regist(HttpServletRequest request){
//		String username= request.getParameter("username");
//		String password= request.getParameter("password");
//		if(username==null||password==null){
//			return " 空";
//		}else{
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
//		userService.addUser(user);
//		return "ok";
//		}
//	}

	@RequestMapping("/aboutMe")
	@ResponseBody
	public Object aboutMe(User user){
        if (user.getUserid()==null){
           return Message.getMessageParmNull();
        }
        User user1 = userService.findUserInfo(user.getUserid());
//            Map<String,Object> map = new HashMap<String, Object>();
//            map.put("test","test");
        return Message.getMessage(1,"",user1);
    }

	@RequestMapping("/saveInfo")
	@ResponseBody
	public Object saveInfo(User user) {
        //验证是否登录
        int result = 0;
        if (user.getUserid() != null) {
            result = userService.update(user);
            if (result > 0) {
                return Message.getMessage();//成功
            }
        }
            return Message.getMessage(2, "保存失败","");
        }
    }

