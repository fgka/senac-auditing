package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.operativus.senacrs.audit.model.form.EvaluationGrade;
import com.operativus.senacrs.audit.model.form.StudentEvaluation;

public final class TextOutputCollectionStudentEvaluation {

	private static final String GRADES_PREFIX_SEP_PARENS = "(";
	private static final String GRADES_SUFFIX_SEP_PARENS_EQUALS = ")=";
	private static final String FIELD_SEP_COMMA_SPACE = ", ";
	private static final String FIELD_SEP_COMMA = ",";

	private TextOutputCollectionStudentEvaluation() {

		super();
	}

	private static void buidEvaluation(final StringBuilder builder, final StudentEvaluation eval) {

		builder.append(eval.getName());
		builder.append(GRADES_PREFIX_SEP_PARENS);
		buildGrades(builder, eval.createAscendingGradesList());
		builder.append(GRADES_SUFFIX_SEP_PARENS_EQUALS);
		builder.append(eval.getFinalGrade().toString());
	}

	private static void buildGrade(final StringBuilder builder, final EvaluationGrade grade) {

		builder.append(grade.toString());
	}

	private static void buildGrades(final StringBuilder builder, final List<EvaluationGrade> grades) {

		Iterator<EvaluationGrade> iter = null;

		iter = grades.iterator();
		if (iter.hasNext()) {
			buildGrade(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(FIELD_SEP_COMMA);
				buildGrade(builder, iter.next());
			}
		}
	}

	public static void buildStudents(final StringBuilder builder, final Collection<StudentEvaluation> input) {

		Iterator<StudentEvaluation> iter = null;
		StudentEvaluation eval = null;

		checkArguments(builder, input);
		iter = input.iterator();
		if (iter.hasNext()) {
			eval = iter.next();
			buidEvaluation(builder, eval);
			while (iter.hasNext()) {
				builder.append(FIELD_SEP_COMMA_SPACE);
				eval = iter.next();
				buidEvaluation(builder, eval);
			}
		}
	}

	protected static void checkArguments(final StringBuilder builder, final Collection<StudentEvaluation> input) {

		if (builder == null) {
			throw new IllegalArgumentException();
		}
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}
}
