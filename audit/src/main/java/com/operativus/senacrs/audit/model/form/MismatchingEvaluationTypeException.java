package com.operativus.senacrs.audit.model.form;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesEnum;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MismatchingEvaluationTypeException
		extends IllegalArgumentException {

	private static String getMessage(final EvaluationType activityType, final EvaluationType gradeType) {

		String result = null;
		PropertyKey key = null;

		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getMessage(key, activityType, gradeType);

		return result;
	}

	public MismatchingEvaluationTypeException(final EvaluationType activityType, final EvaluationType gradeType) {

		super(getMessage(activityType, gradeType));
	}

	public MismatchingEvaluationTypeException(final Throwable cause, final EvaluationType activityType,
			final EvaluationType gradeType) {

		super(getMessage(activityType, gradeType), cause);
	}
}
