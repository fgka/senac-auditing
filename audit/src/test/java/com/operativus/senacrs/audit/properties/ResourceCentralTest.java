package com.operativus.senacrs.audit.properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class ResourceCentralTest {

	@Test
	public void testPopulateCentralNull() {

		ResourceCentral obj = null;

		obj = new ResourceCentral();
		try {
			obj.populateCentral((String[]) null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testPopulateCentralInvalidFile() {

		ResourceCentral obj = null;
		String resource = null;
		Logger logger = null;

		logger = Mockito.mock(Logger.class);
		resource = TestBoilerplateUtils.randomAlphanumericString();
		obj = this.getLogModifiedObject(resource, logger);
		obj.populateCentral(resource);
		Mockito.verify(logger).error(resource);
	}

	private ResourceCentral getLogModifiedObject(final String resource, final Logger logger) {

		return new ResourceCentral() {

			@Override
			protected void logException(final String resource, final Throwable exception) {

				logger.error(resource);
			}
		};
	}
}
