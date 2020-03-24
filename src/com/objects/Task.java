package com.objects;

// superclass of questions, debates and works (maybe some jobs too for rulers) 

public class Task {
	
	protected String name;
	
	
	
	public Task(String name) {
		this.name = name;
	}

	

	public String getDescShort () {
		return name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

}
