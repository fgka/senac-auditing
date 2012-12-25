package com.operativus.senacrs.audit.model;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;


public class TestBoilerplateUtils {
	
	private static Random RAND = new Random(System.currentTimeMillis());
	private static int MIN_RAND = 10;
	private static int MAX_RAND = 100;
	
	
	public static String randomString() {
		
		String result = null;
		int amount = 0;
		
		amount = MIN_RAND + RAND.nextInt(MAX_RAND - MIN_RAND);
		result = RandomStringUtils.random(amount);
		
		return result;
	}

}
