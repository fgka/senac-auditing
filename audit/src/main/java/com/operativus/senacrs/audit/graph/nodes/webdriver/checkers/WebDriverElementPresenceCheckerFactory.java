package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.properties.xpath.XPathPrefixesEnum;


public final class WebDriverElementPresenceCheckerFactory {

	public static WebDriverElementPresenceChecker createChecker(XPathPrefixesEnum type) {
		
		if (type == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("type");
		}
		
		return internCreateChecker(type);
	}
	
	protected static WebDriverElementPresenceChecker createDashboardChecker() {

		// TODO Auto-generated method stub
		return null;
	}

	private static WebDriverElementPresenceChecker internCreateChecker(XPathPrefixesEnum type) {
		
		WebDriverElementPresenceChecker result = null;

		switch (type) {
		case DASHBOARD:
			result = createDashboardChecker();
			break;
		default:
			throw new IllegalArgumentException(type.name());
		} 
				
		return result;
	}

	private WebDriverElementPresenceCheckerFactory() {
		
		super();
	}
}
