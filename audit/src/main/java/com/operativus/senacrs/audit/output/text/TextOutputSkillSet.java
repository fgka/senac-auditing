package com.operativus.senacrs.audit.output.text;

import java.util.Iterator;
import java.util.List;

import com.operativus.senacrs.audit.model.form.RelatedSkill;
import com.operativus.senacrs.audit.model.form.SkillSet;

public final class TextOutputSkillSet {

	private static enum RelatedSkillField {
		DESCRIPTION,
		REQUIRED_ATTITUDE,
		RESULTS_EVIDENCE, ;
	}
	private static final String FIELD_SEP_COMMA_SPACE = ", ";

	private TextOutputSkillSet() {

		super();
	}

	public static void buildEssentialSkill(final StringBuilder builder, final SkillSet input) {

		checkArguments(builder, input);
		builder.append(input.getEssential().getDescription());
	}

	private static void buildRelatedSkill(final StringBuilder builder, final RelatedSkill skill,
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

	private static void buildRelatedSkills(final StringBuilder builder, final List<RelatedSkill> skills,
			final RelatedSkillField field) {

		Iterator<RelatedSkill> iter = null;
		RelatedSkill skill = null;

		iter = skills.iterator();
		if (iter.hasNext()) {
			skill = iter.next();
			buildRelatedSkill(builder, skill, field);
			while (iter.hasNext()) {
				builder.append(FIELD_SEP_COMMA_SPACE);
				skill = iter.next();
				buildRelatedSkill(builder, skill, field);
			}
		}
	}

	public static void buildRelatedSkills(final StringBuilder builder, final SkillSet input) {

		checkArguments(builder, input);
		buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.DESCRIPTION);
	}

	public static void buildRequiredAttitudes(final StringBuilder builder, final SkillSet input) {

		checkArguments(builder, input);
		buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.REQUIRED_ATTITUDE);
	}

	public static void buildResultEvidences(final StringBuilder builder, final SkillSet input) {

		checkArguments(builder, input);
		buildRelatedSkills(builder, input.getSkills(), RelatedSkillField.RESULTS_EVIDENCE);
	}

	protected static void checkArguments(final StringBuilder builder, final SkillSet input) {

		if (builder == null) {
			throw new IllegalArgumentException();
		}
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}
}
