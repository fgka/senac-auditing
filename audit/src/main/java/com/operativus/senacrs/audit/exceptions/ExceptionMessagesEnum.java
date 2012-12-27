package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.Messages;


public enum ExceptionMessagesEnum implements Messages {
	
	EVAL_TYPE_MISMATCH("exception.eval.type.mismatch"),
	;
	
	private final String key;
	
	private ExceptionMessagesEnum(String key) {
		
		this.key = key;
	}

	@Override
	public String getKey() {

		return this.key;
	}
}
