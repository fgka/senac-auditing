package com.operativus.senacrs.audit.model.config;


public class Configuration {

	private String baseUrl = null;
	private String version = null;
	private String username = null;
	private String password = null;
	
	public Configuration() {

		super();
	}

	
	public String getBaseUrl() {
	
		return baseUrl;
	}

	
	public void setBaseUrl(String baseUrl) {
	
		this.baseUrl = baseUrl;
	}

	
	public String getVersion() {
	
		return version;
	}

	
	public void setVersion(String version) {
	
		this.version = version;
	}

	
	public String getUsername() {
	
		return username;
	}

	
	public void setUsername(String username) {
	
		this.username = username;
	}

	
	public String getPassword() {
	
		return password;
	}

	
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	
}
