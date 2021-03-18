package com.example.web;

public class User {
	private String name;
	private String username;
	private String password;
	
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username="+ username +", password=" + password + "]";
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		return prime + (username == null ? 0 : username.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof User))
			return false;
		if (obj == this)
			return true;
		return this.getUsername() == ((User) obj).getUsername();
	}
}
