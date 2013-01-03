package com.operativus.senacrs.audit.model.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testHashCodeEmpty() {

		Configuration objA = null;
		Configuration objB = null;

		objA = new Configuration();
		objB = new Configuration();
		Assert.assertEquals(objA.hashCode(), objB.hashCode());
	}

	@Test
	public void testEqualsEmpty() {

		Configuration objA = null;
		Configuration objB = null;

		objA = new Configuration();
		objB = new Configuration();
		Assert.assertTrue(objA.equals(objB));
	}

}
