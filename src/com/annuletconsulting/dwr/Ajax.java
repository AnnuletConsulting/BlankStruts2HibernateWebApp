package com.annuletconsulting.dwr;

import java.util.Iterator;
import java.util.List;
import com.annuletconsulting.spring.DataProvider;
import com.annuletconsulting.spring.model.User;

public class Ajax {

	public static int getUserCount() {
		return DataProvider.getUserCount();
	}
	
	public static String[][] getUsernames() {
		List<User> list = DataProvider.getUsers();
		String[][] usernames = new String[list.size()][4];
		Iterator<User> it = list.iterator();
		for (int x = 0; it.hasNext(); x++) {
			User user = it.next();
			usernames[x][0] = String.valueOf(user.getId());
			usernames[x][1] = user.getUsername();
			usernames[x][2] = user.getName();
		}
		return usernames;
	}
}
