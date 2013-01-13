package com.operativus.senacrs.audit.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IllegalVarargsAmountExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIllegalVarargsAmountExceptionNegativeAmount() {

		this.thrown.expect(NegativeArraySizeException.class);
		new IllegalVarargsAmountException(-1);

	}
}
