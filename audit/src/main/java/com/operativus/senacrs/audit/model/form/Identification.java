package com.operativus.senacrs.audit.model.form;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Identification {

	private static final String PROPERTIES_DATE_FORMAT_STR_DD_MM_YYYY = "dd/MM/yyyy";
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(PROPERTIES_DATE_FORMAT_STR_DD_MM_YYYY);

	private String course = null;
	private String unit = null;
	private String academic = null;
	private String classDesc = null;
	private String semester = null;
	private Date lastDay = null;

	public Identification(final String course, final String unit, final String academic,
			final String classDesc, final String semester) {

		super();

		this.course = course;
		this.unit = unit;
		this.academic = academic;
		this.classDesc = classDesc;
		this.semester = semester;
	}

	public String getAcademic() {

		return this.academic;
	}

	public String getClassDesc() {

		return this.classDesc;
	}

	public String getCourse() {

		return this.course;
	}

	public Date getLastDay() {

		return this.lastDay;
	}

	public String getSemester() {

		return this.semester;
	}

	public String getUnit() {

		return this.unit;
	}

	public void setAcademic(final String academic) {

		this.academic = academic;
	}

	public void setClassDesc(final String classDesc) {

		this.classDesc = classDesc;
	}

	public void setCourse(final String course) {

		this.course = course;
	}

	public void setLastDay(final Date lastDay) {

		this.lastDay = lastDay;
	}

	public void setSemester(final String semester) {

		this.semester = semester;
	}

	public void setUnit(final String unit) {

		this.unit = unit;
	}

	@Override
	public String toString() {

		return this.academic + ":" + this.unit + ":" + this.course + ":" + this.classDesc + ":" + this.semester + ":"
				+ this.toStringLastDay();
	}

	public String toStringLastDay() {

		return DATE_FORMATTER.format(this.lastDay);
	}
}
