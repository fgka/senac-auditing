package com.operativus.senacrs.audit.model;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class AbstractSequenceStringFieldComparableTest {

	@Test
	public void testCompareToNull() {

		AbstractSequenceStringFieldComparable o1 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;

		o1 = this.getBaselineObject();
		result = o1.compareTo(null);
		what = TestBoilerplateUtils.NumericComparisonToZero.HIGHER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	private AbstractSequenceStringFieldComparable getBaselineObject() {

		return this.getBaselineObject(TestBoilerplateUtils.randomInt(100), TestBoilerplateUtils.randomString());
	}

	private AbstractSequenceStringFieldComparable getBaselineObject(final int sequence) {

		return this.getBaselineObject(sequence, TestBoilerplateUtils.randomString());
	}

	private AbstractSequenceStringFieldComparable getBaselineObject(final int sequence, final String strValue) {

		return new AbstractSequenceStringFieldComparable(sequence) {

			@Override
			protected String getComparisonStringField() {

				return strValue;
			}
		};
	}

	@Test
	public void testCompareToSelf() {

		AbstractSequenceStringFieldComparable o1 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;

		o1 = this.getBaselineObject(0);
		result = o1.compareTo(o1);
		what = TestBoilerplateUtils.NumericComparisonToZero.EQUAL;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToHigherSeq() {

		AbstractSequenceStringFieldComparable o1 = null;
		AbstractSequenceStringFieldComparable o2 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;

		o1 = this.getBaselineObject(0);
		o2 = this.getBaselineObject(1);
		result = o1.compareTo(o2);
		what = TestBoilerplateUtils.NumericComparisonToZero.LOWER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToLowerSeq() {

		AbstractSequenceStringFieldComparable o1 = null;
		AbstractSequenceStringFieldComparable o2 = null;
		int result = 0;
		boolean expected = false;
		TestBoilerplateUtils.NumericComparisonToZero what = null;
		String msg = null;

		o1 = this.getBaselineObject(0);
		o2 = this.getBaselineObject(-1);
		result = o1.compareTo(o2);
		what = TestBoilerplateUtils.NumericComparisonToZero.HIGHER;
		expected = TestBoilerplateUtils.compare(result, what);
		msg = TestBoilerplateUtils.errorNumericComparisonToZeroMsg(result, what);
		Assert.assertTrue(msg, expected);
	}

	@Test
	public void testCompareToSameSeqDiffStrValues() {

		AbstractSequenceStringFieldComparable o1 = null;
		AbstractSequenceStringFieldComparable o2 = null;
		int result = 0;
		int expected = 0;

		o1 = this.getBaselineObject(0);
		o2 = this.getBaselineObject(0);
		result = o1.compareTo(o2);
		expected = o1.getComparisonStringField().compareTo(o2.getComparisonStringField());
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testCompareToSameSeqThisNullStrValue() {

		AbstractSequenceStringFieldComparable o1 = null;
		AbstractSequenceStringFieldComparable o2 = null;
		int result = 0;
		int expected = 0;

		o1 = this.getBaselineObject(0, null);
		o2 = this.getBaselineObject(0);
		result = o1.compareTo(o2);
		expected = -1;
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testCompareToSameSeqOtherNullStrValue() {

		AbstractSequenceStringFieldComparable o1 = null;
		AbstractSequenceStringFieldComparable o2 = null;
		int result = 0;
		int expected = 0;

		o1 = this.getBaselineObject(0);
		o2 = this.getBaselineObject(0, null);
		result = o1.compareTo(o2);
		expected = 1;
		Assert.assertEquals(expected, result);
	}

}
