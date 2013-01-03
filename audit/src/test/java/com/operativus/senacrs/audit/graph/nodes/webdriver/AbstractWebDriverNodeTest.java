package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

public class AbstractWebDriverNodeTest {

	AbstractWebDriverNode node = null;
	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {

		this.node = Mockito.mock(AbstractWebDriverNode.class);
		this.driver = Mockito.mock(WebDriver.class);
	}

	@After
	public void tearDown() throws Exception {

		this.node = null;
		this.driver = null;
	}

	@Test
	public void testAbstractWebDriverNodeNull() {

		try {
			new AbstractWebDriverNode(null) {

				@Override
				protected boolean verifyStateConditions(final WebDriver driver) {

					return false;
				}
			};
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testVerifyStateNull() {

		AbstractWebDriverNode obj = null;

		obj = new AbstractWebDriverNode(WebDriverNodeTypeEnum.NONE) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return AbstractWebDriverNodeTest.this.node.verifyStateConditions(driver);
			}
		};
		try {
			obj.verifyState(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testVerifyState() {

		AbstractWebDriverNode obj = null;

		obj = new AbstractWebDriverNode(WebDriverNodeTypeEnum.NONE) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return AbstractWebDriverNodeTest.this.node.verifyStateConditions(driver);
			}
		};
		obj.verifyState(this.driver);
		Mockito.verify(this.node).verifyStateConditions(this.driver);
	}
}
