package com.operativus.senacrs.audit.exceptions;

import com.operativus.senacrs.audit.messages.Messages;
import com.operativus.senacrs.audit.messages.MessagesCentral;

@SuppressWarnings("serial")
public class MissingMinimalConfigurationEntry
		extends IllegalArgumentException {
		
	public MissingMinimalConfigurationEntry(String file, String entry) {
		
		super(getMessage(file, entry));
	}
	
	private static String getMessage(String file, String entry) {
		
		String result = null;
		Messages key = null;
		
		key = ExceptionMessagesEnum.EVAL_TYPE_MISMATCH;
		result = MessagesCentral.getMessage(key, file, entry);
		
		return result;
	}

	public MissingMinimalConfigurationEntry(Throwable cause, String file, String entry) {

		super(getMessage(file, entry), cause);
	}
}
