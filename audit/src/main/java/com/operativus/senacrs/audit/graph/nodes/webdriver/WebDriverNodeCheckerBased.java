package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;

public class WebDriverNodeCheckerBased
		extends AbstractWebDriverNode {

	private final WebDriverElementPresenceChecker checker;

	public WebDriverNodeCheckerBased(final WebDriverNodeType type, final WebDriverElementPresenceChecker checker) {

		super(type);

		if (checker == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("checker");
		}
		this.checker = checker;
	}

	@Override
	protected boolean verifyStateConditions(final WebDriver driver) {

		return this.checker.hasAll(driver);
	}
}
