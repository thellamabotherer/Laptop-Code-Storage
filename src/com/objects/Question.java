package com.objects;

import java.util.ArrayList;

/*
 * Debates are problems in philosophy that are never truly resolved 
 */

public class Question extends Task {
	
	private int id;
	private boolean orRequirements;
	private ArrayList<Integer> reqs;
	protected String name;
	private  ArrayList<Integer[]> possibleDiscoveries; // disco num and then difficulty 

	public Question(String name, int id) {
		super(name);
		this.id = id;
	}
	
	public void printQuestionStatus () {
		System.out.println("Question of " + this.name);
		System.out.println(" - or? " + this.orRequirements);
		System.out.println(" - Discoveries to unlock " + this.reqs);
		System.out.println(" - Could unlock discoveries " + possibleDiscoveries.toString());
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOrRequirements() {
		return orRequirements;
	}

	public void setOrRequirements(boolean orRequirements) {
		this.orRequirements = orRequirements;
	}

	public ArrayList<Integer> getReqs() {
		return reqs;
	}

	public void setReqs(ArrayList<Integer> reqs) {
		this.reqs = reqs;
	}

	public ArrayList<Integer[]> getPossibleDiscoveries() {
		return possibleDiscoveries;
	}

	public void setPossibleDiscoveries(ArrayList<Integer[]> discos) {
		this.possibleDiscoveries = discos;
	}

	
	
	
	
	

}
