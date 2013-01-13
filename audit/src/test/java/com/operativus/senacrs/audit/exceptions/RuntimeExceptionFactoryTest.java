package com.operativus.senacrs.audit.exceptions;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class RuntimeExceptionFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testGetNullArgumentExceptionNull() {

		this.thrown.expect(IllegalArgumentException.class);
		RuntimeExceptionFactory.getNullArgumentException(null);
	}

	@Test
	public void testGetNullArgumentException() {

		IllegalArgumentException result = null;
		String arg = null;
		String msg = null;

		arg = TestBoilerplateUtils.randomString();
		result = RuntimeExceptionFactory.getNullArgumentException(arg);
		Assert.assertNotNull(result);
		msg = result.getMessage();
		Assert.assertNotNull(msg);
		Assert.assertTrue(msg.contains(arg));
	}

}
