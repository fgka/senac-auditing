package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.properties.xpath.XPathCentral;
import com.operativus.senacrs.audit.properties.xpath.XPathPrefixesEnum;

public final class WebDriverElementPresenceCheckerFactory {

	private WebDriverElementPresenceCheckerFactory() {

		super();
	}

	public static WebDriverElementPresenceChecker createChecker(final XPathPrefixesEnum type) {

		if (type == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("type");
		}

		return internCreateChecker(type);
	}

	private static WebDriverElementPresenceChecker internCreateChecker(final XPathPrefixesEnum type) {

		WebDriverElementPresenceChecker result = null;
		String[] xpathElements = null;

		xpathElements = XPathCentral.getXPathByPrefix(type);
		result = new WebDriverElementPresenceChecker(xpathElements);

		return result;
	}
}
