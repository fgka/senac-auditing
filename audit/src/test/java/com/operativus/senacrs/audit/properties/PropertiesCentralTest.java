package com.operativus.senacrs.audit.properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.operativus.senacrs.audit.properties.PropertiesCentral;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class PropertiesCentralTest {

	private static enum TestMessagesEnum implements PropertyKey {

		TEST_MESSAGE("test.message"), ;

		private final String key;

		private TestMessagesEnum(final String key) {

			this.key = key;
		}

		@Override
		public String getKey() {

			return this.key;
		}

	}

	private static final String TEST_MESSAGE = "test message with one argument: {0}";
	private static final String[] CONTENT = new String[] {
			TestMessagesEnum.TEST_MESSAGE.getKey() + " = " + TEST_MESSAGE,
	};

	private PropertiesCentral central = null;

	@Before
	public void setUp() throws Exception {

		this.central = new PropertiesCentral();
	}

	@After
	public void tearDown() throws Exception {

		this.central = null;
	}

	@Test
	public void testAddPropertiesFileNullString() {

		try {
			central.addPropertiesFile((String) null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void testAddPropertiesFileNullIn() {

		try {
			central.addPropertiesFile((InputStream) null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void testAddPropertiesFileInvalid() {

		String filename = null;

		filename = TestBoilerplateUtils.randomAlphanumericString();
		try {
			central.addPropertiesFile(filename);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void testAddPropertiesFile() {

		boolean result = false;

		try {
			central.addPropertiesFile(createPropFile());
			result = central.hasKey(TestMessagesEnum.TEST_MESSAGE);
			Assert.assertTrue(result);
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}

	private String createPropFile() throws IOException {

		File result = null;

		result = File.createTempFile("properties", null);
		writeContentToFile(result);

		return result.getAbsolutePath();
	}

	@Test
	public void testGetMessage() {

		String result = null;
		String arg = null;
		boolean check = false;

		try {
			arg = TestBoilerplateUtils.randomString();
			central.addPropertiesFile(createPropFile());
			result = central.getMessage(TestMessagesEnum.TEST_MESSAGE, arg);
			Assert.assertNotNull(result);
			check = result.contains(arg);
			Assert.assertTrue(check);
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}

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
			central.getMessage(key);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testHasKeyNull() {

		try {
			central.hasKey(null);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testHasKeyNullValue() {

		PropertyKey key = null;

		try {
			key = new PropertyKey() {

				@Override
				public String getKey() {

					return null;
				}
			};
			central.hasKey(key);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private void writeContentToFile(File result) throws IOException {

		BufferedWriter writer = null;

		writer = new BufferedWriter(new FileWriter(result));
		for (String l : CONTENT) {
			writer.write(l);
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

	@Test
	public void testGetAvailableKeysEmpty() {

		List<String> result = null;

		result = central.getAvailableKeys();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}

	@Test
	public void testGetAvailableKeys() {

		List<String> result = null;

		try {
			central.addPropertiesFile(createPropFile());
			result = central.getAvailableKeys();
			Assert.assertNotNull(result);
			for (TestMessagesEnum k : TestMessagesEnum.values()) {
				Assert.assertTrue(result.contains(k.getKey()));
			}
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}
}
