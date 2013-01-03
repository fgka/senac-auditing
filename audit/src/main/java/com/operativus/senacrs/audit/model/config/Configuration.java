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

	public String getBaseUrl() {

		return this.baseUrl;
	}

	public void setBaseUrl(final String baseUrl) {

		this.baseUrl = baseUrl;
	}

	public String getVersion() {

		return this.version;
	}

	public void setVersion(final String version) {

		this.version = version;
	}

	public String getUsername() {

		return this.username;
	}

	public void setUsername(final String username) {

		this.username = username;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}

	public String getLogFile() {

		return this.logFile;
	}

	public void setLogFile(final String logFile) {

		this.logFile = logFile;
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
