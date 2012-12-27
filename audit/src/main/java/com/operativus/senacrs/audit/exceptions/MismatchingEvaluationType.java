package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.model.form.AbstractSequenceStringFieldComparable;
import com.operativus.senacrs.audit.model.form.EvaluationGrade;

@SuppressWarnings("serial")
public class MismatchingEvaluationType
		extends IllegalArgumentException {

	public MismatchingEvaluationType(final AbstractSequenceStringFieldComparable activity, final EvaluationGrade grade) {

		// TODO Auto-generated constructor stub
	}
}
