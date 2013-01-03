package com.operativus.senacrs.audit.output.text;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.model.form.Identification;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class TextOutputIdentificationTest {

	@Test
	public void testCheckArgumentsNullBuilder() {

		try {
			TextOutputIdentification.checkArguments(null, this.createIdentification());
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private Identification createIdentification() {

		return new Identification(
				TestBoilerplateUtils.randomString(),
				TestBoilerplateUtils.randomString(),
				TestBoilerplateUtils.randomString(),
				TestBoilerplateUtils.randomString(),
				TestBoilerplateUtils.randomString());
	}

	@Test
	public void testCheckArgumentsNullId() {

		try {
			TextOutputIdentification.checkArguments(new StringBuilder(), null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
}
