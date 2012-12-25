package com.operativus.senacrs.audit.output;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.operativus.senacrs.audit.model.EvaluationActivity;
import com.operativus.senacrs.audit.model.EvaluationGrade;
import com.operativus.senacrs.audit.model.Form;
import com.operativus.senacrs.audit.model.RelatedSkill;
import com.operativus.senacrs.audit.model.StudentEvaluation;

public class TextOuptut
		implements FormOutput {

	private static final String NL = System.getProperty("line.separator");

	private static enum RelatedSkillField {
		DESCRIPTION,
		REQUIRED_ATTITUDE,
		RESULTS_EVIDENCE, ;
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

	private void buildFirstBlock(final StringBuilder builder, final Form input) {

		this.buildCourse(builder, input);
		builder.append(NL);
		this.buildUnit(builder, input);
		builder.append(NL);
		this.buildAcademic(builder, input);
		builder.append(NL);
		this.buildClass(builder, input);
		builder.append(NL);
		this.buildSemester(builder, input);
	}

	private void buildCourse(final StringBuilder builder, final Form input) {

		builder.append(input.getId().getCourse());
	}

	private void buildUnit(final StringBuilder builder, final Form input) {

		builder.append(input.getId().getUnit());
	}

	private void buildAcademic(final StringBuilder builder, final Form input) {

		builder.append(input.getId().getAcademic());
	}

	private void buildClass(final StringBuilder builder, final Form input) {

		builder.append(input.getId().getClassDesc());
	}

	private void buildSemester(final StringBuilder builder, final Form input) {

		builder.append(input.getId().getSemester());
	}

	private void buildSecondBlock(final StringBuilder builder, final Form input) {

		this.buildEssentialSkill(builder, input);
		builder.append(NL);
		this.buildRelatedSkills(builder, input);
		builder.append(NL);
		this.buildRequiredAttitudes(builder, input);
		builder.append(NL);
		this.buildResultEvidences(builder, input);
		builder.append(NL);
		this.buildActivities(builder, input);
		builder.append(NL);
		this.buildStudents(builder, input);
		builder.append(NL);
		this.buildNotes(builder, input);
		builder.append(NL);
		this.buildLastDay(builder, input);
		builder.append(NL);
		this.buildAcademic(builder, input);
	}

	private void buildEssentialSkill(final StringBuilder builder, final Form input) {

		builder.append(input.getSkillSet().getEssential().getDescription());
	}

	private void buildRelatedSkills(final StringBuilder builder, final Form input) {

		this.buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.DESCRIPTION);
	}

	private void buildRelatedSkills(final StringBuilder builder, final List<RelatedSkill> skills,
			final RelatedSkillField field) {

		Iterator<RelatedSkill> iter = null;

		iter = skills.iterator();
		if (iter.hasNext()) {
			this.buildRelatedSkill(builder, iter, field);
			while (iter.hasNext()) {
				builder.append(", ");
				this.buildRelatedSkill(builder, iter, field);
			}
		}
	}

	private void buildRelatedSkill(final StringBuilder builder, final Iterator<RelatedSkill> iter,
			final RelatedSkillField field) {

		String value = null;
		RelatedSkill skill = null;

		skill = iter.next();
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

	private void buildRequiredAttitudes(final StringBuilder builder, final Form input) {

		this.buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.REQUIRED_ATTITUDE);
	}

	private void buildResultEvidences(final StringBuilder builder, final Form input) {

		this.buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.RESULTS_EVIDENCE);
	}

	private void buildActivities(final StringBuilder builder, final Form input) {

		this.buildActivities(builder, input.getActivities());
	}

	private void buildActivities(final StringBuilder builder, final Collection<EvaluationActivity> activities) {

		Iterator<EvaluationActivity> iter = null;

		iter = activities.iterator();
		if (iter.hasNext()) {
			this.buildActivity(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(", ");
				this.buildActivity(builder, iter.next());
			}
		}
	}

	private void buildActivity(final StringBuilder builder, final EvaluationActivity activity) {

		builder.append(activity.getName());
		builder.append("(");
		builder.append(activity.getDescription());
		builder.append(")");
	}

	private void buildStudents(final StringBuilder builder, final Form input) {

		this.buildStudents(builder, input.getEvaluations());
	}

	private void buildStudents(final StringBuilder builder, final Collection<StudentEvaluation> evaluations) {

		Iterator<StudentEvaluation> iter = null;

		iter = evaluations.iterator();
		if (iter.hasNext()) {
			this.buidEvaluation(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(", ");
				this.buidEvaluation(builder, iter.next());
			}
		}
	}

	private void buidEvaluation(final StringBuilder builder, final StudentEvaluation eval) {

		builder.append(eval.getName());
		builder.append("(");
		this.buildGrades(builder, eval.createAscendingGradesList());
		builder.append(")=");
		builder.append(eval.getFinalGrade().toString());
	}

	private void buildGrades(final StringBuilder builder, final List<EvaluationGrade> grades) {

		Iterator<EvaluationGrade> iter = null;

		iter = grades.iterator();
		if (iter.hasNext()) {
			this.buildGrade(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(",");
				this.buildGrade(builder, iter.next());
			}
		}
	}

	private void buildGrade(final StringBuilder builder, final EvaluationGrade grade) {

		builder.append(grade.toString());
	}

	private void buildNotes(final StringBuilder builder, final Form input) {

		builder.append(input.getNotes());
	}

	private void buildLastDay(final StringBuilder builder, final Form input) {

		builder.append(input.getId().toStringLastDay());
	}
}
