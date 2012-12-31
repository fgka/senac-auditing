package com.operativus.senacrs.audit.model.config;

public class Configuration {

	private static final String SEP_PIPE = "|";
	private String baseUrl = null;
	private String version = null;
	private String username = null;
	private String password = null;
	private String logFile = null;

	public Configuration() {

		super();
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Configuration other = (Configuration) obj;
		if (this.baseUrl == null) {
			if (other.baseUrl != null) {
				return false;
			}
		} else if (!this.baseUrl.equals(other.baseUrl)) {
			return false;
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		if (this.username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!this.username.equals(other.username)) {
			return false;
		}
		if (this.version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!this.version.equals(other.version)) {
			return false;
		}
		return true;
	}

	public String getBaseUrl() {

		return this.baseUrl;
	}

	public String getLogFile() {
	
		return logFile;
	}

	public String getPassword() {

		return this.password;
	}

	public String getUsername() {

		return this.username;
	}

	public String getVersion() {

		return this.version;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.baseUrl == null) ? 0 : this.baseUrl.hashCode());
		result = (prime * result) + ((this.password == null) ? 0 : this.password.hashCode());
		result = (prime * result) + ((this.username == null) ? 0 : this.username.hashCode());
		result = (prime * result) + ((this.version == null) ? 0 : this.version.hashCode());
		return result;
	}

	public void setBaseUrl(final String baseUrl) {

		this.baseUrl = baseUrl;
	}
	
	
	public void setLogFile(String logFile) {
	
		this.logFile = logFile;
	}

	
	public void setPassword(final String password) {

		this.password = password;
	}

	public void setUsername(final String username) {

		this.username = username;
	}

	public void setVersion(final String version) {

		this.version = version;
	}

	@Override
	public String toString() {

		StringBuilder result = null;

		result = new StringBuilder();
		result.append(this.getClass().getSimpleName());
		result.append(SEP_PIPE);
		result.append(this.baseUrl);
		result.append(SEP_PIPE);
		result.append(this.version);
		result.append(SEP_PIPE);
		result.append(this.username);
		result.append(SEP_PIPE);
		result.append(this.password);
		result.append(SEP_PIPE);
		result.append(this.logFile);

		return result.toString();
	}
}
