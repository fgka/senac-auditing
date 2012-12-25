package com.operativus.senacrs.audit.model;

public class EvaluationActivity
		implements Comparable<EvaluationActivity> {

	private final int sequence;
	private final EvaluationType type;
	private String name = null;
	private String description = null;

	public EvaluationActivity(int sequence, EvaluationType type, String name, String description) {

		super();
		this.sequence = sequence;
		this.type = type;
		this.name = name;
		this.description = description;
	}

	public int getSequence() {

		return sequence;
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
	public int compareTo(EvaluationActivity o) {

		int result = 0;

		if (o == null) {
			result = 1;
		} else {
			result = compareToNonNull(o);
		}

		return result;
	}

	private int compareToNonNull(EvaluationActivity o) {

		int result = 0;

		result = this.getSequence() - o.getSequence();
		if (result == 0) {
			result = compareToSameSeqUsingStrField(o);
		}

		return result;
	}

	private int compareToSameSeqUsingStrField(EvaluationActivity o) {

		int result = 0;

		if (this.name == null) {
			result = compareToThisStrFieldNull(o);
		} else {
			result = this.getComparisonStringField().compareTo(o.getComparisonStringField());
		}

		return result;
	}

	private String getComparisonStringField() {

		return this.getName();
	}		

	private int compareToThisStrFieldNull(EvaluationActivity o) {

		int result = 0;
		
		if (o.getComparisonStringField() == null) {
			result = 0;
		} else {
			result = -1;
		}
		
		return result;
	}

}
