package com.operativus.senacrs.audit.output.text;

import java.util.Iterator;
import java.util.List;

import com.operativus.senacrs.audit.model.form.RelatedSkill;
import com.operativus.senacrs.audit.model.form.SkillSet;

public final class TextOutputSkillSet {

	private static final String FIELD_SEP_COMMA_SPACE = ", ";
	private static final TextOutputSkillSet instance = new TextOutputSkillSet();

	private static enum RelatedSkillField {
		DESCRIPTION,
		REQUIRED_ATTITUDE,
		RESULTS_EVIDENCE, ;
	}

	private TextOutputSkillSet() {

		super();
	}

	public void buildEssentialSkill(final StringBuilder builder, final SkillSet input) {

		this.checkArguments(builder, input);
		builder.append(input.getEssential().getDescription());
	}

	private void checkArguments(final StringBuilder builder, final SkillSet input) {

		if (builder == null) {
			throw new IllegalArgumentException();
		}
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}

	public void buildRelatedSkills(final StringBuilder builder, final SkillSet input) {

		this.checkArguments(builder, input);
		this.buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.DESCRIPTION);
	}

	private void buildRelatedSkills(final StringBuilder builder, final List<RelatedSkill> skills,
			final RelatedSkillField field) {

		Iterator<RelatedSkill> iter = null;
		RelatedSkill skill = null;

		iter = skills.iterator();
		if (iter.hasNext()) {
			skill = iter.next();
			this.buildRelatedSkill(builder, skill, field);
			while (iter.hasNext()) {
				builder.append(FIELD_SEP_COMMA_SPACE);
				skill = iter.next();
				this.buildRelatedSkill(builder, skill, field);
			}
		}
	}

	private void buildRelatedSkill(final StringBuilder builder, final RelatedSkill skill,
			final RelatedSkillField field) {

		String value = null;

		switch (field) {
		case DESCRIPTION:
			value = skill.getDescription();
			break;
		case REQUIRED_ATTITUDE:
			value = skill.getRequiredAttitude();
			break;
		case RESULTS_EVIDENCE:
			value = skill.getResultsEvidence();
			break;
		default:
			throw new IllegalArgumentException(String.valueOf(field));
		}
		builder.append(value);
	}

	public void buildRequiredAttitudes(final StringBuilder builder, final SkillSet input) {

		this.checkArguments(builder, input);
		this.buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.REQUIRED_ATTITUDE);
	}

	public void buildResultEvidences(final StringBuilder builder, final SkillSet input) {

		this.checkArguments(builder, input);
		this.buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.RESULTS_EVIDENCE);
	}

	public static TextOutputSkillSet getInstance() {

		return instance;
	}
}
