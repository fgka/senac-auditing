package com.operativus.senacrs.audit.extractors.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.operativus.senacrs.audit.model.config.Configuration;
import com.operativus.senacrs.audit.model.form.Form;

public class WebDataExtractorTest {

	private Configuration config = null;
	
	@Before
	public void setUp() throws Exception {

		config = new Configuration();
	}

	@After
	public void tearDown() throws Exception {

		config = null;
	}

	@Test
	public void testWebDataExtractorNull() {

		try {
			new WebDataExtractor(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testExtract() {

		WebDataExtractor obj = null;
		Form result = null;
		
		obj = new WebDataExtractor(this.config);
		result = obj.extract();
		Assert.assertNotNull(result);
		//TODO
	}

}
