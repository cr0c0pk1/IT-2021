package com.example.web;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private String name;
	private String username;
	private String password;
	
	public User() {}
	
	/*public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}*/

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	/*@Override
	public int hashCode() {
		int prime = 31;
		return prime + (username == null ? 0 : username.hashCode());
		return Objects.hash(username, password);
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof User))
			return false;
		if (obj == this)
			return true;
		return this.getUsername().equals(((User) obj).getUsername())
				&& this.getPassword().equals(((User) obj).getPassword());
	}*/
}
