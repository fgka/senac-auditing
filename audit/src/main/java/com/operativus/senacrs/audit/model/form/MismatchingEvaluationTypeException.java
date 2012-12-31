package com.operativus.senacrs.audit.model.form;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesEnum;
import com.operativus.senacrs.audit.messages.Messages;
import com.operativus.senacrs.audit.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MismatchingEvaluationTypeException
		extends IllegalArgumentException {

	public MismatchingEvaluationTypeException(final EvaluationType activityType, final EvaluationType gradeType) {

		super(getMessage(activityType, gradeType));
	}

	private static String getMessage(final EvaluationType activityType, final EvaluationType gradeType) {

		String result = null;
		Messages key = null;

		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getMessage(key, activityType, gradeType);

		return result;
	}

	public MismatchingEvaluationTypeException(final Throwable cause, final EvaluationType activityType,
			final EvaluationType gradeType) {

		super(getMessage(activityType, gradeType), cause);
	}
}