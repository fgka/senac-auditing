package com.operativus.senacrs.audit.model;

public interface EvaluationGrade {

	EvaluationType getType();

	void fromString(String str);

	@Override
	String toString();
}
