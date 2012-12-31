package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.common.AbstractHasLogger;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;


public abstract class AbstractWebDriverNode extends AbstractHasLogger implements WebDriverNode {

	
	@Override
	public boolean verifyState(WebDriver driver) {
	
		if (driver == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("driver");
		}

		return verifyStateConditions(driver);
	}

	protected abstract boolean verifyStateConditions(WebDriver driver);
}
