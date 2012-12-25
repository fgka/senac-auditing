package com.operativus.senacrs.audit.model;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.exceptions.InvalidEvaluationType;
import com.operativus.senacrs.audit.exceptions.MismatchingEvaluationType;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class StudentEvaluationTest {

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
		} catch (MismatchingEvaluationType e) {
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
			public EvaluationType getType() {

				return type;
			}

			@Override
			public void fromString(final String str) {

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
		} catch (InvalidEvaluationType e) {
			Assert.assertTrue(true);
		}

	}

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
		} catch (InvalidEvaluationType e) {
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
}
