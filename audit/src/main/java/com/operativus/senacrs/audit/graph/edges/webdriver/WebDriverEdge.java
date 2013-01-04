package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.edges.Edge;

public interface WebDriverEdge
		extends Edge {

	WebDriver getWebDriver();
}
