package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.properties.xpath.XPathPrefixesEnum;

public class WebDriverElementPresenceCheckerFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCreateCheckerNull() {

		this.thrown.expect(IllegalArgumentException.class);
		WebDriverElementPresenceCheckerFactory.createChecker(null);
	}

	@Test
	public void testCreateCheckerAllTypes() {

		WebDriverElementPresenceChecker result = null;

		for (XPathPrefixesEnum t : XPathPrefixesEnum.values()) {
			result = WebDriverElementPresenceCheckerFactory.createChecker(t);
			Assert.assertNotNull(result);
		}
	}
}
