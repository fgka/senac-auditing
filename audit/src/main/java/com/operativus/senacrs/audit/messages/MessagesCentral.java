package com.operativus.senacrs.audit.messages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MessagesCentral {

	private static final String FAILED_TO_READ_PROPERTIES_FILE = "Failed to read properties file ";
	private static final PropertiesCentral central = new PropertiesCentral();
	private static final String[] LIST_FILES = new String[] {
			"messages_ui.properties",
			"messages.properties",
	};
	private static final Logger logger = LogManager.getLogger(MessagesCentral.class.getClass());

	static {
		
		for (String filename : LIST_FILES) {
			try {
				central.addPropertiesFile(MessagesCentral.class.getResourceAsStream("/" + filename));
			} catch (IOException e) {
				logger.error(FAILED_TO_READ_PROPERTIES_FILE + filename, e);
			}
		}
	}

	private MessagesCentral() {

		super();
	}

	public static String getMessage(final PropertyKey key, final Object... arguments) {

		return central.getMessage(key, arguments);
	}

	public static void addMessagesFile(final String filename) throws IOException {

		central.addPropertiesFile(filename);
	}

	public static boolean hasKey(final PropertyKey key) {

		return central.hasKey(key);
	}
}
