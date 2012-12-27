package com.operativus.senacrs.audit.messages;


public final class MessagesCentral {
	
	private static final MessagesCentral instance = new MessagesCentral();
	
	private MessagesCentral() {
		
		super();
	}
	
	public String getMessage(Messages key, Object... arguments) {
		
		String result = null;
		
		//TODO
		
		return result;
	}
	
	public void addMessagesFile(String filename) {
		
		//TODO
	}
	
	public static MessagesCentral getInstance() {

		return instance;
	}
}
