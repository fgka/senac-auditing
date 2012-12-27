package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.MessagesCentral;


public final class ExceptionFactory {

	private static final ExceptionFactory instance = new ExceptionFactory();
	
	private ExceptionFactory() {
		
		super();
	}
	
	public IllegalArgumentException getNullArgumentException(String argumentName) {
		
		IllegalArgumentException result = null;
		String msg = null;

		if (argumentName == null) {
			throw new IllegalArgumentException();
		}
		msg = MessagesCentral.getMessage(ExceptionMessagesEnum.NULL_ARGUMENT, argumentName);
		result = new IllegalArgumentException(msg);
		
		return result;
	}
	
	public static ExceptionFactory getInstance() {

		return instance;
	};
}
