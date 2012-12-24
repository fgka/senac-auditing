package com.operativus.senacrs.audit.model;

public class Identification {
	
	private final String course;
	private final String unit;
	private final String academic;
	private final String classDesc;
	private final String semester;

	public Identification(String course, String unit, String academic,
			String classDesc, String semester) {
		
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

	public String getUnit() {
		return unit;
	}

	public String getAcademic() {
		return academic;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public String getSemester() {
		return semester;
	}

}
