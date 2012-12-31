package com.operativus.senacrs.audit.graph.nodes.webdriver;

import org.openqa.selenium.WebDriver;


public class WebDriverElementPresenceChecker {

	private final String[] xPathElementsToCheck;
	
	public WebDriverElementPresenceChecker(String[] xPathElementsToCheck) {

		super();
		
		this.xPathElementsToCheck = xPathElementsToCheck;
	}
	
	
	public String[] getxPathElementsToCheck() {

		return xPathElementsToCheck;
	}
	
	public boolean hasAll(WebDriver driver) {
		
		return false;
	}
}
