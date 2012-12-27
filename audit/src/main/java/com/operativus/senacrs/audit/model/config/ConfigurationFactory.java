package com.operativus.senacrs.audit.model.config;

import java.io.File;


public final class ConfigurationFactory {

	private static final String PWD = System.getProperty("user.dir");
	private static final String DEFAULT_CONFIGURATION_FILENAME = PWD
			+ File.separator + "configuration.properties";
	protected static enum ConfigKey {
		
		BASE_URL("base_url"),
		VERSION("version"),
		USERNAME("username"),
		PASSWORD("password"),
		;
		
		private String key;
		
		private ConfigKey(String key) {
			
			this.key = key;			
		}
				
		public String getKey() {

			return key;
		}
	}
		
	private ConfigurationFactory() {

		super();
	}

	public static Configuration createConfiguration() {
		
		return createConfiguration(DEFAULT_CONFIGURATION_FILENAME);
	}

	public static Configuration createConfiguration(String filename) {
		
		Configuration result = null;
		
		//TODO
		
		return result;
	}
}
