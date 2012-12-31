package com.operativus.senacrs.audit.output.text;

import com.operativus.senacrs.audit.model.form.Form;
import com.operativus.senacrs.audit.model.form.Identification;
import com.operativus.senacrs.audit.model.form.SkillSet;
import com.operativus.senacrs.audit.output.FormOutput;

public final class TextOuptut
		implements FormOutput {

	private static final TextOuptut instance = new TextOuptut();

	private static final String NL = System.getProperty("line.separator");

	public static TextOuptut getInstance() {

		return instance;
	}
	private final TextOutputIdentification idTextOut = TextOutputIdentification.getInstance();
	private final TextOutputSkillSet skillTextOut = TextOutputSkillSet.getInstance();
	private final TextOutputCollectionEvaluationActivity activitiesTextOut = TextOutputCollectionEvaluationActivity
			.getInstance();

	private final TextOutputCollectionStudentEvaluation evalsTextOut = TextOutputCollectionStudentEvaluation
			.getInstance();

	private TextOuptut() {

		super();
	}

	private void buildFirstBlock(final StringBuilder builder, final Form input) {

		Identification id = null;

		id = input.getId();
		this.idTextOut.buildCourse(builder, id);
		builder.append(NL);
		this.idTextOut.buildUnit(builder, id);
		builder.append(NL);
		this.idTextOut.buildAcademic(builder, id);
		builder.append(NL);
		this.idTextOut.buildClass(builder, id);
		builder.append(NL);
		this.idTextOut.buildSemester(builder, id);
	}

	private void buildNotes(final StringBuilder builder, final Form input) {

		builder.append(input.getNotes());
	}

	protected StringBuilder buildOutput(final Form input) {

		StringBuilder result = null;

		result = new StringBuilder();
		this.buildFirstBlock(result, input);
		result.append(NL);
		result.append(NL);
		this.buildSecondBlock(result, input);
		result.append(NL);

		return result;
	}

	private void buildSecondBlock(final StringBuilder builder, final Form input) {

		SkillSet skillSet = null;
		Identification id = null;

		skillSet = input.getSkillSet();
		id = input.getId();
		this.skillTextOut.buildEssentialSkill(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildRelatedSkills(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildRequiredAttitudes(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildResultEvidences(builder, skillSet);
		builder.append(NL);
		this.activitiesTextOut.buildActivities(builder, input.getActivities());
		builder.append(NL);
		this.evalsTextOut.buildStudents(builder, input.getEvaluations());
		builder.append(NL);
		this.buildNotes(builder, input);
		builder.append(NL);
		this.idTextOut.buildLastDay(builder, id);
		builder.append(NL);
		this.idTextOut.buildAcademic(builder, id);
	}

	@Override
	public void print(final Form input) {

		StringBuilder builder = null;
		String output = null;

		if (input == null) {
			throw new IllegalArgumentException();
		}
		builder = this.buildOutput(input);
		output = builder.toString();
		System.out.println(output);
	}
}
