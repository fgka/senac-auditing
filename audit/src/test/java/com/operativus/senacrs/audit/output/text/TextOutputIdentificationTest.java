package com.operativus.senacrs.audit.output.text;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.form.Identification;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class TextOutputIdentificationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCheckArgumentsNullBuilder() {

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputIdentification.checkArguments(null, this.createIdentification());
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

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputIdentification.checkArguments(new StringBuilder(), null);
	}
}
