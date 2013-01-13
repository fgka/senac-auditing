package com.operativus.senacrs.audit.model.form;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class SkillSetTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAddRelatedSkill() {

		SkillSet obj = null;

		obj = new SkillSet(new EssentialSkill(TestBoilerplateUtils.randomString()));
		this.thrown.expect(IllegalArgumentException.class);
		obj.addRelatedSkill(null);
	}

}
