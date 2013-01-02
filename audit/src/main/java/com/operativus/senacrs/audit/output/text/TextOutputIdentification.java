package com.operativus.senacrs.audit.output.text;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.model.form.Identification;

public final class TextOutputIdentification {

	private TextOutputIdentification() {

		super();
	}

	public static void buildAcademic(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.getAcademic());
	}

	protected static void checkArguments(final StringBuilder builder, final Identification input) {
	
		if (builder == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("builder");
		}
		if (input == null) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("input");
		}
	}

	public static void buildClass(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.getClassDesc());
	}

	public static void buildCourse(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.getCourse());
	}

	public static void buildLastDay(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.toStringLastDay());
	}

	public static void buildSemester(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.getSemester());
	}

	public static void buildUnit(final StringBuilder builder, final Identification input) {

		checkArguments(builder, input);
		builder.append(input.getUnit());
	}
}
