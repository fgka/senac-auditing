package com.operativus.senacrs.audit.model.config;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesEnum;
import com.operativus.senacrs.audit.messages.Messages;
import com.operativus.senacrs.audit.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MissingMinimalConfigurationEntryException
		extends IllegalArgumentException {

	public MissingMinimalConfigurationEntryException(final String file, final String entry) {

		super(getMessage(file, entry));
	}

	private static String getMessage(final String file, final String entry) {

		String result = null;
		Messages key = null;

		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getMessage(key, file, entry);

		return result;
	}

	public MissingMinimalConfigurationEntryException(final Throwable cause, final String file, final String entry) {

		super(getMessage(file, entry), cause);
	}
}
