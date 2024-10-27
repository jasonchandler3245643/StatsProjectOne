import java.util.Random;

public class BirthdayGame {

	private Person[] people;
	private boolean match;
	
	// holds the number of wins per Monte Carlo run
	private int[] simulationWins;
	
	public BirthdayGame(int size) {
		
		people = new Person[size];
		match = false;
		
	}
	
	public boolean getMatch() {
		
		return match;
		
	}
	
	public int[] getSimulationData() {
		
		return simulationWins;
		
	} 
	
	// 
	private void assignBirthdays() {
		Random gen = new Random();
		
		for (int i = 0; i < people.length; i++) {
			
			people[i] = new Person(gen.nextInt(365) + 1);
			
		}
		
	}
	
	// sees if two people have the same birthday
	private void checkForMatches() {
		
		
		for (int i = 0; i < people.length; i++) {
			
			for (int j = i + 1; j < people.length; j++) {
				
				
				if (people[i].getBirthday() == people[j].getBirthday()) {
					
					match = true;
					return; 
					
				}
			}
		}

	}
	
	// plays the game
	public void runGame() {
		
		// assign the birthdays
		assignBirthdays();
		
		// check for any matches
		checkForMatches();
		
	}

	
	
	// runs Monte Carlo simulation
	public void runSimulations(int simulations) {
			
		simulationWins = new int[simulations];
		int simulatedWins = 0;
			
			
		// start with 1 because row 0 in excel is header
		for (int i = 0; i < simulations; i++) {
				
			BirthdayGame bday = new BirthdayGame(people.length);
				
			bday.runGame();
				
			// if there is a match
			if (bday.getMatch() == true) {
				simulatedWins++;
			}
				
			simulationWins[i] = simulatedWins;
		
		}
			
			double odds = ((double) simulatedWins) / simulations;
			
			System.out.println(simulatedWins + "/" + simulations + " = " + odds + " successful trials");
			
	}
	
}
