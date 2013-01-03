package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.common.AbstractHasLogger;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;

public abstract class AbstractWebDriverNode
		extends AbstractHasLogger
		implements WebDriverNode {

	private final WebDriverNodeType type;

	protected AbstractWebDriverNode(final WebDriverNodeType type) {

		super();

		if (type == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("type");
		}
		this.type = type;
	}

	@Override
	public boolean verifyState(final WebDriver driver) {

		if (driver == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("driver");
		}

		return this.verifyStateConditions(driver);
	}

	protected abstract boolean verifyStateConditions(WebDriver driver);

	@Override
	public WebDriverNodeType getType() {

		return this.type;
	}

	@Override
	public String toString() {

		return this.type.toString();
	}
}
