package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.operativus.senacrs.audit.model.form.StudentEvaluation;


public class TextOutputCollectionStudentEvaluationTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCheckArgumentsNullBuilder() {

		Collection<StudentEvaluation> arg = null;

		arg = new LinkedList<StudentEvaluation>();
		try {
			TextOutputCollectionStudentEvaluation.checkArguments(null, arg);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}


	@Test
	public void testCheckArgumentsNullCollection() {

		try {
			TextOutputCollectionStudentEvaluation.checkArguments(new StringBuilder(), null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testBuildStudentsEmpty() {

		String result = null;
		StringBuilder builder = null;
		Collection<StudentEvaluation> arg = null;

		builder = new StringBuilder();
		arg = new LinkedList<StudentEvaluation>();
		TextOutputCollectionStudentEvaluation.buildStudents(builder, arg);
		result = builder.toString();
		Assert.assertTrue(result.isEmpty());
	}

}
