package com.annuletconsulting.spring.user;

import java.util.List;

import com.annuletconsulting.spring.model.User;

public interface UserManager {

	void insertUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
