package com.operativus.senacrs.audit.graph.nodes.webdriver;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.graph.nodes.Node;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class WebDriverNodeFactoryTest {

	@Test
	public void testCreateNodeNull() {

		try {
			WebDriverNodeFactory.createNode(null);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCreateNodeNone() {

		try {
			WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.NONE);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCreateNodeStart() {

		WebDriverNode result = null;

		result = WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.START);
		Assert.assertNotNull(result);
		Assert.assertEquals(Node.START.toString(), result.toString());
	}

	@Test
	public void testCreateNodeEnd() {

		WebDriverNode result = null;

		result = WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.END);
		Assert.assertNotNull(result);
		Assert.assertEquals(Node.END.toString(), result.toString());
	}

	@Test
	public void testCreateNodeForXPathPrefix() {

		for (WebDriverNodeTypeEnum t : WebDriverNodeTypeEnum.values()) {
			if (t.getPrefixKey() != null) {
				this.testCheckerBasedNodeCreation(t);
			}
		}
	}

	private void testCheckerBasedNodeCreation(final WebDriverNodeTypeEnum t) {

		WebDriverNode result = null;
		String msg = null;

		msg = t.name();
		try {
			result = WebDriverNodeFactory.createNode(t);
			Assert.assertNotNull(msg, result);
			Assert.assertTrue(msg, result instanceof WebDriverNodeCheckerBased);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail(msg + ":" + e.getLocalizedMessage());
		}
	}

	@Test
	public void testCreateNodeYearNoParams() {

		try {
			WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.YEAR);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCreateNodeYear() {

		WebDriverNode result = null;

		result = WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.YEAR, TestBoilerplateUtils.randomInt(3000));
		Assert.assertNotNull(result);
	}
}
