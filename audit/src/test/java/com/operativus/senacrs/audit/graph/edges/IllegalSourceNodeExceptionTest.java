package com.operativus.senacrs.audit.graph.edges;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IllegalSourceNodeExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIllegalSourceNodeExceptionNodeNodeArrayNullSource() {

		this.thrown.expect(IllegalArgumentException.class);
		new IllegalSourceNodeException(null);
	}

}
