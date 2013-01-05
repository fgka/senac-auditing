package com.operativus.senacrs.audit.graph.edges.webdriver;

public interface WebDriverAction {

	WebDriverActionTypeEnum getType();

	String getArgument();
}
