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

		return this.skill;
	}

	public void setSkill(final String skill) {

		this.skill = skill;
	}

	public String getRequiredAttitude() {

		return this.requiredAttitude;
	}

	public void setRequiredAttitude(final String requiredAttitude) {

		this.requiredAttitude = requiredAttitude;
	}

	public String getResultsEvidence() {

		return this.resultsEvidence;
	}

	public void setResultsEvidence(final String resultsEvidence) {

		this.resultsEvidence = resultsEvidence;
	}
}
