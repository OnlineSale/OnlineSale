package com.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.Integral;
import com.shop.service.IntegralService;
import com.shop.util.Message;

@Controller
@RequestMapping(value = "/integral")
public class IntegralController {

	@Autowired
	private IntegralService integralService;
	
	@ResponseBody
	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public Object recharge(HttpServletRequest request, HttpServletResponse response) {
		String recharge = request.getParameter("recharge");
		if (recharge == null || "".equals(recharge)) {
			return Message.getMessageParmNull();
		}
		int balance = Integer.parseInt(recharge);
		if (balance <= 0 ) {
			return Message.getMessage(0, "recharge should be larger than 0", null);
		}
		Integral integral = new Integral();
		integral.setBalanceIntegral(balance);
		
		boolean ok = integralService.saveIntegral(integral);
		if (!ok) {
			return Message.getMessage(0, "存储数据出错,操作失败", integral);
		}
		return Message.getMessage();
	}
	
	
	
}
