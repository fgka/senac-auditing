package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;

public class DefaultWebDriverNodeTest {

	WebDriver driver = null;
	WebDriverElementPresenceChecker checker = null;

	@Before
	public void setUp() throws Exception {

		this.driver = Mockito.mock(WebDriver.class);
		this.checker = Mockito.mock(WebDriverElementPresenceChecker.class);
	}

	@After
	public void tearDown() throws Exception {

		this.driver = null;
		this.checker = null;
	}

	@Test
	public void testDefaultWebDriverNodeNull() {

		try {
			new WebDriverNodeCheckerBased(WebDriverNodeTypeEnum.NONE, null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testVerifyStateConditions() {

		WebDriverNodeCheckerBased obj = null;

		obj = new WebDriverNodeCheckerBased(WebDriverNodeTypeEnum.NONE, this.checker);
		obj.verifyStateConditions(this.driver);

		Mockito.verify(this.checker).hasAll(this.driver);
	}

}
