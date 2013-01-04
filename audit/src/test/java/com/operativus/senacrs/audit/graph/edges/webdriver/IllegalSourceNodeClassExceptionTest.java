package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.junit.Assert;
import org.junit.Test;

public class IllegalSourceNodeClassExceptionTest {

	@Test
	public void testIllegalSourceNodeClassExceptionNullNode() {

		try {
			new IllegalSourceNodeClassException(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

}
