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

public class Plan {

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
	public void testTeachPlan() throws Exception {

		this.driver.findElement(By.xpath("//a[contains(text(), 'Plano de ensino')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.isElementPresent(By.xpath("//table[contains(@class, 'cabecalho')]"))) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'cabecalho')]//label[contains(text(),
// 'Curso')]/../span[1] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'cabecalho')]//label[contains(text(),
// 'Disciplina')]/../span[1] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'cabecalho')]//label[contains(text(),
// 'Professor')]/../span[1] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'cabecalho')]//label[contains(text(),
// 'Turma')]/../span[1] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //table[contains(@class, 'cabecalho')]//label[contains(text(),
// 'letivo')]/../span[1] | ]]
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (this.isElementPresent(By.xpath("//div[@id='viewPlanoEnsino']/div[7]"))) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //div[@id='viewPlanoEnsino']//span[contains(text(), '3 -') and
// contains(text(), 'Essencial')]/../../../pre[2] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //div[@id='viewPlanoEnsino']//span[contains(text(), '4 -') and
// contains(text(), 'Relacionada')]/../../../pre[2] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //div[@id='viewPlanoEnsino']//span[contains(text(), '5 -') and
// contains(text(), 'Bases')]/../../../pre[2] | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [highlight |
// //div[@id='viewPlanoEnsino']//span[contains(text(), '7 -') and
// contains(text(), 'Aprendizagem')]/../../../pre[2] | ]]
		this.driver.findElement(By.xpath("//button[contains(text(), 'Voltar')]")).click();
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
