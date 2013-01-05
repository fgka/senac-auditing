package com.operativus.senacrs.audit.graph.edges.webdriver;

public enum WebDriverActionEnum implements WebDriverAction {

	OPEN_DASHBOARD(WebDriverActionTypeEnum.OPEN, null), ;

	private final WebDriverActionTypeEnum type;
	private final String argument;

	private WebDriverActionEnum(final WebDriverActionTypeEnum type, final String argument) {

		this.type = type;
		this.argument = argument;
	}

	@Override
	public WebDriverActionTypeEnum getType() {

		return this.type;
	}

	@Override
	public String getArgument() {

		return this.argument;
	}
}
