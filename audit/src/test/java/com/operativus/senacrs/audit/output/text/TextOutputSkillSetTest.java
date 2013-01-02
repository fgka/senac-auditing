package com.operativus.senacrs.audit.output.text;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.model.form.EssentialSkill;
import com.operativus.senacrs.audit.model.form.SkillSet;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;


public class TextOutputSkillSetTest {


	@Test
	public void testCheckArgumentsNullBuilder() {

		try {
			TextOutputSkillSet.checkArguments(null, creatSkillSet());
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private SkillSet creatSkillSet() {

		return new SkillSet(new EssentialSkill(TestBoilerplateUtils.randomString()));
	}

	@Test
	public void testCheckArgumentsNullSkillSet() {

		try {
			TextOutputSkillSet.checkArguments(new StringBuilder(), null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
}
