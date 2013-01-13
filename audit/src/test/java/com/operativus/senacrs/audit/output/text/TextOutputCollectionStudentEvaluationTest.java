package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.form.StudentEvaluation;

public class TextOutputCollectionStudentEvaluationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCheckArgumentsNullBuilder() {

		Collection<StudentEvaluation> arg = null;

		arg = new LinkedList<StudentEvaluation>();
		this.thrown.expect(IllegalArgumentException.class);
		TextOutputCollectionStudentEvaluation.checkArguments(null, arg);
	}

	@Test
	public void testCheckArgumentsNullCollection() {

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputCollectionStudentEvaluation.checkArguments(new StringBuilder(), null);
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
