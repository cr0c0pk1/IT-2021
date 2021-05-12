package com.example.web;

import java.util.HashSet;

public class UserCollection {
	private static UserCollection single_instance = null;
	private HashSet<User> users;
	
	private UserCollection() {
		this.users = new HashSet<>(0);
	}
	
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
	
	public boolean checkIfUserExists(User user) {
		return users.contains(user);
	}
	
	public boolean checkIfUsernameExists(User user) {
		boolean result = false;
		
		for(User u : users) {
			if (u.getUsername().equals(user.getUsername())) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public User checkForIDMatch(User user) {
		for (User u : users) {
			if (u.getId() == user.getId()) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "" + users;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
}
