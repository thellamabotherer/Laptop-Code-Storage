package com.objects;

public class Person {
	
	private String name;
	private City location; // need a building location too, this could make city redundant
	private Task currentTask = new Task("test");

	public Person(String name, City location) {
		this.name = name;
		this.location = location;
	}

	public void printStateShort() {
		System.out.println(this.name);
		System.out.println(" - Currently in city of " + location.getName());
		System.out.println(" - " + currentTask.getDescShort());
	}
	
	public void eachTurn () {
		
		// things that happen to them, (random events)
		/*
		 * Maybe feed in some kind of an int array that lets us decide what kind of events can happen. 
		 * This would need to be passed down as an argument all the way from game. 
		 * Maybe game calls for people stuff to happen per nation so that nation can pass another int array.
		 * Then this will make some events based on stuff that can happen in the world and in the specific nation.
		 */
		
		// are they working on something, if so, does they make progress
		
		// if they're not working on something, pick a new task 
	}
	

}
