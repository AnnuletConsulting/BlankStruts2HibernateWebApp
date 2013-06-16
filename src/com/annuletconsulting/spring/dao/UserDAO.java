package com.annuletconsulting.spring.dao;

import java.util.List;
import com.annuletconsulting.spring.model.User;

public interface UserDAO {

	void insertUser(User user);
	
	void updateUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();

	void deleteUser(User user);
}