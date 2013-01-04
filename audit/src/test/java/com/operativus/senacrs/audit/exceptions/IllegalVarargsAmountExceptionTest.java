package com.operativus.senacrs.audit.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class IllegalVarargsAmountExceptionTest {

	@Test
	public void testIllegalVarargsAmountExceptionNegativeAmount() {

		try {
			new IllegalVarargsAmountException(-1);
			Assert.fail();
		} catch (NegativeArraySizeException e) {
			Assert.assertTrue(true);
		}

	}
}
