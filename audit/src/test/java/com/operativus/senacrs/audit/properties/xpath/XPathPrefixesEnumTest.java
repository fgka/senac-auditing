package com.operativus.senacrs.audit.properties.xpath;

import org.junit.Assert;
import org.junit.Test;


public class XPathPrefixesEnumTest {


	@Test
	public void testToString() {

		for (XPathPrefixesEnum e : XPathPrefixesEnum.values()) {
			Assert.assertEquals(e.name(), e.toString());
		}
	}
}
