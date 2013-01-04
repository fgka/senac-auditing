package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.Assert;
import org.junit.Test;

public class IllegalNodeTypeExceptionTest {

	@Test
	public void testIllegalNodeTypeExceptionNull() {

		try {
			new IllegalNodeTypeException(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

}
