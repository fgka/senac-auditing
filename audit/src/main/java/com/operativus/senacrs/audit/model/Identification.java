package com.operativus.senacrs.audit.model;

import java.util.Date;

public class Identification {

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

	public String getCourse() {

		return course;
	}

	public void setCourse(String course) {

		this.course = course;
	}

	public String getUnit() {

		return unit;
	}

	public void setUnit(String unit) {

		this.unit = unit;
	}

	public String getAcademic() {

		return academic;
	}

	public void setAcademic(String academic) {

		this.academic = academic;
	}

	public String getClassDesc() {

		return classDesc;
	}

	public void setClassDesc(String classDesc) {

		this.classDesc = classDesc;
	}

	public String getSemester() {

		return semester;
	}

	public void setSemester(String semester) {

		this.semester = semester;
	}

	public Date getLastDay() {

		return lastDay;
	}

	public void setLastDay(Date lastDay) {

		this.lastDay = lastDay;
	}

}
