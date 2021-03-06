package com.operativus.senacrs.audit.extractors.selenium;

import static org.junit.Assert.assertTrue;
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
public class About {

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
	public void testAbout() throws Exception {

		try {
			assertTrue(this.isElementPresent(By.xpath("//div[contains(text(), 'Sobre o Sistema')]")));
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
		this.driver.findElement(By.xpath("//div[contains(text(), 'Sobre o Sistema')]")).click();
		assertTrue(this.driver.findElement(By.xpath("//p[contains(@class, 'about-line')]/b[1]")).getText()
				.matches("^@VERSION@$"));
		this.driver.findElement(By.xpath("//button[contains(text(), 'Fechar')]")).click();
	}
}
