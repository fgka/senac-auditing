package com.operativus.senacrs.audit.output.text;

import java.util.Collection;
import java.util.Iterator;

import com.operativus.senacrs.audit.model.form.EvaluationActivity;

public final class TextOutputCollectionEvaluationActivity {

	private static final String DESCRIPTION_SUFFIX_SEP_PARENS = ")";
	private static final String DESCRIPTION_PREFIX_SEP_PARENS = "(";
	private static final String FIELD_SEP_COMMA_SPACE = ", ";

	private TextOutputCollectionEvaluationActivity() {

		super();
	}

	public static void buildActivities(final StringBuilder builder, final Collection<EvaluationActivity> input) {

		Iterator<EvaluationActivity> iter = null;

		checkArguments(builder, input);
		iter = input.iterator();
		if (iter.hasNext()) {
			buildActivity(builder, iter.next());
			while (iter.hasNext()) {
				builder.append(FIELD_SEP_COMMA_SPACE);
				buildActivity(builder, iter.next());
			}
		}
	}

	protected static void checkArguments(final StringBuilder builder, final Collection<EvaluationActivity> input) {

		if (builder == null) {
			throw new IllegalArgumentException();
		}
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}

	private static void buildActivity(final StringBuilder builder, final EvaluationActivity activity) {

		builder.append(activity.getName());
		builder.append(DESCRIPTION_PREFIX_SEP_PARENS);
		builder.append(activity.getDescription());
		builder.append(DESCRIPTION_SUFFIX_SEP_PARENS);
	}
}
