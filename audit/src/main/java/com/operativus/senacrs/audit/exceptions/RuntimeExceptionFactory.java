package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

public final class RuntimeExceptionFactory {

	private RuntimeExceptionFactory() {

		super();
	}

	public static IllegalArgumentException getNullArgumentException(final String argumentName) {

		return createException(ExceptionMessagesKeyEnum.NULL_ARGUMENT, argumentName);
	}

	private static IllegalArgumentException createException(final PropertyKey key, final String argumentName) {

		IllegalArgumentException result = null;
		String msg = null;

		if (argumentName == null) {
			throw new IllegalArgumentException();
		}
		msg = MessagesCentral.getMessage(key, argumentName);
		result = new IllegalArgumentException(msg);
		return result;
	}

	public static IllegalArgumentException getEmpyStringArgumentException(final String argumentName) {

		return createException(ExceptionMessagesKeyEnum.EMPTY_STRING_ARGUMENT, argumentName);
	}
}
