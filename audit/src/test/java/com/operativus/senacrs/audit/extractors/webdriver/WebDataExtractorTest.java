package com.operativus.senacrs.audit.extractors.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.config.Configuration;
import com.operativus.senacrs.audit.model.form.Form;

public class WebDataExtractorTest {

	private Configuration config = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {

		this.config = new Configuration();
	}

	@After
	public void tearDown() throws Exception {

		this.config = null;
	}

	@Test
	public void testWebDataExtractorNull() {

		this.thrown.expect(IllegalArgumentException.class);
		new WebDataExtractor(null);
	}

	@Test
	public void testExtract() {

		WebDataExtractor obj = null;
		Form result = null;

		obj = new WebDataExtractor(this.config);
		result = obj.extract();
		Assert.assertNotNull(result);
		// TODO
	}

}
