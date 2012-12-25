package com.operativus.senacrs.audit.model;

public class RelatedSkill {

	private String skill = null;
	private String requiredAttitude = null;
	private String resultsEvidence = null;

	public RelatedSkill(final String skill, final String requiredAttitude, final String resultsEvidence) {

		super();
		this.skill = skill;
		this.requiredAttitude = requiredAttitude;
		this.resultsEvidence = resultsEvidence;
	}

	
	public String getSkill() {
	
		return skill;
	}

	
	public void setSkill(String skill) {
	
		this.skill = skill;
	}

	
	public String getRequiredAttitude() {
	
		return requiredAttitude;
	}

	
	public void setRequiredAttitude(String requiredAttitude) {
	
		this.requiredAttitude = requiredAttitude;
	}

	
	public String getResultsEvidence() {
	
		return resultsEvidence;
	}

	
	public void setResultsEvidence(String resultsEvidence) {
	
		this.resultsEvidence = resultsEvidence;
	}
}
