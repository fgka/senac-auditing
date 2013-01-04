package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.Node;

public class AbstractWebDriverEdgeTest {

	private WebDriver driver = null;

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

		try {
			new AbstractWebDriverEdge(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testTraverseNull() {

		AbstractWebDriverEdge obj = null;

		obj = getBaseline();
		try {
			obj.traverse(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private AbstractWebDriverEdge getBaseline() {

		return new AbstractWebDriverEdge(this.driver);
	}

	@Test
	public void testTraverseNonWebDriverNode() {

		AbstractWebDriverEdge obj = null;

		obj = getBaseline();
		try {
			obj.traverse(new Node() {
			});
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

}
