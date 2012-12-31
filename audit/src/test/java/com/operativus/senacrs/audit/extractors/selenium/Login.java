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

public class Login {

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
	public void testLogin() throws Exception {

		try {
			assertTrue(this.isElementPresent(By.xpath("//div[contains(text(), 'Portal Professor')]")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
		this.driver.findElement(By.xpath("//div[contains(text(), 'Portal Professor')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (!this.driver.findElement(By.xpath("//img[@id='loading']")).isDisplayed()) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		this.driver.findElement(By.xpath("//input[@id='usr']")).clear();
		this.driver.findElement(By.xpath("//input[@id='usr']")).sendKeys("@USERNAME@");
		this.driver.findElement(By.xpath("//input[@name='passwd']")).clear();
		this.driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("@PASSWORD@");
		this.driver.findElement(By.xpath("//input[@id='btnEntrar']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.isElementPresent(By.xpath("//td[contains(text(), 'Portal Professor')]"))) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

	}
}
