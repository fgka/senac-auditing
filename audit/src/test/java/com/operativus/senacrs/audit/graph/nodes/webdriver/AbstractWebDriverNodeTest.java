package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

public class AbstractWebDriverNodeTest {

	private AbstractWebDriverNode node = null;
	private WebDriver driver = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

		this.thrown.expect(IllegalArgumentException.class);
		new AbstractWebDriverNode(null) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return false;
			}
		};
	}

	@Test
	public void testVerifyStateNull() {

		AbstractWebDriverNode obj = null;

		obj = new AbstractWebDriverNode(WebDriverNodeTypeEnum.NONE) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return AbstractWebDriverNodeTest.this.node
						.verifyStateConditions(driver);
			}
		};
		this.thrown.expect(IllegalArgumentException.class);
		obj.verifyState(null);
	}

	@Test
	public void testVerifyState() {

		AbstractWebDriverNode obj = null;

		obj = new AbstractWebDriverNode(WebDriverNodeTypeEnum.NONE) {

			@Override
			protected boolean verifyStateConditions(final WebDriver driver) {

				return AbstractWebDriverNodeTest.this.node
						.verifyStateConditions(driver);
			}
		};
		obj.verifyState(this.driver);
		Mockito.verify(this.node).verifyStateConditions(this.driver);
	}
}
