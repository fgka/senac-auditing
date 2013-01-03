package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

public final class RuntimeExceptionFactory {

	private RuntimeExceptionFactory() {
	
		super();
	}

	public static IllegalArgumentException getNullArgumentException(final String argumentName) {

		IllegalArgumentException result = null;
		String msg = null;

		if (argumentName == null) {
			throw new IllegalArgumentException();
		}
		msg = MessagesCentral.getMessage(ExceptionMessagesKeyEnum.NULL_ARGUMENT, argumentName);
		result = new IllegalArgumentException(msg);

		return result;
	}
}
