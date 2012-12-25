package com.operativus.senacrs.audit.model;

import java.util.HashMap;
import java.util.Map;

import com.operativus.senacrs.audit.exceptions.MismatchingEvaluationType;

public class StudentEvaluation implements Comparable<StudentEvaluation>{

	private final int sequence;
	private final String name;
	private Map<EvaluationActivity, EvaluationGrade> grades = new HashMap<EvaluationActivity, EvaluationGrade>();
	private EvaluationGrade finalGrade = null;

	public StudentEvaluation(int sequence, String name) {

		super();
		this.sequence = sequence;
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public int getSequence() {

		return sequence;
	}

	public Map<EvaluationActivity, EvaluationGrade> getGrades() {

		return grades;
	}

	public EvaluationGrade putGrade(EvaluationActivity activity, EvaluationGrade grade) {

		if (activity.getType() != grade.getType()) {
			throw new MismatchingEvaluationType(activity, grade);
		}

		return this.grades.put(activity, grade);
	}

	public EvaluationGrade getFinalGrade() {

		return finalGrade;
	}

	public void setFinalGrade(EvaluationGrade finalGrade) {

		this.finalGrade = finalGrade;
	}

	@Override
	public int compareTo(StudentEvaluation o) {

		// TODO Auto-generated method stub
		return 0;
	}
}
