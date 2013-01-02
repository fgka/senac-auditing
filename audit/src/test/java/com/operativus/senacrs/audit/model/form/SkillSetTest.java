package com.operativus.senacrs.audit.model.form;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;


public class SkillSetTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAddRelatedSkill() {
		
		SkillSet obj = null;

		obj = new SkillSet(new EssentialSkill(TestBoilerplateUtils.randomString()));
		try {
			obj.addRelatedSkill(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

}
