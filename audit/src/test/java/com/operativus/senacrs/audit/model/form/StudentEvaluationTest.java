package com.operativus.senacrs.audit.model.form;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class StudentEvaluationTest {

	@Test
	public void testPutGradeInvalidActivity() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade grade = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.INVALID);
		grade = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		try {
			obj.putGrade(activity, grade);
			Assert.fail();
		} catch (InvalidEvaluationTypeException e) {
			Assert.assertTrue(true);
		}

	}

	private StudentEvaluation getBaseline() {

		return new StudentEvaluation(TestBoilerplateUtils.randomInt(100), TestBoilerplateUtils.randomString());
	}

	private EvaluationActivity getEvalActivity(final EvaluationType type) {

		return new EvaluationActivity(0, type, null, null);
	}

	private EvaluationGrade getEvalGrade(final EvaluationType type) {

		return new EvaluationGrade() {

			@Override
			public void fromString(final String str) {

			}

			@Override
			public EvaluationType getType() {

				return type;
			}
		};
	}

	@Test
	public void testPutGradeInvalidGrade() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade grade = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		grade = this.getEvalGrade(EvaluationType.INVALID);
		try {
			obj.putGrade(activity, grade);
			Assert.fail();
		} catch (InvalidEvaluationTypeException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testPutGradeMismatch() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade grade = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		grade = this.getEvalGrade(EvaluationType.NUMERIC);
		try {
			obj.putGrade(activity, grade);
			Assert.fail();
		} catch (MismatchingEvaluationTypeException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testPutGradeMismatchNullActivity() {

		StudentEvaluation obj = null;
		EvaluationGrade grade = null;

		obj = this.getBaseline();
		grade = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		try {
			obj.putGrade(null, grade);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testPutGradeMismatchNullGrade() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		try {
			obj.putGrade(activity, null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testPutGrade() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade grade = null;
		EvaluationGrade result = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		grade = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		result = obj.putGrade(activity, grade);
		Assert.assertNull(result);
	}

	@Test
	public void testPutGradeSameActivity() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade expected = null;
		EvaluationGrade grade = null;
		EvaluationGrade result = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		expected = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		result = obj.putGrade(activity, expected);
		grade = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		result = obj.putGrade(activity, grade);
		Assert.assertEquals(expected, result);
		Assert.assertNotEquals(grade, result);
	}

	@Test
	public void testCreateAscendingGradesList() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade expected = null;
		List<EvaluationGrade> result = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		expected = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		obj.putGrade(activity, expected);
		result = obj.createAscendingGradesList();
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains(expected));
	}

	@Test
	public void testToString() {

		StudentEvaluation obj = null;
		EvaluationActivity activity = null;
		EvaluationGrade grade = null;
		String result = null;

		obj = this.getBaseline();
		activity = this.getEvalActivity(EvaluationType.SENAC_LEVEL);
		activity.setName(TestBoilerplateUtils.randomString());
		grade = this.getEvalGrade(EvaluationType.SENAC_LEVEL);
		obj.putGrade(activity, grade);
		result = obj.toString();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains(activity.getName()));
		Assert.assertTrue(result.contains(grade.toString()));
	}
}
