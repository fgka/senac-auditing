package com.operativus.senacrs.audit.model.form;

public interface EvaluationGrade {

	EvaluationType getType();

	void fromString(String str);

	@Override
	String toString();
}
