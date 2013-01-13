package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IllegalSourceNodeTypeExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIllegalSourceNodeClassExceptionNullNode() {

		this.thrown.expect(IllegalArgumentException.class);
		new IllegalSourceNodeTypeException(null);
	}

}
