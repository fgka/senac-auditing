package com.operativus.senacrs.audit.graph.nodes.webdriver;

import com.operativus.senacrs.audit.exceptions.ExceptionMessagesEnum;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceCheckerFactory;
import com.operativus.senacrs.audit.properties.messages.MessagesCentral;
import com.operativus.senacrs.audit.properties.xpath.XPathKeyPrefix;


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

	private static WebDriverNode internCreateNode(WebDriverNodeTypeEnum type, Object[] args) {
		
		WebDriverNode result = null;
		String msg = null;

		switch (type) {
		case DASHBOARD:
		case ABOUT:
		case LOGIN:
		case PORTAL:
		case CLASS:
		case GRADES:
		case PLAN:
			result = internCreateNodeCheckerBased(type);
			break;
		case NONE:
			result = null;
		default:
			msg = MessagesCentral.getMessage(ExceptionMessagesEnum.ILLEGAL_NODE_TYPE, type);
			throw new IllegalArgumentException(msg);
		}
		
		return result;
	}

	private static WebDriverNode internCreateNodeCheckerBased(WebDriverNodeTypeEnum type) {
		
		WebDriverNode result = null;
		WebDriverElementPresenceChecker checker = null;
		
		checker = createChecker(type.getPrefixKey());
		result = new WebDriverNodeCheckerBased(type, checker);

		return result;
	}

	private static WebDriverElementPresenceChecker createChecker(XPathKeyPrefix prefixKey) {

		WebDriverElementPresenceCheckerFactory.createChecker(prefixKey);
		return null;
	}		
}
