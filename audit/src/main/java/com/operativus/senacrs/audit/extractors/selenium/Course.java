package com.operativus.senacrs.audit.extractors.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Course {

	private WebDriver driver;
	private String baseUrl;
	private final StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {

		this.driver = new FirefoxDriver();
		this.baseUrl = "@BASE_URL@";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPickCourse() throws Exception {

		this.driver.findElement(
				By.xpath("//td/div[contains(@class, 'x-grid3-col-dis') and contains(text(), '@DISCIPLINE_NAME@')]"))
				.click();
	}

	@After
	public void tearDown() throws Exception {

		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(final By by) {

		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
