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

public class Year {

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
	public void testPickYear() throws Exception {

		try {
			assertTrue(this.isElementPresent(By.xpath("//input[@id='cmb_anos']")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
		this.driver.findElement(By.xpath("//input[@id='cmb_anos']/../img[1]")).click();
		this.driver.findElement(By.xpath("//div[contains(@class,'x-combo-list-item') and contains(text(), '@YEAR@')]"))
				.click();
		try {
			assertTrue(this.isElementPresent(By.xpath("//td/div[contains(text(),'@YEAR@')]")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
	}
}
