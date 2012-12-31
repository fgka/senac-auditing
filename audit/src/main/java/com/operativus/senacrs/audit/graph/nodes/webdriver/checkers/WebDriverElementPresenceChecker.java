package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;


public class WebDriverElementPresenceChecker {

	private final String[] xPathElementsToCheck;
	private By[] xPaths;
	
	public WebDriverElementPresenceChecker(String[] xPathElementsToCheck) {

		super();
		
		this.xPathElementsToCheck = checkAndCloneArgument(xPathElementsToCheck);
	}


	private String[] checkAndCloneArgument(String[] xPathElementsToCheck) {

		String[] result = null;
		String argName = null;
		String item = null;
		
		argName = "xPathElementsToCheck";
		if (xPathElementsToCheck == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException(argName);
		}
		result = new String[xPathElementsToCheck.length];
		for (int i = 0; i < xPathElementsToCheck.length; i++) {
			item = xPathElementsToCheck[i];
			if (item == null) {
				throw RuntimeExceptionFactory.getInstance().getNullArgumentException(argName + "[" + i + "]");
			}
			result[i] = item;
		}
		
		return result;
	}
	
	
	public String[] getxPathElementsToCheck() {

		return xPathElementsToCheck;
	}
	
	private By[] getXPaths() {

		if (xPaths == null) {
			xPaths = new By[this.xPathElementsToCheck.length];
			for (int i = 0; i < this.xPathElementsToCheck.length; i++) {
				xPaths[i] = By.xpath(this.xPathElementsToCheck[i]);
			}
		}
		
		return xPaths;
	}


	public boolean hasAll(WebDriver driver) {
		
		boolean result = false;
		
		if (driver == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("driver");
		}
		result = internHasAll(driver);
		
		return result;
	}

	private boolean internHasAll(WebDriver driver) {

		boolean result = false;
		By[] xpaths = null;
		By el = null;
		int ndx = 0; 

		xpaths = getXPaths();
		result = true;
		ndx = 0;
		while (result && (ndx < xpaths.length)) {
			el = xpaths[ndx++];
			result &= isElementPresent(driver, el);
		}
		
		return result;
	}

	private boolean isElementPresent(WebDriver driver, By element) {
		
		boolean result = false;

		try {
			driver.findElement(element);
			result = true;
		} catch (NoSuchElementException e) {
			result = false;
		}
		
		return result;
	}
}
