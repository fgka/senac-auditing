package com.operativus.senacrs.audit.model.config;

import java.io.File;


public final class ConfigurationFactory {

	private static final ConfigurationFactory instance = new ConfigurationFactory();
	private static final String PWD = System.getProperty("user.dir");
	private static final String DEFAULT_CONFIGURATION_FILENAME = PWD
			+ File.separator + "configuration.properties";
		
	private ConfigurationFactory() {

		super();
	}

	public Configuration createConfiguration() {
		
		return createConfiguration(DEFAULT_CONFIGURATION_FILENAME);
	}

	public Configuration createConfiguration(String filename) {
		
		Configuration result = null;
		
		//TODO
		
		return result;
	}
		
	public static ConfigurationFactory getInstance() {

		return instance;
	}
}
