package com.operativus.senacrs.audit.messages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MessagesCentral {

	private static final String FAILED_TO_READ_PROPERTIES_FILE = "Failed to read properties file ";
	private static final String NULL_ARGUMENT_KEY = "Null argument [key]";
	private static final String NULL_KEY_VALUE = "Key is valid, but its value is null";
	private static final Properties properties = new Properties();
	private static final String[] LIST_FILES = new String[] {
			"messages_ui.properties",
			"messages.properties",
	};
	private static final Logger logger = LogManager.getLogger(MessagesCentral.class.getClass());

	static {
		
		for (String filename : LIST_FILES) {
			try {
				properties.load(MessagesCentral.class.getResourceAsStream("/" + filename));
			} catch (IOException e) {
				logger.error(FAILED_TO_READ_PROPERTIES_FILE + filename, e);
			}
		}
	}

	private MessagesCentral() {

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

	public static void addMessagesFile(final String filename) throws IOException {

		InputStream in = null;

		in = new FileInputStream(new File(filename));
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
