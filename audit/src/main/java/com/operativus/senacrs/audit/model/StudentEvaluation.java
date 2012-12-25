package com.operativus.senacrs.audit.model;

import java.util.HashMap;
import java.util.Map;


public class StudentEvaluation {

	private final String name;
	private Map<EvaluationActivity, EvaluationGrade> grades = new HashMap<EvaluationActivity, EvaluationGrade>();
	private EvaluationGrade finalGrade = null;
	public StudentEvaluation(String name) {

		super();
		this.name = name;
	}
	
	public Map<EvaluationActivity, EvaluationGrade> getGrades() {
	
		return grades;
	}
	
	public EvaluationGrade putGrade(EvaluationActivity activity, EvaluationGrade grade) {
	
		return this.grades.put(activity, grade);
	}
	
	public EvaluationGrade getFinalGrade() {
	
		return finalGrade;
	}
	
	public void setFinalGrade(EvaluationGrade finalGrade) {
	
		this.finalGrade = finalGrade;
	}
	
	public String getName() {
	
		return name;
	}
	
	
}
