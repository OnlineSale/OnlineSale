package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.bean.MemberLevel;
import com.shop.model.Integral;
import com.shop.model.User;
import com.shop.service.IntegralService;
import com.shop.service.UserService;
import com.shop.util.Message;

@Controller
@RequestMapping(value = "/integral")
public class IntegralController {

	@Autowired
	private IntegralService integralService;
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public Object recharge(@RequestParam("recharge") String recharge, @RequestParam("userId") String userId) {
		if (recharge == null || "".equals(recharge) || userId == null || "".equals(userId)) {
			return Message.getMessageParmNull();
		}
		int balance = Integer.parseInt(recharge);
		if (balance <= 0 ) {
			return Message.getMessage(0, "recharge should be larger than 0", null);
		}
		int userid = Integer.parseInt(userId);
		if (userid <= 0 ) {
			return Message.getMessage(0, "userId should be number and larger than 0", null);
		}
		User user = userService.find(userid);
		if (user == null) {
			return Message.getMessage(0, "没有对应的用户存在", null);
		}
		Integral integral = integralService.findByUserId(userid);
		boolean ok = false;
		if (integral != null) {
			integral.setBalanceIntegral(balance + integral.getBalanceIntegral());
			ok = integralService.update(integral);
		} else {
			integral = new Integral();
			integral.setBalanceIntegral(balance);
			integral.setUserId(userid);
			ok = integralService.saveIntegral(integral);
		}
		
		if (!ok) {
			return Message.getMessage(0, "存储数据出错,操作失败", integral);
		}
		//进入A活动判断
		if (balance >= 3000 && user.getMemberlevel() == null) {
			user.setMemberlevel(MemberLevel.CONSUMER_VIP.getLevelInt());
			userService.update(user);
		} if (balance >= 3000) {
			
		}
		
		return Message.getMessage(1, "", integral);
	}
	
	@ResponseBody
	@RequestMapping(value = "payPassword/beenSeted", method = RequestMethod.GET)
	public Object payPasswordBeenSetted(@RequestParam("userId") String userId) {
		if (userId == null || "".equals(userId)) {
			return Message.getMessageParmNull();
		}
		int userid = Integer.parseInt(userId);
		if (userid <= 0 ) {
			return Message.getMessage(0, "userId should be number and larger than 0", null);
		}
		User user = userService.find(userid);
		if (user == null) {
			return Message.getMessage(0, "没有对应的用户存在", null);
		}
		if (user.getPaypassword() == null) {
			return Message.getMessage(0, "没有设置支付密码", null);
		} else {
			return Message.getMessage(1, null, "已经设置支付密码");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "payPassword/set", method = RequestMethod.GET)
	public Object setPayPassword(@RequestParam("userId") String userId, @RequestParam("payPassword") String payPassword) {
		if (payPassword == null || "".equals(payPassword) || userId == null || "".equals(userId)) {
			return Message.getMessageParmNull();
		}
		int pass = Integer.parseInt(payPassword);
		if (pass <= 0 ) {
			return Message.getMessage(0, "recharge should be larger than 0", null);
		}
		int userid = Integer.parseInt(userId);
		if (userid <= 0 ) {
			return Message.getMessage(0, "userId should be number and larger than 0", null);
		}
		User user = userService.find(userid);
		if (user == null) {
			return Message.getMessage(0, "没有对应的用户存在", null);
		}
		user.setPaypassword(pass);
		int ok = userService.update(user);
		if (ok <= 0) {
			return Message.getMessage(0, "保存数据失败,在保存过程中遇到错误", null);
		}
		return Message.getMessage();
	}
	
	@ResponseBody
	@RequestMapping(value = "getIntegralByUser/{userId}", method = RequestMethod.GET)
	public Object getIntegralByUser(@PathVariable("userId") String userId) {
		if (userId == null || "".equals(userId)) {
			return Message.getMessageParmNull();
		}
		int userid = Integer.parseInt(userId);
		if (userid <= 0 ) {
			return Message.getMessage(0, "userId should be number and larger than 0", null);
		}
		User user = userService.find(userid);
		if (user == null) {
			return Message.getMessage(0, "没有对应的用户存在", null);
		}
		Integral integral = integralService.findByUserId(userid);
		if (integral != null) {
			return Message.getMessage(integral);
		}
		return Message.getMessage(0, "该用户没有充值过,没有积分信息", null);
	}
}
