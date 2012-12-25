package com.operativus.senacrs.audit.model;

import org.junit.Assert;
import org.junit.Test;


public class EvaluationActivityTest {
	@Test
	public void testCompareToNull() {
		
		EvaluationActivity o1 = null;
		EvaluationActivity o2 = null;
		int result = 0;
		boolean expected = false;
		String msg = null;
		
		o1 = getBaselineObject(0);
		result = o1.compareTo(o2);
		expected = result > 0;
		msg = errorMsg(result, expected);
		Assert.assertTrue(msg, expected);
	}

	private EvaluationActivity getBaselineObject(int sequence) {

		return new EvaluationActivity(sequence, EvaluationType.SENAC_LEVEL, null, null);
	}

	private String errorMsg(int result, boolean expected) {

		return String.format("Returned: %s and expected %s", String.valueOf(result), String.valueOf(expected));
	}
	@Test
	public void testCompareToSelf() {
		
		EvaluationActivity o1 = null;
		int result = 0;
		boolean expected = false;
		String msg = null;
		
		o1 = getBaselineObject(0);
		result = o1.compareTo(o1);
		expected = result == 0;
		msg = errorMsg(result, expected);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToHigherSeq() {
		
		EvaluationActivity o1 = null;
		EvaluationActivity o2 = null;
		int result = 0;
		boolean expected = false;
		String msg = null;
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(1);
		result = o1.compareTo(o2);
		expected = result < 0;
		msg = errorMsg(result, expected);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToLowerSeq() {
		
		EvaluationActivity o1 = null;
		EvaluationActivity o2 = null;
		int result = 0;
		boolean expected = false;
		String msg = null;
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(-1);
		result = o1.compareTo(o2);
		expected = result > 0;
		msg = errorMsg(result, expected);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToSameSeqDiffNames() {
		
		EvaluationActivity o1 = null;
		EvaluationActivity o2 = null;
		int result = 0;
		int expected = 0;		
		
		o1 = getBaselineObject(0);
		o2 = getBaselineObject(0);
		o1.setName(TestBoilerplateUtils.randomString());
		o2.setName(TestBoilerplateUtils.randomString());
		result = o1.compareTo(o2);
		expected = o1.getName().compareTo(o2.getName());
		Assert.assertEquals(expected, result);
	}
	
}

