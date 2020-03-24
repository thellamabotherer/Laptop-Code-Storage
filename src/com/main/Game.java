package com.main;

import java.util.ArrayList;
import java.util.List;

import com.objects.City;
import com.objects.Debate;
import com.objects.Discovery;
import com.objects.Person;
import com.objects.Question;
import com.objects.State;

public class Game {

	private int turn;

	private ArrayList<City> cities;
	private ArrayList<State> states;
	private ArrayList<Person> people;

	private ArrayList<Discovery> known;
	private ArrayList<Discovery> unknown;

	private ArrayList<Question> openQuestions1;
	private ArrayList<Question> closedQuestions;
	private ArrayList<Debate> openDebates;
	private ArrayList<Debate> closedDebates;

	public Game() {
		this.turn = 0;
		cities = new ArrayList();
		states = new ArrayList();
		people = new ArrayList();
		known = new ArrayList();
		unknown = new ArrayList();
		closedDebates = new ArrayList();
		closedQuestions = new ArrayList();
	}

	public void nextTurn() {
		this.turn++;
	}
	/*
	 * This will be a much bigger method that will call all the AI turns and then
	 * make all the random stuff happen and then do the normal book-keeping from
	 * turn to turn.
	 */

	public void printState() {

		System.out.println("Turn " + this.turn); // change this into giving a year and season

		// give all the info we need on a turn
		System.out.println("-----CITIES-----");
		for (City c : cities) {
			// c.printStateShort();
		}
		System.out.println("-----PEOPLE-----");
		for (Person p : people) {
			// p.printStateShort();
		}

		System.out.println("-----KNOWN-----");
		for (Discovery d : known) {
			d.printStateShort();
		}
		System.out.println("-----UNKNOWN-----");
		for (Discovery d : unknown) {
			d.printStateShort();
		}
		System.out.println("-----DEBATES-----");
		for (Debate a : closedDebates) {
			a.printDebateStatus();
		}System.out.println("-----QUESTIONS-----");
		for (Question q : closedQuestions) {
			q.printQuestionStatus();
		}
		
		
	}

	public void addCities(List<List<String>> cityData, int size) {
		for (int i = 0; i < size; i++) { // update this whenever the city constructor changes
			// search through states based on code String
			String searchKey = cityData.get(i).get(1); // gets the code of the city owner
			State stateFound = states.get(0);
			for (State check : states) {
				if (searchKey == check.getCode()) {
					stateFound = check;
				}
			}
			cities.add(new City(cityData.get(i).get(0), stateFound));
		}
	}

	public void addStates(List<List<String>> stateData, int size) {
		for (int i = 0; i < size; i++) { // update this whenever the city constructor changes
			states.add(new State(stateData.get(i).get(0), stateData.get(i).get(1)));
		}
	}

	public void addPeople(List<List<String>> peopleData, int size) {
		for (int i = 0; i < size; i++) { // update this whenever the city constructor changes
			// search through cities based on code String
			String searchKey = peopleData.get(i).get(1); // gets the name of the city where they live
			City cityFound = cities.get(0);
			for (City check : cities) {
				if (searchKey.contentEquals(check.getName())) {
					cityFound = check;
				}
			}
			Person p = new Person(peopleData.get(i).get(0), cityFound);
			cityFound.addPerson(p);
			people.add(p);
		}
	}

	public void setupKnown(List<List<String>> discosTrue) {
		for (List<String> disco : discosTrue) {
			known.add(new Discovery(disco));
		}
	}

	public void setupUnknown(List<List<String>> discosFalse) {
		for (List<String> disco : discosFalse) {
			unknown.add(new Discovery(disco));
		}
	}

	public void setupDebates(List<List<String>> args) {
		for (List<String> arg : args) {

			Debate d = new Debate(null, Integer.parseInt(arg.get(0)));

			if (arg.get(1) == "0") {
				d.setOrRequirements(true);
			} // or
			else {
				d.setOrRequirements(false);
			} // and

			// keep reading numbers off until we find 'end'
			int i = 2;
			ArrayList<Integer> reqList = new ArrayList();
			while (!arg.get(i).equals("end")) {
				// System.out.println("i = " + i + " read " +arg.get(i));
				reqList.add(Integer.parseInt(arg.get(i)));
				i++;
			}
			d.setReqs(reqList);
			d.setName(arg.get(i + 1));

			Integer[] temp = { 0, 0 };
			ArrayList<Integer[]> discos = new ArrayList();
			while (!arg.get(i + 2).contentEquals("end")) {
				temp[0] = Integer.parseInt(arg.get(i + 2));
				temp[1] = Integer.parseInt(arg.get(i + 3));

				discos.add(temp);
				i = i + 2;
			}

			d.setPossibleDiscoveries(discos);

			// setup possible outcomes

			this.closedDebates.add(d);

		}
	}

	public void setupQuestions(List<List<String>> probs) {
		for (List<String> prob : probs) {

			Question q = new Question(null, Integer.parseInt(prob.get(0)));

			if (prob.get(1) == "0") {
				q.setOrRequirements(true);
			} // or
			else {
				q.setOrRequirements(false);
			} // and

			// keep reading numbers off until we find 'end'
			int i = 2;
			ArrayList<Integer> reqList = new ArrayList();
			while (!prob.get(i).equals("end")) {
				// System.out.println("i = " + i + " read " +arg.get(i));
				reqList.add(Integer.parseInt(prob.get(i)));
				i++;
			}
			q.setReqs(reqList);
			q.setName(prob.get(i + 1));

			Integer[] temp = { 0, 0 };
			ArrayList<Integer[]> discos = new ArrayList();
			while (!prob.get(i + 2).contentEquals("end")) {
				temp[0] = Integer.parseInt(prob.get(i + 2));
				temp[1] = Integer.parseInt(prob.get(i + 3));

				discos.add(temp);
				i = i + 2;
			}

			q.setPossibleDiscoveries(discos);

			// setup possible outcomes

			this.closedQuestions.add(q);

		}
	}
}
