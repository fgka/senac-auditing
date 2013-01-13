package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.operativus.senacrs.audit.model.form.EvaluationActivity;

public class TextOutputCollectionEvaluationActivityTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCheckArgumentsNullBuilder() {

		Collection<EvaluationActivity> arg = null;

		arg = new LinkedList<EvaluationActivity>();
		this.thrown.expect(IllegalArgumentException.class);
		TextOutputCollectionEvaluationActivity.checkArguments(null, arg);
	}

	@Test
	public void testCheckArgumentsNullCollection() {

		this.thrown.expect(IllegalArgumentException.class);
		TextOutputCollectionEvaluationActivity.checkArguments(new StringBuilder(), null);
	}

	@Test
	public void testBuildActivitiesEmpty() {

		String result = null;
		StringBuilder builder = null;
		Collection<EvaluationActivity> arg = null;

		builder = new StringBuilder();
		arg = new LinkedList<EvaluationActivity>();
		TextOutputCollectionEvaluationActivity.buildActivities(builder, arg);
		result = builder.toString();
		Assert.assertTrue(result.isEmpty());
	}

}
