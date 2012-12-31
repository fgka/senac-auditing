package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.Assert;
import org.junit.Test;

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
