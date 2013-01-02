package com.operativus.senacrs.audit.output.text;

import com.operativus.senacrs.audit.common.AbstractHasLogger;
import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.model.form.Form;
import com.operativus.senacrs.audit.model.form.Identification;
import com.operativus.senacrs.audit.model.form.SkillSet;
import com.operativus.senacrs.audit.output.FormOutput;

public final class TextOuptut
		extends AbstractHasLogger
		implements FormOutput {

	private static final TextOuptut instance = new TextOuptut();

	private static final String NL = System.getProperty("line.separator");

	public static TextOuptut getInstance() {

		return instance;
	}


	private TextOuptut() {

		super();
	}

	private void buildFirstBlock(final StringBuilder builder, final Form input) {

		Identification id = null;

		id = input.getId();
		TextOutputIdentification.buildCourse(builder, id);
		builder.append(NL);
		TextOutputIdentification.buildUnit(builder, id);
		builder.append(NL);
		TextOutputIdentification.buildAcademic(builder, id);
		builder.append(NL);
		TextOutputIdentification.buildClass(builder, id);
		builder.append(NL);
		TextOutputIdentification.buildSemester(builder, id);
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
		TextOutputSkillSet.buildEssentialSkill(builder, skillSet);
		builder.append(NL);
		TextOutputSkillSet.buildRelatedSkills(builder, skillSet);
		builder.append(NL);
		TextOutputSkillSet.buildRequiredAttitudes(builder, skillSet);
		builder.append(NL);
		TextOutputSkillSet.buildResultEvidences(builder, skillSet);
		builder.append(NL);
		TextOutputCollectionEvaluationActivity.buildActivities(builder, input.getActivities());
		builder.append(NL);
		TextOutputCollectionStudentEvaluation.buildStudents(builder, input.getEvaluations());
		builder.append(NL);
		this.buildNotes(builder, input);
		builder.append(NL);
		TextOutputIdentification.buildLastDay(builder, id);
		builder.append(NL);
		TextOutputIdentification.buildAcademic(builder, id);
	}

	@Override
	public void print(final Form input) {

		StringBuilder builder = null;
		String output = null;

		if (input == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("input");
		}
		builder = this.buildOutput(input);
		output = builder.toString();
		this.getLogger().debug(output);
	}
}
