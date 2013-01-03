package com.operativus.senacrs.audit.output.text;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.model.form.EssentialSkill;
import com.operativus.senacrs.audit.model.form.EvaluationActivity;
import com.operativus.senacrs.audit.model.form.EvaluationGrade;
import com.operativus.senacrs.audit.model.form.EvaluationType;
import com.operativus.senacrs.audit.model.form.Form;
import com.operativus.senacrs.audit.model.form.Identification;
import com.operativus.senacrs.audit.model.form.RelatedSkill;
import com.operativus.senacrs.audit.model.form.SkillSet;
import com.operativus.senacrs.audit.model.form.StudentEvaluation;
import com.operativus.senacrs.audit.testutils.CompareTextUtils;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class TextOuptutTest {

	private enum PropertyKey {
		COURSE("course"),
		UNIT("unit"),
		ACADEMIC("academic"),
		CLASS("class"),
		SEMESTER("semester"),
		LAST_DAY("last_day"),
		ESSENTIAL_SKILL("essential_skill"),
		RELATED_SKILLS("related_skills"),
		REQUIRED_ATTITUDES("required_attitudes"),
		RESULTS_EVIDENCES("results_evidences"),
		ACTIVITY_NAMES("activity_names"),
		ACTIVITY_DESCS("activity_descs"),
		STUDENT_NAMES("student_names"),
		STUDENT_GRADES("student_grades"),
		STUDENT_FINAL_GRADES("student_final_grades"),
		NOTES("notes"), ;

		private final String key;

		private PropertyKey(final String key) {

			this.key = key;
		}

		@Override
		public String toString() {

			return this.key;
		}
	}

	private static final String PROPERTIES_DATE_FORMAT_STR_DD_MM_YYYY = "dd/MM/yyyy";

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(PROPERTIES_DATE_FORMAT_STR_DD_MM_YYYY);

	private static final EvaluationType DEFAULT_TYPE = EvaluationType.SENAC_LEVEL;
	private static final String INPUT_FILE = TestBoilerplateUtils.TST_RESOURCES
			+ "test_text_input.properties";
	private static final String OUTPUT_FILE = TestBoilerplateUtils.TST_RESOURCES
			+ "test_text_output.txt";

	@Test
	public void testBuildOutput() throws IOException, ParseException {

		TextOuptut obj = null;
		Form form = null;
		StringBuilder result = null;

		obj = TextOuptut.getInstance();
		form = this.readForm(INPUT_FILE);
		result = obj.buildOutput(form);
		Assert.assertNotNull(result);
		this.compare(result, OUTPUT_FILE);
	}

	private Form readForm(final String inputFile) throws IOException, ParseException {

		Form result = null;
		Properties prop = null;
		InputStream input = null;

		prop = new Properties();
		input = new FileInputStream(INPUT_FILE);
		prop.load(input);
		result = this.createFormFromProp(prop);

		return result;
	}

	private Form createFormFromProp(final Properties prop) throws ParseException {

		Form result = null;
		Identification id = null;
		SkillSet skillSet = null;
		List<EvaluationActivity> activities = null;
		List<StudentEvaluation> evaluations = null;
		String notes = null;

		result = new Form();
		id = this.createIdFromProp(prop);
		skillSet = this.createSkillSetFromProp(prop);
		activities = this.createActivituesFromProp(prop);
		evaluations = this.createEvaluationsFromProp(prop, activities);
		notes = this.getProperty(prop, PropertyKey.NOTES);
		result.setId(id);
		result.setSkillSet(skillSet);
		result.setActivities(activities);
		result.setEvaluations(evaluations);
		result.setNotes(notes);

		return result;
	}

	private Identification createIdFromProp(final Properties prop) throws ParseException {

		Identification result = null;
		String course = null;
		String unit = null;
		String academic = null;
		String classDesc = null;
		String semester = null;
		String lastDayStr = null;

		course = this.getProperty(prop, PropertyKey.COURSE);
		unit = this.getProperty(prop, PropertyKey.UNIT);
		academic = this.getProperty(prop, PropertyKey.ACADEMIC);
		classDesc = this.getProperty(prop, PropertyKey.CLASS);
		semester = this.getProperty(prop, PropertyKey.SEMESTER);
		lastDayStr = this.getProperty(prop, PropertyKey.LAST_DAY);
		result = new Identification(course, unit, academic, classDesc, semester);
		result.setLastDay(this.getDateFromString(lastDayStr));

		return result;
	}

	private String getProperty(final Properties prop, final PropertyKey key) {

		return prop.getProperty(key.toString());
	}

	private Date getDateFromString(final String lastDayStr) throws ParseException {

		Date result = null;

		result = DATE_FORMATTER.parse(lastDayStr);

		return result;
	}

	private SkillSet createSkillSetFromProp(final Properties prop) {

		SkillSet result = null;
		EssentialSkill essential = null;
		List<RelatedSkill> skills = null;

		essential = this.createEssentailFromProp(prop);
		skills = this.createRelatedFromProp(prop);
		result = new SkillSet(essential);
		for (RelatedSkill skill : skills) {
			result.addRelatedSkill(skill);
		}

		return result;
	}

	private EssentialSkill createEssentailFromProp(final Properties prop) {

		EssentialSkill result = null;
		String str = null;

		str = this.getProperty(prop, PropertyKey.ESSENTIAL_SKILL);
		result = new EssentialSkill(str.trim());

		return result;
	}

	private List<RelatedSkill> createRelatedFromProp(final Properties prop) {

		List<RelatedSkill> result = null;
		RelatedSkill skill = null;
		String relatedSkills = null;
		String requiredAttitudes = null;
		String resultsEvidences = null;
		String[] relSkill = null;
		String[] reqAtt = null;
		String[] resEvi = null;

		relatedSkills = this.getProperty(prop, PropertyKey.RELATED_SKILLS);
		requiredAttitudes = this.getProperty(prop, PropertyKey.REQUIRED_ATTITUDES);
		resultsEvidences = this.getProperty(prop, PropertyKey.RESULTS_EVIDENCES);
		relSkill = this.splitByPipe(relatedSkills);
		reqAtt = this.splitByPipe(requiredAttitudes);
		resEvi = this.splitByPipe(resultsEvidences);
		result = new LinkedList<RelatedSkill>();
		for (int i = 0; i < relSkill.length; i++) {
			skill = new RelatedSkill(relSkill[i], reqAtt[i], resEvi[i]);
			result.add(skill);
		}

		return result;
	}

	private String[] splitByPipe(final String str) {

		return this.splitByChar(str, "\\|");
	}

	private String[] splitByChar(final String str, final String splitStr) {

		String[] result = null;

		result = str.split(splitStr);
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i].trim();
		}

		return result;
	}

	private List<EvaluationActivity> createActivituesFromProp(final Properties prop) {

		List<EvaluationActivity> result = null;
		EvaluationActivity activity = null;
		String activityNames = null;
		String activityDescs = null;
		String[] actNames = null;
		String[] actDescs = null;

		activityNames = this.getProperty(prop, PropertyKey.ACTIVITY_NAMES);
		activityDescs = this.getProperty(prop, PropertyKey.ACTIVITY_DESCS);
		actNames = this.splitByPipe(activityNames);
		actDescs = this.splitByPipe(activityDescs);
		result = new LinkedList<EvaluationActivity>();
		for (int i = 0; i < actNames.length; i++) {
			activity = new EvaluationActivity(i, DEFAULT_TYPE, actNames[i], actDescs[i]);
			result.add(activity);
		}

		return result;
	}

	private List<StudentEvaluation> createEvaluationsFromProp(final Properties prop,
			final List<EvaluationActivity> activities) {

		List<StudentEvaluation> result = null;
		String namesProp = null;
		String gradesProp = null;
		String finalGradesProp = null;
		String[] names = null;
		String[][] grades = null;
		String[] finalGrades = null;
		StudentEvaluation entry = null;

		namesProp = this.getProperty(prop, PropertyKey.STUDENT_NAMES);
		names = this.parseNames(namesProp);
		gradesProp = this.getProperty(prop, PropertyKey.STUDENT_GRADES);
		grades = this.parseGrades(gradesProp);
		finalGradesProp = this.getProperty(prop, PropertyKey.STUDENT_FINAL_GRADES);
		finalGrades = this.parseFinalGrades(finalGradesProp);
		result = new LinkedList<StudentEvaluation>();
		for (int i = 0; i < names.length; i++) {
			entry = this.createStudentEntry(i, names[i], activities, grades[i], finalGrades[i]);
			result.add(entry);
		}

		return result;
	}

	private String[] parseNames(final String namesProp) {

		return this.splitByPipe(namesProp);
	}

	private String[][] parseGrades(final String gradesProp) {

		String[][] result = null;
		String[] partial = null;

		partial = this.splitByPipe(gradesProp);
		result = new String[partial.length][];
		for (int i = 0; i < partial.length; i++) {
			result[i] = this.splitByComma(partial[i]);
		}

		return result;
	}

	private String[] splitByComma(final String str) {

		return this.splitByChar(str, ",");
	}

	private String[] parseFinalGrades(final String finalGradesProp) {

		return this.splitByPipe(finalGradesProp);
	}

	private StudentEvaluation createStudentEntry(final int sequence, final String name,
			final List<EvaluationActivity> activities, final String[] gradesStr, final String finalGradeStr) {

		StudentEvaluation result = null;
		EvaluationGrade grade = null;
		EvaluationActivity activity = null;

		result = new StudentEvaluation(sequence, name);
		for (int i = 0; i < gradesStr.length; i++) {
			activity = activities.get(i);
			grade = this.createGrade(gradesStr[i]);
			result.putGrade(activity, grade);
		}
		grade = this.createGrade(finalGradeStr);
		result.setFinalGrade(grade);

		return result;
	}

	private EvaluationGrade createGrade(final String value) {

		EvaluationGrade result = null;

		result = new EvaluationGrade() {

			@Override
			public void fromString(final String str) {

				// nothing
			}

			@Override
			public EvaluationType getType() {

				return DEFAULT_TYPE;
			}

			@Override
			public String toString() {

				return value;
			}
		};

		return result;
	}

	private void compare(final StringBuilder builder, final String outputFile) throws IOException {

		BufferedReader actual = null;
		BufferedReader expected = null;

		actual = new BufferedReader(new StringReader(builder.toString()));
		expected = new BufferedReader(new FileReader(new File(outputFile)));
		CompareTextUtils.compareReaders(expected, actual);
	}

	@Test
	public void testPrintNull() {

		TextOuptut obj = null;

		obj = TextOuptut.getInstance();
		try {
			obj.print(null);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testPrint() throws IOException, ParseException {

		TextOuptut obj = null;
		Form form = null;

		obj = TextOuptut.getInstance();
		form = this.readForm(INPUT_FILE);
		obj.print(form);
		Assert.assertTrue(true);
	}
}
