package com.operativus.senacrs.audit.model.form;

public class RelatedSkill {

	private String description = null;
	private String requiredAttitude = null;
	private String resultsEvidence = null;

	public RelatedSkill(final String description, final String requiredAttitude, final String resultsEvidence) {

		super();
		this.description = description;
		this.requiredAttitude = requiredAttitude;
		this.resultsEvidence = resultsEvidence;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(final String description) {

		this.description = description;
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

	@Override
	public String toString() {

		return this.description + ":" + this.requiredAttitude + ":" + this.resultsEvidence;
	}
}
