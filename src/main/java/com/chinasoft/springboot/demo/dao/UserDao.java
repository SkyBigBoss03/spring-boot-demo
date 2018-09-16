package com.chinasoft.springboot.demo.dao;


import com.chinasoft.springboot.demo.pojo.User;

import java.util.List;

public interface UserDao {

	List<User> findUserList();

	User findUserById(User user);

	void initUser(List<User> list);
}
