package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.Node;

public interface WebDriverNode
		extends Node {

	boolean verifyState(WebDriver driver);

	WebDriverNodeType getType();
}
