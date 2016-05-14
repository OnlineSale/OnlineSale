package com.shop.monitor;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.service.IntegralService;
import com.shop.service.UserService;

@Resource
public class AactivityMonitor implements Runnable{

	@Autowired
	private UserService userService;
	@Autowired
	private IntegralService integralService;
	
	@Override
	public void run() {
		
	}
}
