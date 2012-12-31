package com.operativus.senacrs.audit.model.config;

import com.operativus.senacrs.audit.messages.Messages;

public enum ConfigMessagesEnum implements Messages {

	LOG_CONFIG_BEGIN("log.config.begin"),
	LOG_CONFIG_END("log.config.end"),
	;

	private final String key;

	private ConfigMessagesEnum(final String key) {

		this.key = key;
	}

	@Override
	public String getKey() {

		return this.key;
	}
}
