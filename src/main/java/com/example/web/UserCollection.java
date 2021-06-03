package com.example.web;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
//@XmlSeeAlso({User.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCollection {
	@XmlTransient
	private static UserCollection single_instance = null;
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
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
	
	public int getID(String username) {
		for(User u : users) {
			if (u.getUsername().equals(username)) {
				return u.getId();
			}
		}
		return 0;
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
