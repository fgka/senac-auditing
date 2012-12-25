package com.operativus.senacrs.audit.model;

import java.util.LinkedList;
import java.util.List;

public class SkillSet {

	private final EssentialSkill essential;
	private final List<RelatedSkill> skills = new LinkedList<RelatedSkill>();

	public SkillSet(final EssentialSkill essential) {

		super();
		this.essential = essential;
	}

	public List<RelatedSkill> getSkills() {

		return this.skills;
	}

	public void addRelatedSkill(final RelatedSkill skill) {

		if (skill == null) {
			throw new IllegalArgumentException();
		}
		this.skills.add(skill);
	}

	public EssentialSkill getEssential() {

		return this.essential;
	}
}
