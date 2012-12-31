package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;


public interface WebDriverElementPresenceChecker {

	String[] getXPathToCheck();
	
	boolean hasAll(WebDriver driver);
}
