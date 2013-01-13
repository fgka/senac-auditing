package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.webdriver.checkers.WebDriverElementPresenceChecker;

public class DefaultWebDriverNodeTest {

	private WebDriver driver = null;
	private WebDriverElementPresenceChecker checker = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

		this.thrown.expect(IllegalArgumentException.class);
		new WebDriverNodeCheckerBased(WebDriverNodeTypeEnum.NONE, null);
	}

	@Test
	public void testVerifyStateConditions() {

		WebDriverNodeCheckerBased obj = null;

		obj = new WebDriverNodeCheckerBased(WebDriverNodeTypeEnum.NONE, this.checker);
		obj.verifyStateConditions(this.driver);

		Mockito.verify(this.checker).hasAll(this.driver);
	}

}
