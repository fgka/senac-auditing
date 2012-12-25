package com.operativus.senacrs.audit.model;

import java.util.LinkedList;
import java.util.List;


public class Form {
	
	private Identification id;
	private SkillSet skillSet;
	private List<EvaluationActivity> activities = new LinkedList<EvaluationActivity>();
	private List<StudentEvaluation> evaluations = new LinkedList<StudentEvaluation>();
	private String notes;
	
	public Identification getId() {
	
		return id;
	}
	
	public void setId(Identification id) {
	
		this.id = id;
	}
	
	public SkillSet getSkillSet() {
	
		return skillSet;
	}
	
	public void setSkillSet(SkillSet skillSet) {
	
		this.skillSet = skillSet;
	}
	
	public List<EvaluationActivity> getActivities() {
	
		return activities;
	}
	
	public void setActivities(List<EvaluationActivity> activities) {
	
		this.activities = activities;
	}
	
	public List<StudentEvaluation> getEvaluations() {
	
		return evaluations;
	}
	
	public void setEvaluations(List<StudentEvaluation> evaluations) {
	
		this.evaluations = evaluations;
	}
	
	public String getNotes() {
	
		return notes;
	}
	
	public void setNotes(String notes) {
	
		this.notes = notes;
	}
	
	
}
