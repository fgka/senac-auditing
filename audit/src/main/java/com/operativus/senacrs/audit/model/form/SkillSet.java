package com.operativus.senacrs.audit.model.form;

import java.util.LinkedList;
import java.util.List;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;

public class SkillSet {

	private final EssentialSkill essential;
	private final List<RelatedSkill> skills = new LinkedList<RelatedSkill>();

	public SkillSet(final EssentialSkill essential) {

		super();
		this.essential = essential;
	}

	public EssentialSkill getEssential() {

		return this.essential;
	}

	public List<RelatedSkill> getSkills() {

		return this.skills;
	}

	public void addRelatedSkill(final RelatedSkill skill) {

		if (skill == null) {
			throw RuntimeExceptionFactory.getNullArgumentException("skill");
		}
		this.skills.add(skill);
	}

	@Override
	public String toString() {

		StringBuilder result = null;
		String nl = System.getProperty("line.separator");

		result = new StringBuilder();
		result.append(this.essential.toString());
		result.append(nl);
		result.append(this.skills.toString());

		return result.toString();
	}
}
