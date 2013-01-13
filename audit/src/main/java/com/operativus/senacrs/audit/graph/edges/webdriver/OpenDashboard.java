package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.openqa.selenium.WebDriver;

import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNode;

public final class OpenDashboard
		extends AbstractWebDriverEdge {

	public OpenDashboard(WebDriver driver) {
		
		super(driver);
	}
	
	@Override
	protected void internTraverse(WebDriverNode source) {
		// TODO Auto-generated method stub
		
	}
}
