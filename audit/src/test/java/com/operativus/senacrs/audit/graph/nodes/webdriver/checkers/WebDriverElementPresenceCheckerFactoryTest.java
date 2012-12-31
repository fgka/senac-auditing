package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverCheckerTypeEnum;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;
import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceCheckerFactory;

public class WebDriverElementPresenceCheckerFactoryTest {

	@Test
	public void testCreateCheckerNull() {

		try {
			WebDriverElementPresenceCheckerFactory.createChecker(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCreateCheckerAllTypes() {

		WebDriverElementPresenceChecker result = null;

		for (WebDriverCheckerTypeEnum t : WebDriverCheckerTypeEnum.values()) {
			result = WebDriverElementPresenceCheckerFactory.createChecker(t);
			Assert.assertNotNull(result);
		}
	}
}
