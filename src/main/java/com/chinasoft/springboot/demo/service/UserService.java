package com.chinasoft.springboot.demo.service;


import com.chinasoft.springboot.demo.pojo.User;

import java.util.List;

public interface UserService {
	
	public List<User> findUserList();

	User findUser(User user);

	void saveUserByList(List<User> list);

}
