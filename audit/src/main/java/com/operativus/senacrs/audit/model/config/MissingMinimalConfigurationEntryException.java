package com.operativus.senacrs.audit.model.config;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesKeyEnum;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MissingMinimalConfigurationEntryException
		extends IllegalArgumentException {

	private static String getMessage(final String file, final String entry) {

		String result = null;
		PropertyKey key = null;

		key = ExceptionMessagesKeyEnum.MISSING_MINIMAL_CONFIG_ENTRY;
		result = MessagesCentral.getMessage(key, file, entry);

		return result;
	}

	public MissingMinimalConfigurationEntryException(final String file, final String entry) {

		super(getMessage(file, entry));
	}

	public MissingMinimalConfigurationEntryException(final Throwable cause, final String file, final String entry) {

		super(getMessage(file, entry), cause);
	}
}
