package com.operativus.senacrs.audit.model;

public class Identification {

	private final String course;
	private final String unit;
	private final String academic;
	private final String classDesc;
	private final String semester;

	public Identification(final String course, final String unit, final String academic,
			final String classDesc, final String semester) {

		super();

		this.course = course;
		this.unit = unit;
		this.academic = academic;
		this.classDesc = classDesc;
		this.semester = semester;
	}

	public String getCourse() {

		return this.course;
	}

	public String getUnit() {

		return this.unit;
	}

	public String getAcademic() {

		return this.academic;
	}

	public String getClassDesc() {

		return this.classDesc;
	}

	public String getSemester() {

		return this.semester;
	}

}
