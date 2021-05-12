package com.example.web;

public class Skills {
	
	private String skillName;
	private int skillLevel;
	
	public Skills(String skillName, int skillLevel) {
		super();
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
