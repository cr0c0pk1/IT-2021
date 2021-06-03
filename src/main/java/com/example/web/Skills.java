package com.example.web;

import javax.xml.bind.annotation.XmlRootElement;

public class Skills {
	
	private String skillName;
	private int skillLevel;
	
	public Skills() {};
	
	public Skills(String skillName, int skillLevel) {
		this.skillName = skillName;
		this.skillLevel = skillLevel;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
}
