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
		RESULTS_EVIDENCE,
		;
	}

	@Override
	public void print(Form input) {
		
		StringBuilder builder = null;
		String output = null;

		if (input == null) {
			throw new IllegalArgumentException();
		}
		builder = this.buildOutput(input);
		output = builder.toString();
		System.out.println(output);
	}
	
	protected StringBuilder buildOutput(Form input) {
		
		StringBuilder result = null;
					
		result = new StringBuilder();
		buildFirstBlock(result, input);
		result.append(NL);
		result.append(NL);
		buildSecondBlock(result, input);
		result.append(NL);

		return result;
	}

	private void buildFirstBlock(StringBuilder builder, Form input) {

		buildCourse(builder, input);
		builder.append(NL);
		buildUnit(builder, input);		
		builder.append(NL);
		buildAcademic(builder, input);		
		builder.append(NL);
		buildClass(builder, input);		
		builder.append(NL);
		buildSemester(builder, input);		
	}

	private void buildCourse(StringBuilder builder, Form input) {
	
		builder.append(input.getId().getCourse());
	}

	private void buildUnit(StringBuilder builder, Form input) {

		builder.append(input.getId().getUnit());
	}

	private void buildAcademic(StringBuilder builder, Form input) {

		builder.append(input.getId().getAcademic());
	}

	private void buildClass(StringBuilder builder, Form input) {

		builder.append(input.getId().getClassDesc());
	}

	private void buildSemester(StringBuilder builder, Form input) {

		builder.append(input.getId().getSemester());
	}

	private void buildSecondBlock(StringBuilder builder, Form input) {
		
		buildEssentialSkill(builder, input);
		builder.append(NL);
		buildRelatedSkills(builder, input);
		builder.append(NL);
		buildRequiredAttitudes(builder, input);
		builder.append(NL);
		buildResultEvidences(builder, input);
		builder.append(NL);
		buildActivities(builder, input);
		builder.append(NL);
		buildStudents(builder, input);
		builder.append(NL);
		buildNotes(builder, input);
		builder.append(NL);
		buildLastDay(builder, input);
		builder.append(NL);
		buildAcademic(builder, input);
	}

	private void buildEssentialSkill(StringBuilder builder, Form input) {

		builder.append(input.getSkillSet().getEssential().getDescription());
	}

	private void buildRelatedSkills(StringBuilder builder, Form input) {
		
		buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.DESCRIPTION);
	}

	private void buildRelatedSkills(StringBuilder builder, List<RelatedSkill> skills, RelatedSkillField field) {
		
		Iterator<RelatedSkill> iter = null;

		iter = skills.iterator();
		if (iter.hasNext()) {
			buildRelatedSkill(builder, iter, field);
			while (iter.hasNext()) {
				builder.append(", ");
				buildRelatedSkill(builder, iter, field);
			}
		}
	}

	private void buildRelatedSkill(StringBuilder builder, Iterator<RelatedSkill> iter, RelatedSkillField field) {
		
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

	private void buildRequiredAttitudes(StringBuilder builder, Form input) {
		
		buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.REQUIRED_ATTITUDE);
	}

	private void buildResultEvidences(StringBuilder builder, Form input) {

		buildRelatedSkills(builder, input.getSkillSet().getSkills(), RelatedSkillField.RESULTS_EVIDENCE);
	}

	private void buildActivities(StringBuilder builder, Form input) {

		buildActivities(builder, input.getActivities());		
	}

	private void buildActivities(StringBuilder builder, Collection<EvaluationActivity> activities) {

		Iterator<EvaluationActivity> iter = null;
		
		iter = activities.iterator();
		if (iter.hasNext()) {
			buildActivity(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(", ");
				buildActivity(builder, iter.next());
			}
		}
	}

	private void buildActivity(StringBuilder builder, EvaluationActivity activity) {

		builder.append(activity.getName());
		builder.append("(");
		builder.append(activity.getDescription());
		builder.append(")");
	}

	private void buildStudents(StringBuilder builder, Form input) {

		buildStudents(builder, input.getEvaluations());		
	}

	private void buildStudents(StringBuilder builder, Collection<StudentEvaluation> evaluations) {

		Iterator<StudentEvaluation> iter = null;
		
		iter = evaluations.iterator();
		if (iter.hasNext()) {
			buidEvaluation(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(", ");
				buidEvaluation(builder, iter.next());
			}
		}
	}

	private void buidEvaluation(StringBuilder builder, StudentEvaluation eval) {
		
		builder.append(eval.getName());
		builder.append("(");
		buildGrades(builder, eval.createAscendingGradesList());
		builder.append(")=");
		builder.append(eval.getFinalGrade().toString());
	}

	private void buildGrades(StringBuilder builder, List<EvaluationGrade> grades) {

		Iterator<EvaluationGrade> iter = null;
		
		iter = grades.iterator();
		if (iter.hasNext()) {
			buildGrade(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(",");
				buildGrade(builder, iter.next());				
			}
		}
	}

	private void buildGrade(StringBuilder builder, EvaluationGrade grade) {

		builder.append(grade.toString());
	}

	private void buildNotes(StringBuilder builder, Form input) {

		builder.append(input.getNotes());		
	}

	private void buildLastDay(StringBuilder builder, Form input) {

		builder.append(input.getId().toStringLastDay());		
	}
}

