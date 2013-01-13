package com.operativus.senacrs.audit.output.text;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.form.EssentialSkill;
import com.operativus.senacrs.audit.model.form.SkillSet;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class TextOutputSkillSetTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCheckArgumentsNullBuilder() {

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputSkillSet.checkArguments(null, this.creatSkillSet());
	}

	private SkillSet creatSkillSet() {

		return new SkillSet(new EssentialSkill(TestBoilerplateUtils.randomString()));
	}

	@Test
	public void testCheckArgumentsNullSkillSet() {

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputSkillSet.checkArguments(new StringBuilder(), null);
	}
}
