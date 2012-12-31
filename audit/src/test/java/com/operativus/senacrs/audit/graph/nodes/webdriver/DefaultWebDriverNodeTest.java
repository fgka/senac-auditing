package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverNodeTest {

	WebDriver driver = null;
	WebDriverElementPresenceChecker checker = null;
	
	
	@Before
	public void setUp() throws Exception {

		driver = Mockito.mock(WebDriver.class);
		checker = Mockito.mock(WebDriverElementPresenceChecker.class);
	}

	@After
	public void tearDown() throws Exception {

		driver = null;
		checker = null;
	}

	@Test
	public void testDefaultWebDriverNodeNull() {

		try {
			new DefaultWebDriverNode(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testVerifyStateConditions() {

		DefaultWebDriverNode obj = null;
		
		obj = new DefaultWebDriverNode(checker);
		obj.verifyStateConditions(driver);
		
		Mockito.verify(checker).hasAll(driver);
	}

}
