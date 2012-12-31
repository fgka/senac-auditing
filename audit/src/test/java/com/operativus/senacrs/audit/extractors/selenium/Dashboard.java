package com.operativus.senacrs.audit.extractors.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dashboard {

	private WebDriver driver;
	private String baseUrl;
	private final StringBuffer verificationErrors = new StringBuffer();

	private boolean isElementPresent(final By by) {

		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Before
	public void setUp() throws Exception {

		this.driver = new FirefoxDriver();
		this.baseUrl = "@BASE_URL@";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {

		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testDashboard() throws Exception {

		this.driver.get(this.baseUrl + "");
		try {
			assertTrue(this.isElementPresent(By.xpath("//div[contains(text(), 'Portal Professor')]")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
		try {
			assertTrue(this.isElementPresent(By.xpath("//div[contains(text(), 'Sobre o Sistema')]")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
	}
}
