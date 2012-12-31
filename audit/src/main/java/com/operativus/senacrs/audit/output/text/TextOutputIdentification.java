package com.operativus.senacrs.audit.output.text;

import com.operativus.senacrs.audit.model.form.Identification;

public final class TextOutputIdentification {

	private static final TextOutputIdentification instance = new TextOutputIdentification();

	public static TextOutputIdentification getInstance() {

		return instance;
	}

	private TextOutputIdentification() {

		super();
	}

	public void buildAcademic(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.getAcademic());
	}

	public void buildClass(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.getClassDesc());
	}

	public void buildCourse(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.getCourse());
	}

	public void buildLastDay(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.toStringLastDay());
	}

	public void buildSemester(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.getSemester());
	}

	public void buildUnit(final StringBuilder builder, final Identification input) {

		this.checkArguments(builder, input);
		builder.append(input.getUnit());
	}

	private void checkArguments(final StringBuilder builder, final Identification input) {

		if (builder == null) {
			throw new IllegalArgumentException();
		}
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}
}
