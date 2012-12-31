package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.MessagesCentral;

public final class RuntimeExceptionFactory {

	private static final RuntimeExceptionFactory instance = new RuntimeExceptionFactory();

	public static RuntimeExceptionFactory getInstance() {

		return instance;
	}

	private RuntimeExceptionFactory() {

		super();
	}

	public IllegalArgumentException getNullArgumentException(final String argumentName) {

		IllegalArgumentException result = null;
		String msg = null;

		if (argumentName == null) {
			throw new IllegalArgumentException();
		}
		msg = MessagesCentral.getMessage(ExceptionMessagesEnum.NULL_ARGUMENT, argumentName);
		result = new IllegalArgumentException(msg);

		return result;
	};
}
