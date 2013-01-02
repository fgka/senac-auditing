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

	public static WebDriverNode createNode(WebDriverNodeType type, Object... args) {

		WebDriverNode result = null;

		if (type == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("type");
		}
		result = internCreateNode(type, args);

		return result;
	}

	private static WebDriverNode internCreateNode(WebDriverNodeType type, Object[] args) {

		WebDriverNode result = null;
		String msg = null;

		if (type.getPrefixKey() != null) {
			result = internCreateNodeCheckerBased(type);
		} else {
			msg = MessagesCentral.getMessage(ExceptionMessagesEnum.ILLEGAL_NODE_TYPE, type);
			throw new IllegalArgumentException(msg);
		}

		return result;
	}

	private static WebDriverNode internCreateNodeCheckerBased(WebDriverNodeType type) {

		WebDriverNode result = null;
		WebDriverElementPresenceChecker checker = null;

		checker = createChecker(type.getPrefixKey());
		result = new WebDriverNodeCheckerBased(type, checker);

		return result;
	}

	private static WebDriverElementPresenceChecker createChecker(XPathKeyPrefix prefixKey) {

		return WebDriverElementPresenceCheckerFactory.createChecker(prefixKey);
	}
}
