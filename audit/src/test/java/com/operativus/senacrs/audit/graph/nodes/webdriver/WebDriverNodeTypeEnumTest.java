package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.junit.Assert;
import org.junit.Test;


public class WebDriverNodeTypeEnumTest {

	@Test
	public void testToString() {

		for (WebDriverNodeTypeEnum e : WebDriverNodeTypeEnum.values()) {
			Assert.assertEquals(e.name(), e.toString());
		}
	}

}
