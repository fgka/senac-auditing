package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.operativus.senacrs.audit.model.form.EvaluationActivity;

public class TextOutputCollectionEvaluationActivityTest {

	@Test
	public void testCheckArgumentsNullBuilder() {

		Collection<EvaluationActivity> arg = null;

		arg = new LinkedList<EvaluationActivity>();
		try {
			TextOutputCollectionEvaluationActivity.checkArguments(null, arg);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCheckArgumentsNullId() {

		try {
			TextOutputCollectionEvaluationActivity.checkArguments(new StringBuilder(), null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
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
