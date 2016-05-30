package com.shop.service;

import com.shop.model.User;

public interface UserService {

	public void addUser(User user);

	public int update(User user);

	public User find(int id);

	public  User findUserInfo(int id);

	public User login(User user);
}
