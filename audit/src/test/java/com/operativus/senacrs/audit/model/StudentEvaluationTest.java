package com.operativus.senacrs.audit.model;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;


public class StudentEvaluationTest {

	@Test
	public void testCompareToNull() {
		
		StudentEvaluation o1 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;
		
		o1 = getBaselineObject(0);
		result = o1.compareTo(null);
		what = TestBoilerplateUtils.NumericComparisonToZero.HIGHER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	private StudentEvaluation getBaselineObject(int sequence) {

		return new StudentEvaluation(sequence, TestBoilerplateUtils.randomString());
	}

	@Test
	public void testCompareToSelf() {
		
		StudentEvaluation o1 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;
		
		o1 = getBaselineObject(0);
		result = o1.compareTo(o1);
		what = TestBoilerplateUtils.NumericComparisonToZero.EQUAL;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToHigherSeq() {
		
		StudentEvaluation o1 = null;
		StudentEvaluation o2 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(1);
		result = o1.compareTo(o2);
		what = TestBoilerplateUtils.NumericComparisonToZero.LOWER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToLowerSeq() {
		
		StudentEvaluation o1 = null;
		StudentEvaluation o2 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(-1);
		result = o1.compareTo(o2);
		what = TestBoilerplateUtils.NumericComparisonToZero.HIGHER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToSameSeqDiffNames() {
		
		StudentEvaluation o1 = null;
		StudentEvaluation o2 = null;
		int result = 0;
		int expected = 0;		
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(0);
		result = o1.compareTo(o2);
		expected = o1.getName().compareTo(o2.getName());
		Assert.assertEquals(expected, result);
	}
}
