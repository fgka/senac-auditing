package com.operativus.senacrs.audit.model.form;

public interface EvaluationGrade {

	void fromString(String str);

	EvaluationType getType();

	@Override
	String toString();
}
