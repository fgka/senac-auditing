package com.operativus.senacrs.audit.messages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;


public final class MessagesCentral {
	
	private static final String NULL_ARGUMENT_KEY = "Null argument [key]";
	private static final String NULL_KEY_VALUE = "Key is valid, but its value is null";
	private static final MessagesCentral instance = new MessagesCentral();
	private final Properties properties = new Properties();
	
	private MessagesCentral() {
		
		super();
	}
	
	public String getMessage(Messages key, Object... arguments) {
		
		String result = null;
		String keyValue = null;
		String tmpl = null;

		keyValue = getKeyValue(key);
		if (!hasKey(key)) {
			throw new IllegalArgumentException("Informed key [" + keyValue + "] does not exists");
		}
		tmpl = this.properties.getProperty(keyValue);
		result = MessageFormat.format(tmpl, arguments);
		
		return result;
	}
	
	private String getKeyValue(Messages key) {
	
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

	public void addMessagesFile(String filename) throws IOException {

		InputStream in = null;
		
		in = new FileInputStream(new File(filename));
		this.properties.load(in);
	}
	
	public boolean hasKey(Messages key) {
		
		boolean result = false;
		String keyStr = null;
		
		keyStr = getKeyValue(key);
		result = this.properties.containsKey(keyStr);
		
		return result;
	}

	public static MessagesCentral getInstance() {

		return instance;
	}
}
