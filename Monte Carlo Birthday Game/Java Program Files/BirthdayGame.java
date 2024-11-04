import java.util.Random;

/**
 * Hosts a Birthday Game
 * 
 * @author Jason Chandler
 *
 */
public class BirthdayGame {

	private Person[] people;
	private boolean match;
	
	// holds the number of wins per Monte Carlo run
	private int[] simulationWins;
	
	/**
	 * Creates a game with a set group size
	 * 
	 * @param size The group's size
	 */
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
	
	/**
	 * Randomly assigns birthdays to each Person
	 * 
	 */
	private void assignBirthdays() {
		Random gen = new Random();
		
		for (int i = 0; i < people.length; i++) {
			
			people[i] = new Person(gen.nextInt(365) + 1);
			
		}
		
	}
	
	/**
	 * Checks for two people with the same birthday
	 * 
	 */
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
	
	/**
	 * Runs the game
	 * Two steps: assigning birthdays and checking for matches
	 * 
	 */
	private void runGame() {
		
		// assign the birthdays
		assignBirthdays();
		
		// check for any matches
		checkForMatches();
		
	}

	
	
	/**
	 * Runs simulations BirhdayGames times to generate data
	 * Prints the number of successful trials / the total number of trials
	 * 
	 * @param simulations The number of trials to be run
	 */
	public void runSimulations(int simulations) {
			
		simulationWins = new int[simulations];
		int simulatedWins = 0;

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