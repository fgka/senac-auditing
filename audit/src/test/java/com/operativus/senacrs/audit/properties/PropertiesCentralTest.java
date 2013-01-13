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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {

		this.central = new PropertiesCentral();
	}

	@After
	public void tearDown() throws Exception {

		this.central = null;
	}

	@Test
	public void testAddPropertiesFileNullString() throws IOException {

		this.thrown.expect(IllegalArgumentException.class);
		this.central.addPropertiesFile((String) null);
	}

	@Test
	public void testAddPropertiesFileNullIn() throws IOException {

		this.thrown.expect(IllegalArgumentException.class);
		this.central.addPropertiesFile((InputStream) null);
	}

	@Test
	public void testAddPropertiesFileInvalid() throws IOException {

		String filename = null;

		filename = TestBoilerplateUtils.randomAlphanumericString();
		this.thrown.expect(IllegalArgumentException.class);
		this.central.addPropertiesFile(filename);
	}

	@Test
	public void testAddPropertiesFile() throws IOException {

		boolean result = false;

		this.central.addPropertiesFile(this.createPropFile());
		result = this.central.hasKey(TestMessagesEnum.TEST_MESSAGE);
		Assert.assertTrue(result);
	}

	private String createPropFile() throws IOException {

		File result = null;

		result = File.createTempFile("properties", null);
		this.writeContentToFile(result);

		return result.getAbsolutePath();
	}

	@Test
	public void testGetMessage() throws IOException {

		String result = null;
		String arg = null;
		boolean check = false;

		arg = TestBoilerplateUtils.randomString();
		this.central.addPropertiesFile(this.createPropFile());
		result = this.central.getMessage(TestMessagesEnum.TEST_MESSAGE, arg);
		Assert.assertNotNull(result);
		check = result.contains(arg);
		Assert.assertTrue(check);
	}

	@Test
	public void testGetMessageNonExistent() {

		PropertyKey key = null;

		key = new PropertyKey() {

			@Override
			public String getKey() {

				return TestBoilerplateUtils.randomString();
			}
		};
		this.thrown.expect(IllegalArgumentException.class);
		this.central.getMessage(key);
	}

	@Test
	public void testHasKeyNull() {

		this.thrown.expect(IllegalArgumentException.class);
		this.central.hasKey(null);
	}

	@Test
	public void testHasKeyNullValue() {

		PropertyKey key = null;

		key = new PropertyKey() {

			@Override
			public String getKey() {

				return null;
			}
		};
		this.thrown.expect(IllegalArgumentException.class);
		this.central.hasKey(key);
	}

	private void writeContentToFile(final File result) throws IOException {

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

		result = this.central.getAvailableKeys();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}

	@Test
	public void testGetAvailableKeys() throws IOException {

		List<String> result = null;

		this.central.addPropertiesFile(this.createPropFile());
		result = this.central.getAvailableKeys();
		Assert.assertNotNull(result);
		for (TestMessagesEnum k : TestMessagesEnum.values()) {
			Assert.assertTrue(result.contains(k.getKey()));
		}
	}
}
