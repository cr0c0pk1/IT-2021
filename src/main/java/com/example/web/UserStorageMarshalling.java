package com.example.web;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserStorageMarshalling {
	
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	ArrayList<User> UserStorage;
		
	public UserStorageMarshalling() {
		this.UserStorage = new ArrayList<User>();
	}
	
	public ArrayList<User> getUserStorage() {
		return UserStorage;
	}

	public void setUserStorage(ArrayList<User> userStorage) {
		UserStorage = userStorage;
	}

	public UserStorageMarshalling(ArrayList<User> userStorage) {
		super();
		UserStorage = userStorage;
	}
	
	public void addUser(User user) {
		UserStorage.add(user);
	}

}
