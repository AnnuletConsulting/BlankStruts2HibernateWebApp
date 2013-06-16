package com.annuletconsulting.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.annuletconsulting.spring.model.User;
import com.annuletconsulting.spring.user.UserManager;

public class DataProvider {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private static UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
	
	public static int getUserCount() {
		return userManager.getUsers().size();
	}
	
	public static User getUser(String username, String pass) {
		User user = userManager.getUser(username);
		if (user != null && pass != null && pass.equals(user.getPassword())) 
			return user;
		return null;
	}

	public static User createUser(String name, String username, String password) {
		User user = userManager.getUser(username);
		if (user == null) {
			user = new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			userManager.insertUser(user);
			return user;
		}
		return null;
	}

	public static List<User> getUsers() {
		return userManager.getUsers();
	}
}