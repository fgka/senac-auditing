package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class WebDriverElementPresenceCheckerTest {

	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {

		this.driver = Mockito.mock(WebDriver.class);
	}

	@After
	public void tearDown() throws Exception {

		this.driver = null;
	}

	@Test
	public void testHasAllNull() {

		WebDriverElementPresenceChecker obj = null;
		String[] elements = null;

		elements = this.getRandomStringArray();
		obj = new WebDriverElementPresenceChecker(elements);
		try {
			obj.hasAll(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private String[] getRandomStringArray() {

		String[] result = null;
		int amount = 0;

		amount = TestBoilerplateUtils.randomInt(100);
		result = new String[amount];
		for (int i = 0; i < amount; i++) {
			result[i] = TestBoilerplateUtils.randomString();
		}

		return result;
	}

	@Test
	public void testHasAll() {

		WebDriverElementPresenceChecker obj = null;
		String[] elements = null;
		By by = null;

		elements = this.getRandomStringArray();
		obj = new WebDriverElementPresenceChecker(elements);
		obj.hasAll(this.driver);
		for (String element : elements) {
			by = By.xpath(element);
			Mockito.verify(this.driver).findElement(by);
		}
	}

	@Test
	public void testWebDriverElementPresenceCheckerNull() {

		try {
			new WebDriverElementPresenceChecker(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testWebDriverElementPresenceCheckerNullElement() {

		String[] values = null;

		values = this.getRandomStringArray();
		this.randomIndexToNull(values);
		try {
			new WebDriverElementPresenceChecker(values);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private void randomIndexToNull(final String[] values) {

		int amount = 0;
		int ndx = 0;

		amount = values.length;
		ndx = TestBoilerplateUtils.randomInt(amount);
		values[ndx] = null;
	}
}
