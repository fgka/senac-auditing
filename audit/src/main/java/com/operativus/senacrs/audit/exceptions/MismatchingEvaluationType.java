package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.Messages;
import com.operativus.senacrs.audit.messages.MessagesCentral;
import com.operativus.senacrs.audit.model.form.EvaluationType;

@SuppressWarnings("serial")
public class MismatchingEvaluationType
		extends IllegalArgumentException {
		
	public MismatchingEvaluationType(EvaluationType activityType, EvaluationType gradeType) {
		
		super(getMessage(activityType, gradeType));
	}
	
	private static String getMessage(EvaluationType activityType, EvaluationType gradeType) {
		
		String result = null;
		Messages key = null;
		
		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getInstance().getMessage(key, activityType, gradeType);
		
		return result;
	}

	public MismatchingEvaluationType(Throwable cause, EvaluationType activityType, EvaluationType gradeType) {

		super(getMessage(activityType, gradeType), cause);
	}
}
