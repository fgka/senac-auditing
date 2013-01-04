package com.operativus.senacrs.audit.exceptions;

import java.util.Arrays;

import com.google.common.base.Objects;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

@SuppressWarnings("serial")
public class IllegalVarargsAmountException
		extends IllegalArgumentException {

	public IllegalVarargsAmountException(final int expectedAmount, final Objects... varargs) {

		super(getMessage(expectedAmount, varargs));
	}

	private static String getMessage(final int expectedAmount, final Objects... varargs) {

		String result = null;
		PropertyKey key = null;

		if (expectedAmount < 0) {
			throw new NegativeArraySizeException();
		}
		key = ExceptionMessagesKeyEnum.ILLEGAL_VARARGS_AMOUNT;
		result = MessagesCentral.getMessage(key, expectedAmount, Arrays.toString(varargs));

		return result;
	}

	public IllegalVarargsAmountException(final Throwable cause, final int expectedAmount, final Objects... varargs) {

		super(getMessage(expectedAmount, varargs), cause);
	}
}
