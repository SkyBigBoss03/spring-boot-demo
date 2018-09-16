package com.chinasoft.springboot.demo.controller;


import com.chinasoft.springboot.demo.common.Result;
import com.chinasoft.springboot.demo.pojo.User;
import com.chinasoft.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 如何添加配置类
	 * 需求:在spring中可以通过配置文件的方式,通过工厂模式为calendar对象进行管理
	 * 	   只要spring管理了该对象,则可以通过依赖注入的形式,赋值.
	 * 
	 * 说明:使用springBoot中没有.xml的写法,那么如何实现该类交给spring容器管理.
	 * 解决方法: 使用springBoot中提供的配置类的写法.
	 */
	@Autowired
	private Calendar calendar;
	
	//Spring4以后的写法
	/**
	 * 功能:如果页面不是返回的JSON数据,如果直接返回的对象.
	 * 那么会根据请求的路径自动的拼接前缀和后缀.转向到具体页面中.
	 * 之后通过jstl表达式动态的获取数据.
	 * 注意事项:
	 * 	该方法的调用需要依赖JSTL表达式jar包.以后建议返回json之后再次解析.
	 * @return
	 */
	@RequestMapping("/userList")
	@ResponseBody
	public List<User> findUserList(){
		
		List<User> userList = userService.findUserList();
		//model.addAttribute("userList", userList);

		return userList;
	}
	
	
	//需求:实现Canlendar对象的动态注入
	@RequestMapping("/getTime")
	@ResponseBody
	public String getTime(){
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sf.format(date);
		//return  calendar.getTime().toString();
		return time;
	}
	
	@RequestMapping("/findUser")
	@ResponseBody
	public User findUser(User user){
		try{
			if(user == null ){
				return null;
			}
			User userDb = userService.findUser(user);
			return userDb;
		}catch (Exception e){
			e.printStackTrace();
		}
		return  null;
	}

	@RequestMapping("/initUser")
	@ResponseBody
	public Result saveUser(){
		try{
			List<User> list = userService.findUserList();
			userService.saveUserByList(list);
			return Result.ok("ok");
		}catch (Exception e){
			e.printStackTrace();
			return Result.buildFail("no ok");
		}
	}

	
	
}
