package com.operativus.senacrs.audit.graph.edges.webdriver;

import java.util.Arrays;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesKeyEnum;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNodeType;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

public class IllegalSourceNodeTypeException
		extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1433686268676991836L;

	public IllegalSourceNodeTypeException(final WebDriverNodeType source, final WebDriverNodeType... valid) {

		super(getMessage(source, valid));
	}

	private static String getMessage(final WebDriverNodeType source, final WebDriverNodeType... valid) {

		String result = null;
		PropertyKey key = null;

		if (source == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("source");
		}
		key = ExceptionMessagesKeyEnum.ILLEGAL_NODE_START_TYPE;
		result = MessagesCentral.getMessage(key, source, Arrays.toString(valid));

		return result;
	}

	public IllegalSourceNodeTypeException(final Throwable cause, final WebDriverNodeType source,
			final WebDriverNodeType... valid) {

		super(getMessage(source, valid), cause);
	}
}
