package com.operativus.senacrs.audit.exceptions;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;


public class ExceptionFactoryTest {

	@Test
	public void testGetNullArgumentExceptionNull() {
		
		try {
			ExceptionFactory.getInstance().getNullArgumentException(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testGetNullArgumentException() {
		
		IllegalArgumentException result = null;
		String arg = null;
		String msg = null;

		arg = TestBoilerplateUtils.randomString();
		result = ExceptionFactory.getInstance().getNullArgumentException(arg);
		Assert.assertNotNull(result);
		msg = result.getMessage();
		Assert.assertNotNull(msg);
		Assert.assertTrue(msg.contains(arg));
	}

}