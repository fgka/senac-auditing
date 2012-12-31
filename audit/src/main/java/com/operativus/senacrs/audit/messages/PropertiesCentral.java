package com.operativus.senacrs.audit.messages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PropertiesCentral {

	private static final String READ_PROPERTIES_FILE = "Start reading properties file ";
	private static final String NULL_ARGUMENT_KEY = "Null argument [key]";
	private static final String NULL_KEY_VALUE = "Key is valid, but its value is null";
	private static final Properties properties = new Properties();

	private static final Logger logger = LogManager.getLogger(PropertiesCentral.class.getClass());

	private PropertiesCentral() {

		super();
	}

	public static String getMessage(final PropertyKey key, final Object... arguments) {

		String result = null;
		String keyValue = null;
		String tmpl = null;

		keyValue = getKeyValue(key);
		if (!hasKey(key)) {
			throw new IllegalArgumentException("Informed key [" + keyValue + "] does not exists");
		}
		tmpl = properties.getProperty(keyValue);
		result = MessageFormat.format(tmpl, arguments);

		return result;
	}

	private static String getKeyValue(final PropertyKey key) {

		String result;

		if (key == null) {
			throw new IllegalArgumentException(NULL_ARGUMENT_KEY);
		}
		result = key.getKey();
		if (result == null) {
			throw new IllegalArgumentException(NULL_KEY_VALUE);
		}

		return result;
	}

	public static void addPropertiesFile(final String filename) throws IOException {

		InputStream in = null;

		in = new FileInputStream(new File(filename));
		logger.info(READ_PROPERTIES_FILE + filename);
		addPropertiesFile(in);
	}

	protected static void addPropertiesFile(InputStream in) throws IOException {

		properties.load(in);
	}

	public static boolean hasKey(final PropertyKey key) {

		boolean result = false;
		String keyStr = null;

		keyStr = getKeyValue(key);
		result = properties.containsKey(keyStr);

		return result;
	}
}
