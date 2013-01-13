package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IllegalNodeTypeExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIllegalNodeTypeExceptionNull() {

		this.thrown.expect(IllegalArgumentException.class);
		new IllegalNodeTypeException(null);
	}

}
