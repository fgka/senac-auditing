package com.operativus.senacrs.audit.extractors.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Ignore
public class Grades {

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
	public void testGrades() throws Exception {

		this.driver
				.findElement(
						By.xpath("//a[contains(@class, 'linkDownload') and contains(text(), 'Rela') and contains(text(), 'de notas')]"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.isElementPresent(By.xpath("//input[@id='comboRelacao']"))) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		this.driver.findElement(
				By.xpath("//input[@id='comboRelacao']/../img[contains(@class, 'x-form-arrow-trigger')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.driver
						.findElement(
								By.xpath("//div[contains(@class, 'x-combo-list-item') and contains(text(), 'Listagem de Confer')]"))
						.isDisplayed()) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		this.driver.findElement(
				By.xpath("//div[contains(@class, 'x-combo-list-item') and contains(text(), 'Listagem de Confer')]"))
				.click();
		this.driver.findElement(
				By.xpath("//span[contains(text(), 'dulos')]/../..//img[contains(@class, 'x-form-check')]")).click();
		this.driver.findElement(By.xpath("//button[contains(text(), 'Emitir')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.isElementPresent(By.xpath("//table[contains(@class, 'tabeladados')]"))) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'tabeladados')] | ]]
		this.driver.findElement(By.xpath("//button[contains(text(), 'Voltar')]")).click();
	}
}
