package com.annuletconsulting.spring.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.annuletconsulting.spring.dao.UserDAO;
import com.annuletconsulting.spring.model.User;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public User getUserById(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}
	
	public User getUser(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where username = :username");
		query.setParameter("username", username);
		List<?> list = query.list();
		if (list.size() == 0)
			return null;
		return (User) list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
}
