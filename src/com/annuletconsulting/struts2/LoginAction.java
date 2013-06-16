package com.annuletconsulting.struts2;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.annuletconsulting.spring.DataProvider;
import com.annuletconsulting.spring.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -8641723868987623525L;
	private String name;
	private String username;
	private String password;
	private String confirmPassword;
	private Map<String, Object> session;
	
	public static final String USER_OBJ = "USER_OBJ";

	public String authenticate() {
		User user = DataProvider.getUser(username, password);
		if (user == null) {
			if(session.containsKey(USER_OBJ))
				session.remove(USER_OBJ);
			addActionError(getText("error.login"));
			return ERROR;
		}
		session.put(USER_OBJ, user);
		return SUCCESS;
	}
	
	public String logout() {
		if(session.containsKey(USER_OBJ))
			session.remove(USER_OBJ);
		return SUCCESS;
	}

	public String signup() {
		if (!password.equals(confirmPassword)) {
			addActionError(getText("error.signup_password"));
			return ERROR;
		}
		User user = DataProvider.createUser(name, username, password);
		if (user == null){
			addActionError(getText("error.signup_exists"));
			return ERROR;
		}
		session.put(USER_OBJ, user);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
}
