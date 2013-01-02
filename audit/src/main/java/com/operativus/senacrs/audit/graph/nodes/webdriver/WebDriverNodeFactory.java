package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

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
		result = internCreateNode(type, args);

		return result;
	}

	private static WebDriverNode internCreateNode(WebDriverNodeTypeEnum type, Object[] args) {

		WebDriverNode result = null;
		String msg = null;
		
		if (type.getPrefixKey() != null) {
			result = internCreateNodeCheckerBased(type);
		} else if (WebDriverNodeTypeEnum.START.equals(type)) {
			result = internCreateNodeStart();
		} else if (WebDriverNodeTypeEnum.END.equals(type)) {
			result = internCreateNodeEnd();			
		} else if (WebDriverNodeTypeEnum.NONE.equals(type)) {
			msg = MessagesCentral.getMessage(ExceptionMessagesEnum.ILLEGAL_NODE_TYPE, type);
			throw new IllegalArgumentException(msg);
		}

		return result;
	}

	private static WebDriverNode internCreateNodeStart() {

		return new AbstractWebDriverNode(WebDriverNodeTypeEnum.START) {
			
			@Override
			protected boolean verifyStateConditions(WebDriver driver) {
			
				return false;
			}
		};  
	}

	private static WebDriverNode internCreateNodeEnd() {


		return new AbstractWebDriverNode(WebDriverNodeTypeEnum.END) {
			
			@Override
			protected boolean verifyStateConditions(WebDriver driver) {
			
				return false;
			}
		};  
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
