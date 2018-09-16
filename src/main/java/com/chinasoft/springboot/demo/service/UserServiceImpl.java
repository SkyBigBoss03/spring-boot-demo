package com.chinasoft.springboot.demo.service;


import com.chinasoft.springboot.demo.dao.UserDao;
import com.chinasoft.springboot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;  //spring为其生成代理对象

	@Override
	public List<User> findUserList() {
		
		return userDao.findUserList();
	}

	@Override
	public User findUser(User user) {
		if(StringUtils.isEmpty(user.getId()) && StringUtils.isEmpty(user.getName())){
			return null;
		}
		User newUser = userDao.findUserById(user);
		return newUser;
	}

	public void saveUserByList(List<User> list){
		try {
			System.out.println(list);
			userDao.initUser(list);
		}catch (Exception e){
			e.printStackTrace();

		}
	}

}
