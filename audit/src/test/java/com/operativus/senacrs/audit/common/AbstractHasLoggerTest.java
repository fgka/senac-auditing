package com.operativus.senacrs.audit.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class AbstractHasLoggerTest {

	public class MyHasLogger
			extends AbstractHasLogger {

		public MyHasLogger() {

			super();
		}
	}

	@Test
	public void testGetLoggerAnnonymousClassName() {

		HasLogger obj = null;
		Logger result = null;

		obj = new AbstractHasLogger() {
		};
		result = obj.getLogger();
		Assert.assertEquals(obj.getClass().getName(), result.getName());
	}

	@Test
	public void testGetLoggerClassName() {

		HasLogger obj = null;
		Logger result = null;

		obj = new MyHasLogger();
		result = obj.getLogger();
		Assert.assertEquals(MyHasLogger.class.getName(), result.getName());
	}

	@Test
	public void testGetLoggerNonNull() {

		HasLogger obj = null;
		Logger result = null;

		LogManager.getLogger(this.getClass());
		obj = new AbstractHasLogger() {
		};
		result = obj.getLogger();
		Assert.assertNotNull(result);
	}
}
