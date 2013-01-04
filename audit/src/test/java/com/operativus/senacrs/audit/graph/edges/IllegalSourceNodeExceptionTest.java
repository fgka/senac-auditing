package com.operativus.senacrs.audit.graph.edges;

import org.junit.Assert;
import org.junit.Test;

public class IllegalSourceNodeExceptionTest {

	@Test
	public void testIllegalSourceNodeExceptionNodeNodeArrayNullSource() {

		try {
			new IllegalSourceNodeException(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

}
