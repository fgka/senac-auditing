package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.Messages;
import com.operativus.senacrs.audit.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MissingMinimalConfigurationEntry
		extends IllegalArgumentException {

	public MissingMinimalConfigurationEntry(final String file, final String entry) {

		super(getMessage(file, entry));
	}

	private static String getMessage(final String file, final String entry) {

		String result = null;
		Messages key = null;

		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getMessage(key, file, entry);

		return result;
	}

	public MissingMinimalConfigurationEntry(final Throwable cause, final String file, final String entry) {

		super(getMessage(file, entry), cause);
	}
}
