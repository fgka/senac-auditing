package com.operativus.senacrs.audit.model;


public class EvaluationActivity implements Comparable<EvaluationActivity>{
	
	private final int sequence;
	private final EvaluationType type;
	private String name = null; 
	private String description = null;
	
	public EvaluationActivity(int sequence, EvaluationType type, String name, String description) {

		super();
		this.sequence = sequence;
		this.type = type;
		this.name = name;
		this.description = description;
	}
	
	public int getSequence() {
	
		return sequence;
	}

	
	public EvaluationType getType() {

		return type;
	}

	public String getName() {
	
		return name;
	}

	
	public void setName(String name) {
	
		this.name = name;
	}

	
	public String getDescription() {
	
		return description;
	}

	
	public void setDescription(String description) {
	
		this.description = description;
	}

	@Override
	public int compareTo(EvaluationActivity o) {
				
		return 0;
	} 

}
