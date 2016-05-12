package com.shop.service.imp;

import com.shop.dao.UserMapper;
import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService{
	
	@Resource
	private UserMapper userDao;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	 
	public int update(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

 
	public User find(int id) {
		return userDao.selectByPrimaryKey(id);
	}

 
	public User findUserInfo(int id) {
		return userDao.findUserInfoById(id);
	}

 
	public User login(User user) {
		return userDao.login(user);
	}
}
