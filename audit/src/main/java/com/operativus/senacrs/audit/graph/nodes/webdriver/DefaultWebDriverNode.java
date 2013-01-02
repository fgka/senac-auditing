package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;


public class DefaultWebDriverNode extends AbstractWebDriverNode {
	
	private final WebDriverElementPresenceChecker checker;
	
	public DefaultWebDriverNode(WebDriverNodeType type, WebDriverElementPresenceChecker checker) {

		super(type);

		if (checker == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("checker");
		}
		this.checker = checker;
	}

	@Override
	protected boolean verifyStateConditions(WebDriver driver) {

		return this.checker.hasAll(driver);
	}
}
