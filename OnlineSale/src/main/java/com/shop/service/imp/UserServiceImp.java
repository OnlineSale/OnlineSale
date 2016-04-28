package com.shop.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.UserMapper;
import com.shop.model.User;
import com.shop.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Resource
	private UserMapper userDao;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

}
