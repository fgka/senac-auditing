package com.operativus.senacrs.audit.messages;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class MessagesCentralTest {

	private static enum TestMessagesEnum implements PropertyKey {

		TEST_MESSAGES_PROPERTIES("test.messages.properties"),
		TEST_MESSAGES_UI_PROPERTIES("test.messages_ui.properties"), ;

		private final String key;

		private TestMessagesEnum(final String key) {

			this.key = key;
		}

		@Override
		public String getKey() {

			return this.key;
		}

	}

	private static final String TEST_MESSAGE = "Just a test message not really used outside testing";
	private static final PropertyKey[] PRE_LOADED_KEYS = new PropertyKey[] {
			TestMessagesEnum.TEST_MESSAGES_PROPERTIES,
			TestMessagesEnum.TEST_MESSAGES_UI_PROPERTIES,
	};

	@Test
	public void testGetMessageNonExistent() {

		PropertyKey key = null;

		try {
			key = new PropertyKey() {

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
	public void testGetMessagePreLoaded() {

		String result = null;

		for (PropertyKey k : PRE_LOADED_KEYS) {
			result = MessagesCentral.getMessage(k);
			Assert.assertEquals(TEST_MESSAGE, result);
		}
	}
}
