package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.exceptions.IllegalVarargsAmountException;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceCheckerFactory;
import com.operativus.senacrs.audit.properties.xpath.XPathCentral;
import com.operativus.senacrs.audit.properties.xpath.XPathKeyPrefix;
import com.operativus.senacrs.audit.properties.xpath.XPathParamKeyEnum;

public final class WebDriverNodeFactory {

	private WebDriverNodeFactory() {

		super();
	}

	public static WebDriverNode createNode(final WebDriverNodeTypeEnum type, final Object... args) {

		WebDriverNode result = null;

		if (type == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("type");
		}
		result = internCreateNode(type, args);

		return result;
	}

	private static WebDriverNode internCreateNode(final WebDriverNodeTypeEnum type, final Object[] args) {

		WebDriverNode result = null;

		if (type.getPrefixKey() != null) {
			result = internCreateNodeCheckerBased(type);
		} else if (WebDriverNodeTypeEnum.START.equals(type)) {
			result = internCreateNodeStart();
		} else if (WebDriverNodeTypeEnum.END.equals(type)) {
			result = internCreateNodeEnd();
		} else if (WebDriverNodeTypeEnum.YEAR.equals(type)) {
			result = internCreateNodeYear(args);
		} else if (WebDriverNodeTypeEnum.NONE.equals(type)) {
			throw new IllegalNodeTypeException(type);
		}

		return result;
	}

	private static WebDriverNode internCreateNodeCheckerBased(final WebDriverNodeType type) {

		WebDriverNode result = null;
		WebDriverElementPresenceChecker checker = null;

		checker = createChecker(type.getPrefixKey());
		result = new WebDriverNodeCheckerBased(type, checker);

		return result;
	}

	private static WebDriverElementPresenceChecker createChecker(final XPathKeyPrefix prefixKey) {

		return WebDriverElementPresenceCheckerFactory.createChecker(prefixKey);
	}

	private static WebDriverNode internCreateNodeYear(final Object[] args) {

		WebDriverNode result = null;
		int year = 0;

		if ((args == null) || (args.length < 1)) {
			throw new IllegalVarargsAmountException(1, args);
		}
		year = ((Integer) args[0]).intValue();
		result = internCreateNodeYear(year);

		return result;
	}

	private static WebDriverNode internCreateNodeYear(final int year) {

		WebDriverNode result = null;

		WebDriverElementPresenceChecker checker = null;
		checker = createCheckerForYear(year);
		result = new WebDriverNodeCheckerBased(WebDriverNodeTypeEnum.YEAR, checker);

		return result;
	}

	private static WebDriverElementPresenceChecker createCheckerForYear(final int year) {

		WebDriverElementPresenceChecker result = null;
		String[] xpaths = null;

		xpaths = new String[1];
		xpaths[0] = XPathCentral.getXPath(XPathParamKeyEnum.PORTAL_YEAR_IN_CLASSES, String.valueOf(year));
		result = new WebDriverElementPresenceChecker(xpaths);

		return result;
	}

	private static WebDriverNode internCreateNodeStart() {

		return new AbstractWebDriverNode(WebDriverNodeTypeEnum.START) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return false;
			}
		};
	}

	private static WebDriverNode internCreateNodeEnd() {

		return new AbstractWebDriverNode(WebDriverNodeTypeEnum.END) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return false;
			}
		};
	}
}
