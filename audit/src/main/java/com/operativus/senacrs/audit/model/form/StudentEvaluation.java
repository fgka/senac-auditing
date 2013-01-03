package com.operativus.senacrs.audit.model.form;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentEvaluation
		extends
		AbstractSequenceStringFieldComparable {

	private final String name;
	private final Map<EvaluationActivity, EvaluationGrade> grades = new TreeMap<EvaluationActivity, EvaluationGrade>();
	private EvaluationGrade finalGrade = null;

	public StudentEvaluation(final int sequence, final String name) {

		super(sequence);
		this.name = name;
	}

	@Override
	protected String getComparisonStringField() {

		return this.getName();
	}

	public String getName() {

		return this.name;
	}

	public EvaluationGrade getFinalGrade() {

		return this.finalGrade;
	}

	public void setFinalGrade(final EvaluationGrade finalGrade) {

		this.finalGrade = finalGrade;
	}

	public EvaluationGrade putGrade(final EvaluationActivity activity, final EvaluationGrade grade) {

		if (activity == null) {
			throw new IllegalArgumentException();
		}
		if (grade == null) {
			throw new IllegalArgumentException();
		}
		if (EvaluationType.INVALID.equals(activity.getType())) {
			throw new InvalidEvaluationTypeException();
		}
		if (EvaluationType.INVALID.equals(grade.getType())) {
			throw new InvalidEvaluationTypeException();
		}
		if (activity.getType() != grade.getType()) {
			throw new MismatchingEvaluationTypeException(activity.getType(), grade.getType());
		}

		return this.grades.put(activity, grade);
	}

	public List<EvaluationGrade> createAscendingGradesList() {

		List<EvaluationGrade> result = null;

		result = new LinkedList<EvaluationGrade>();
		for (Map.Entry<EvaluationActivity, EvaluationGrade> e : this.grades.entrySet()) {
			result.add(e.getValue());
		}

		return result;
	}

	@Override
	public String toString() {

		StringBuilder result = null;

		result = new StringBuilder();
		result.append(super.toString());
		result.append(":");
		for (Map.Entry<EvaluationActivity, EvaluationGrade> e : this.grades.entrySet()) {
			result.append("," + e.getKey().getName() + "=" + e.getValue().toString());
		}
		result.append(":");
		result.append(String.valueOf(this.finalGrade));

		return result.toString();
	}
}
