package com.operativus.senacrs.audit.graph.nodes.webdriver;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesEnum;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;


public final class WebDriverNodeFactory {

	private WebDriverNodeFactory() {
		
		super();
	}
	
	public static WebDriverNode createNode(WebDriverNodeTypeEnum type, Object... args) {
		
		WebDriverNode result = null;

		if (type == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("type");
		}
		internCreateNode(type, args);
		
		return result;
	}

	private static void internCreateNode(WebDriverNodeTypeEnum type, Object[] args) {
		
		String msg = null;

		switch (type) {
		case DASHBOARD:
			break;
		case NONE:
			//yes it is a fall-through to the default!!!
		default:
			msg = MessagesCentral.getMessage(ExceptionMessagesEnum.ILLEGAL_NODE_TYPE, type);
			throw new IllegalArgumentException(msg);
		}
	}		
}
