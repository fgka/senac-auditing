package com.operativus.senacrs.audit.properties.messages;

import java.io.IOException;

import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.ResourceCentral;

public final class MessagesCentral {

	private static final ResourceCentral central = new ResourceCentral();
	private static final String[] LIST_FILES = new String[] {
			"messages_ui.properties",
			"messages.properties",
	};

	static {

		central.populateCentral(LIST_FILES);
	}

	private MessagesCentral() {

		super();
	}

	public static void addMessagesFile(final String filename) throws IOException {

		central.populateCentral(filename);
	}

	public static String getMessage(final PropertyKey key, final Object... arguments) {

		return central.getMessage(key, arguments);
	}

	public static boolean hasKey(final PropertyKey key) {

		return central.hasKey(key);
	}
}
