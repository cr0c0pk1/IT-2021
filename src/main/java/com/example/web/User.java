package com.example.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement(name = "user")
@XmlSeeAlso({Address.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
	@XmlTransient
	private static int counter = 1;
	private int id;
	private String name;
	private String username;
	private String password;
	private String job;
	private String description;
	@XmlElementWrapper(name = "proSkillsList")
	@XmlElement(name = "proSkill")
	private ArrayList<Skills> proSkills;
	@XmlElementWrapper(name = "personalSkillsList")
	@XmlElement(name = "personalSkill")
	private ArrayList<Skills> personalSkills; 
	private String email;
	private String phone;
	private Address address;
	
	public User() {
		this.id = counter++;
		
		this.proSkills = new ArrayList<Skills>();
		User.addProSkills(proSkills);
		
		this.personalSkills = new ArrayList<Skills>();
		User.addPersonalSkills(personalSkills);
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String name, String username, String password, String job, String description,
			ArrayList<Skills> proSkills, ArrayList<Skills> personalSkills, String email, String phone,
			Address address) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.job = job;
		this.description = description;
		this.proSkills = proSkills;
		this.personalSkills = personalSkills;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Skills> getPersonalSkills() {
		return personalSkills;
	}

	public void setPersonalSkills(ArrayList<Skills> personalSkills) {
		this.personalSkills = personalSkills;
	}

	public ArrayList<Skills> getProSkills() {
		return proSkills;
	}

	public void setProSkills(ArrayList<Skills> proSkills) {
		this.proSkills = proSkills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
	
	public static void addProSkills(ArrayList<Skills> proSkills) {
		proSkills.add(new Skills("Java", 0));
		proSkills.add(new Skills("HTML", 0));
		proSkills.add(new Skills("CSS", 0));
		proSkills.add(new Skills("JavaScript", 0));
	}
	
	public static void addPersonalSkills(ArrayList<Skills> personalSkills) {
		personalSkills.add(new Skills("Communicativeness", 0));
		personalSkills.add(new Skills("Teamwork", 0));
		personalSkills.add(new Skills("Creativity", 0));
	}
	
	public void setDetails(String name, String job, String description, ArrayList<Skills> proSkills, 
			ArrayList<Skills> personalSkills, String email, String phone, Address address) {
		this.name = name;
		this.job = job;
		this.description = description;
		this.proSkills = proSkills;
		this.personalSkills = personalSkills;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
}
