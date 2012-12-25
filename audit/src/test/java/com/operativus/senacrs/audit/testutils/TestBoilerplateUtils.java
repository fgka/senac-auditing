package com.operativus.senacrs.audit.testutils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class TestBoilerplateUtils {

	private static final Random RAND = new Random(System.currentTimeMillis());
	private static int MIN_RAND = 10;
	private static int MAX_RAND = 100;

	public static enum NumericComparisonToZero {
		EQUAL("equal to"),
		HIGHER("higher than"),
		LOWER("lower than"), ;

		private final String msg;

		private NumericComparisonToZero(final String msg) {

			this.msg = msg;
		}

		@Override
		public String toString() {

			return this.msg;
		}
	}

	public static boolean compare(final int value, final NumericComparisonToZero what) {

		boolean result = false;

		switch (what) {
		case EQUAL:
			result = value == 0;
			break;
		case HIGHER:
			result = value > 0;
			break;
		case LOWER:
			result = value < 0;
			break;
		default:
			throw new IllegalArgumentException();
		}

		return result;
	}

	public static String errorNumericComparisonToZeroMsg(final int value, final NumericComparisonToZero what) {

		return String.format("Returned: %s and expected %s 0", String.valueOf(value), String.valueOf(what));
	}

	public static String randomString() {

		String result = null;
		int amount = 0;

		amount = MIN_RAND + RAND.nextInt(MAX_RAND - MIN_RAND);
		result = RandomStringUtils.random(amount);

		return result;
	}

	public static int randomInt(final int max) {

		return RAND.nextInt(max);
	}
}
