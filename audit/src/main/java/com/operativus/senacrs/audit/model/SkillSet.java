package com.operativus.senacrs.audit.model;

import java.util.LinkedList;
import java.util.List;

public class SkillSet {

	private final EssentialSkill essential;
	private List<RelatedSkill> skills = new LinkedList<RelatedSkill>();

	public SkillSet(EssentialSkill essential) {

		super();
		this.essential = essential;
	}

	public List<RelatedSkill> getSkills() {

		return skills;
	}

	public void addRelatedSkill(RelatedSkill skill) {

		if (skill == null) {
			throw new IllegalArgumentException();
		}
		this.skills.add(skill);
	}

	public EssentialSkill getEssential() {

		return essential;
	}
}
