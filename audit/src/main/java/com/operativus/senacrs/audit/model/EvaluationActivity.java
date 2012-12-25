package com.operativus.senacrs.audit.model;

public class EvaluationActivity extends 
AbstractSequenceStringFieldComparable {

	private final EvaluationType type;
	String name = null;
	private String description = null;

	public EvaluationActivity(int sequence, EvaluationType type, String name, String description) {

		super(sequence);
		this.type = type;
		this.name = name;
		this.description = description;
	}

	public EvaluationType getType() {

		return type;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	@Override
	protected String getComparisonStringField() {

		return this.getName();
	}

}
