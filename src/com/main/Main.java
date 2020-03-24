package com.main;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		setup();
	}

	private static void setup() {
		// setup the testing world 
		Game game1 = new Game();
		
		// read the statedata file 
		List<List<String>> stateData = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\StateData.csv"); 
		game1.addStates(stateData, 3); // need to generalise this 
		
		// read the citydata file 
		List<List<String>> cityData = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\CityData.csv"); 
		game1.addCities(cityData, 3); // need to generalise this 
		
		// read the peopledata file 
		List<List<String>> peopleData = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\PeopleData.csv"); 
		game1.addPeople(peopleData, 5);
		
		// read the known file 
		List<List<String>> discosTrue = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\KnownData.csv"); 
		game1.setupKnown(discosTrue);
		
		// read the known file 
		List<List<String>> discosFalse = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\UnknownData.csv"); 
		game1.setupUnknown(discosFalse);
				
		// read the problems file 
		List<List<String>> probs = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\Problems.csv"); 
		game1.setupQuestions(probs);
		
		// read the problems file 
		List<List<String>> args = CSVParser.read("C:\\Users\\dunca\\eclipse-workspace\\Project03\\src\\Data\\Debates.csv"); 
		game1.setupDebates(args);
				
				
		
		turn(game1);
		
	}
	private static void turn(Game game) {
		// do all the stuff that happens in a turn
		
		// tell us what is going on before I make a GUI 
		game.printState();
		
		/* fsm which keeps asking for inputs and calls methods on 	game based on this. 
		 * The modified game is finally passed into the next turn */
		
		String inp = sc.nextLine();
		
		game.nextTurn();
		turn(game);
	}
}
