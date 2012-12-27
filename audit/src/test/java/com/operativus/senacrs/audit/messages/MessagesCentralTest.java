package com.operativus.senacrs.audit.messages;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;


public class MessagesCentralTest {
	
	private static enum TestMessagesEnum implements Messages {
		
		TEST_MESSAGE("test.message");
		
		private final String key;
		
		private TestMessagesEnum(String key) {
			
			this.key = key;
		}

		@Override
		public String getKey() {

			return this.key;
		}
	
	}

	private static final String INPUT_FILE = TestBoilerplateUtils.TST_RESOURCES
			+ "test_messages.properties";

	@Test
	public void testGetMessageNonExistent() {
		
		Messages key = null;
		
		try {
			key = new Messages() {
				
				@Override
				public String getKey() {
				
					return TestBoilerplateUtils.randomString();
				}
			};
			MessagesCentral.getMessage(key);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testGetMessage() {
		
		String result = null;
		String arg = null;
		boolean check = false;

		try {
			arg = TestBoilerplateUtils.randomString();
			MessagesCentral.addMessagesFile(INPUT_FILE);
			result = MessagesCentral.getMessage(TestMessagesEnum.TEST_MESSAGE, arg);
			Assert.assertNotNull(result);
			check = result.contains(arg);
			Assert.assertTrue(check);
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testAddMessagesFile() {
		
		boolean result = false;

		try {
			MessagesCentral.addMessagesFile(INPUT_FILE);
			result = MessagesCentral.hasKey(TestMessagesEnum.TEST_MESSAGE);
			Assert.assertTrue(result);
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testHasKeyNull() {
		
		try {
			MessagesCentral.hasKey(null);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testHasKeyNullValue() {
		
		Messages key = null;
		
		try {
			key = new Messages() {
				
				@Override
				public String getKey() {
				
					return null;
				}
			};
			MessagesCentral.hasKey(key);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
}
