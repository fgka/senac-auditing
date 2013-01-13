package com.operativus.senacrs.audit.graph.nodes.webdriver.checkers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.testutils.TestBoilerplateUtils;

public class WebDriverElementPresenceCheckerTest {

	private WebDriver driver = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		this.thrown.expect(IllegalArgumentException.class);
		obj.hasAll(null);
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

		this.thrown.expect(IllegalArgumentException.class);
		new WebDriverElementPresenceChecker(null);
	}

	@Test
	public void testWebDriverElementPresenceCheckerNullElement() {

		String[] values = null;

		values = this.getRandomStringArray();
		this.randomIndexToNull(values);
		this.thrown.expect(IllegalArgumentException.class);
		new WebDriverElementPresenceChecker(values);
	}

	private void randomIndexToNull(final String[] values) {

		int amount = 0;
		int ndx = 0;

		amount = values.length;
		ndx = TestBoilerplateUtils.randomInt(amount);
		values[ndx] = null;
	}
}
