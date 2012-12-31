package com.operativus.senacrs.audit.graph.nodes;


public interface Node {
	
	public static final String END_TO_STRING = "END";
	public static final String START_TO_STRING = "START";
	public static final Node START = new Node() {
		
		public String toString() {
			
			return START_TO_STRING;
		};
	};
	public static final Node END = new Node() {
		
		public String toString() {
			
			return END_TO_STRING;
		};
	};
}
