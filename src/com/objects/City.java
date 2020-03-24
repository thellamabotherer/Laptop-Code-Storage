package com.objects;

import java.util.ArrayList;

public class City {
	
	private String name;
	private State owner;
	
	private ArrayList<Pop> population;
	private ArrayList<Building> buildings;
	private ArrayList<Person> people;
	
	
	
	public City (String name, State owner) { // need to change city loader in Game whenever this is changed 
		this.name = name;
		this.owner = owner;
		this.population = new ArrayList();
		this.people = new ArrayList();
		this.buildings = new ArrayList();
	}



	public void printStateShort() {
		System.out.println("Status of " + this.name + " (" + this.owner.getCode() + ")");
		System.out.println(" - Population " + population.size());
		System.out.println(" - Great people " + people.size());
		System.out.println(" - Buildings " + buildings.size());
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public State getOwner() {
		return owner;
	}



	public void setOwner(State owner) {
		this.owner = owner;
	}



	public ArrayList<Pop> getPopulation() {
		return population;
	}



	public void setPopulation(ArrayList<Pop> population) {
		this.population = population;
	}



	public ArrayList<Building> getBuildings() {
		return buildings;
	}



	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}



	public ArrayList<Person> getPeople() {
		return people;
	}



	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}



	public void addPerson(Person p) {
		this.people.add(p);
	}
	
	

}
