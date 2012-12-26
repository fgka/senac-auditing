package com.operativus.senacrs.audit.output;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.operativus.senacrs.audit.model.EvaluationActivity;
import com.operativus.senacrs.audit.model.EvaluationGrade;
import com.operativus.senacrs.audit.model.Form;
import com.operativus.senacrs.audit.model.Identification;
import com.operativus.senacrs.audit.model.SkillSet;
import com.operativus.senacrs.audit.model.StudentEvaluation;

public class TextOuptut
		implements FormOutput {
	
	private static final TextOuptut instance = new TextOuptut();

	private static final String NL = System.getProperty("line.separator");

	private TextOutputIdentification idTextOut = TextOutputIdentification.getInstance();
	private TextOutputSkillSet skillTextOut = TextOutputSkillSet.getInstance();

	private TextOuptut() {
		
		super();
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

	private void buildSecondBlock(final StringBuilder builder, final Form input) {

		SkillSet skillSet = null;
		
		skillSet = input.getSkillSet();
		this.skillTextOut.buildEssentialSkill(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildRelatedSkills(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildRequiredAttitudes(builder, skillSet);
		builder.append(NL);
		this.skillTextOut.buildResultEvidences(builder, skillSet);
		builder.append(NL);
		this.buildActivities(builder, input);
		builder.append(NL);
		this.buildStudents(builder, input);
		builder.append(NL);
		this.buildNotes(builder, input);
		builder.append(NL);
		this.buildLastDay(builder, input);
		builder.append(NL);
		this.idTextOut.buildAcademic(builder, input.getId());
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
	
	
	public static TextOuptut getInstance() {

		return instance;
	}
}
