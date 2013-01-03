package com.operativus.senacrs.audit.model.form;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class SkillSetTest {

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
