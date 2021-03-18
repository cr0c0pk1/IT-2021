package com.example.web;

import java.util.HashSet;

public class UserCollection {
	private static UserCollection single_instance = null;
	private HashSet<User> users;
	
	public static UserCollection getInstance() {
		if (single_instance == null)
			single_instance = new UserCollection();
		return single_instance;
	}
	
	public void addUser(User user) {
		if (users == null)
			users = new HashSet<>();
		users.add(user);
	}
	
	@Override
	public String toString() {
		return "" + users;
	}
}
