package com.operativus.senacrs.audit.graph.edges.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.graph.edges.IllegalSourceNodeException;
import com.operativus.senacrs.audit.graph.nodes.Node;
import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNode;
import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNodeFactory;
import com.operativus.senacrs.audit.graph.nodes.webdriver.WebDriverNodeTypeEnum;

public class OpenDashboardTest {

	private OpenDashboard edge = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {

		this.edge = OpenDashboard.getInstance();
	}

	@After
	public void tearDown() throws Exception {

		this.edge = null;
	}

	@Test
	public void testTraverseNullStartSource() {

		thrown.expect(IllegalArgumentException.class);
		this.edge.traverse(null);
	}

	@Test
	public void testTraverseNonStartSource() {

		WebDriverNode node = null;
		
		node = WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.END);
		thrown.expect(IllegalSourceNodeException.class);
		thrown.expectMessage(Node.START.toString());
		this.edge.traverse(node);
	}

	@Test
	public void testTraverseStartSource() {
				
		WebDriverNode node = null;
		
		node = WebDriverNodeFactory.createNode(WebDriverNodeTypeEnum.START);
		this.edge.traverse(node);
	}
}
