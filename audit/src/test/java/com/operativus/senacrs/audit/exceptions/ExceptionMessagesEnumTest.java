package com.operativus.senacrs.audit.exceptions;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.properties.messages.MessagesCentral;

public class ExceptionMessagesEnumTest {

	@Test
	public void testExists() {

		for (ExceptionMessagesKeyEnum e : ExceptionMessagesKeyEnum.values()) {
			Assert.assertTrue(e.name(), MessagesCentral.hasKey(e));
		}
	}

}
