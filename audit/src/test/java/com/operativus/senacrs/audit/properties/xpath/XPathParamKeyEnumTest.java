package com.operativus.senacrs.audit.properties.xpath;

import org.junit.Assert;
import org.junit.Test;

public class XPathParamKeyEnumTest {

	@Test
	public void testExists() {

		for (XPathParamKeyEnum e : XPathParamKeyEnum.values()) {
			Assert.assertTrue(e.name(), XPathCentral.hasKey(e));
		}
	}
}
