package com.operativus.senacrs.audit.model.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.config.ConfigurationFactory.ConfigKey;
import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class ConfigurationFactoryTest {

	private File tempFile = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {

		this.tempFile = File.createTempFile("config", null);
	}

	@After
	public void tearDown() throws Exception {

		this.tempFile = null;
	}

	@Test
	public void testCreateConfigurationNoBaseUrl() throws IOException {

		Configuration template = null;

		template = this.createRandomConfiguration();
		template.setBaseUrl(null);
		this.putToFile(template);
		this.thrown.expect(MissingMinimalConfigurationEntryException.class);
		this.thrown.expectMessage(this.tempFile.getName());
		this.thrown.expectMessage(ConfigKey.BASE_URL.getKey());
		ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
	}

	private Configuration createRandomConfiguration() {

		Configuration result = null;

		result = new Configuration();
		result.setBaseUrl(TestBoilerplateUtils.randomAlphanumericString());
		result.setVersion(TestBoilerplateUtils.randomAlphanumericString());
		result.setUsername(TestBoilerplateUtils.randomAlphanumericString());
		result.setPassword(TestBoilerplateUtils.randomAlphanumericString());
		result.setLogFile(TestBoilerplateUtils.randomAlphanumericString());

		return result;
	}

	private void putToFile(final Configuration obj) throws IOException {

		BufferedWriter writer = null;

		writer = new BufferedWriter(new FileWriter(this.tempFile));
		for (ConfigurationFactory.ConfigKey k : ConfigurationFactory.ConfigKey.values()) {
			this.putLine(writer, k, obj);
		}
		writer.flush();
		writer.close();
	}

	private void putLine(final BufferedWriter writer, final ConfigurationFactory.ConfigKey key, final Configuration obj)
			throws IOException {

		switch (key) {
		case BASE_URL:
			this.putNonNullValueLine(writer, key, obj.getBaseUrl());
			break;
		case PASSWORD:
			this.putNonNullValueLine(writer, key, obj.getPassword());
			break;
		case LOG_FILE:
			this.putNonNullValueLine(writer, key, obj.getLogFile());
			break;
		case USERNAME:
			this.putNonNullValueLine(writer, key, obj.getUsername());
			break;
		case VERSION:
			this.putNonNullValueLine(writer, key, obj.getVersion());
			break;
		default:
			throw new IllegalArgumentException(String.valueOf(key));
		}
	}

	private void putNonNullValueLine(final BufferedWriter writer, final ConfigurationFactory.ConfigKey key,
			final Object value) throws IOException {

		String line = null;

		if (value != null) {
			line = key.getKey() + " = " + String.valueOf(value);
			writer.write(line);
			writer.newLine();
		}
	}

	@Test
	public void testCreateConfigurationNoLogFile() throws IOException {

		Configuration template = null;
		Configuration result = null;

		template = this.createRandomConfiguration();
		template.setLogFile(null);
		this.putToFile(template);
		result = ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
		Assert.assertEquals(template, result);
		Assert.assertNull(result.getLogFile());
	}

	@Test
	public void testCreateConfigurationNoPassword() throws IOException {

		Configuration template = null;
		Configuration result = null;

		template = this.createRandomConfiguration();
		template.setPassword(null);
		this.putToFile(template);
		result = ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
		Assert.assertEquals(template, result);
		Assert.assertNull(result.getPassword());
	}

	@Test
	public void testCreateConfigurationNoUsername() throws IOException {

		Configuration template = null;

		template = this.createRandomConfiguration();
		template.setUsername(null);
		this.putToFile(template);
		this.thrown.expect(MissingMinimalConfigurationEntryException.class);
		this.thrown.expectMessage(this.tempFile.getName());
		this.thrown.expectMessage(ConfigKey.USERNAME.getKey());
		ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
	}

	@Test
	public void testCreateConfigurationNoVersion() throws IOException {

		Configuration template = null;

		template = this.createRandomConfiguration();
		template.setVersion(null);
		this.putToFile(template);
		this.thrown.expect(MissingMinimalConfigurationEntryException.class);
		this.thrown.expectMessage(this.tempFile.getName());
		this.thrown.expectMessage(ConfigKey.VERSION.getKey());
		ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
	}

	@Test
	public void testCreateConfigurationString() throws IOException {

		Configuration result = null;
		Configuration expected = null;

		expected = this.createRandomConfiguration();
		this.putToFile(expected);
		result = ConfigurationFactory.createConfiguration(this.tempFile.getAbsolutePath());
		Assert.assertEquals(expected, result);
	}
}
