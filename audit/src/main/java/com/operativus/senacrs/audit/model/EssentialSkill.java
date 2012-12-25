package com.operativus.senacrs.audit.model;

public class EssentialSkill {

	private String skillDescription = null;

	public EssentialSkill(final String skillDescription) {

		super();
		this.skillDescription = skillDescription;
	}

	
	public String getSkillDescription() {
	
		return skillDescription;
	}

	
	public void setSkillDescription(String skillDescription) {
	
		this.skillDescription = skillDescription;
	}
}
