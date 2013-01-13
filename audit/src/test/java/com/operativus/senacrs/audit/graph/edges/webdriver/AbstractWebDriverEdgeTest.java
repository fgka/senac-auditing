package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.Node;
import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNode;

public class AbstractWebDriverEdgeTest {

	private WebDriver driver = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {

		this.driver = Mockito.mock(WebDriver.class);
	}

	@After
	public void tearDown() throws Exception {

		this.driver = null;
	}

	@Test
	public void testAbstractWebDriverEdgeNull() {

		thrown.expect(IllegalArgumentException.class);
		new AbstractWebDriverEdge(null) {

			@Override
			protected void internTraverse(WebDriverNode source) {
				// do nothing
			}
		};
	}

	@Test
	public void testTraverseNull() {

		AbstractWebDriverEdge obj = null;

		obj = getBaseline();
		thrown.expect(IllegalArgumentException.class);
		obj.traverse(null);
	}

	private AbstractWebDriverEdge getBaseline() {

		return new AbstractWebDriverEdge(this.driver) {

			@Override
			protected void internTraverse(WebDriverNode source) {
				// do nothing				
			}};
	}

	@Test
	public void testTraverseNonWebDriverNode() {

		AbstractWebDriverEdge obj = null;

		obj = getBaseline();
		thrown.expect(IllegalSourceNodeClassException.class);
		obj.traverse(Node.START);
	}

}
