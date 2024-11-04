import java.util.*;

/**
 * Hosts the Price is Right game
 * 
 * Each game has a player, 3 doors, and a 
 * boolean to determine if to let the player swap their Door.
 * 
 * @author Jason Chandler
 *
 */
public class DoorGame {

	private Player player;
	private Door[] doors;	
	private boolean switchDoor;
	
	// these hold the data
	private int numWins;
	private int switchWins;
	
	/**
	 * Constructs a DoorGame
	 * 
	 * @param swap True gives the player the option to swap their door; false does not
	 */
	public DoorGame(boolean swap) {
		
		switchDoor = swap;
		
		player = new Player();
		doors = new Door[3];
		
		numWins = 0;
		switchWins = 0;
		
	}
	
	/**
	 * Makes one Door a winner by setting its status true
	 * 
	 */
	private void assignPrizeDoor() {
		
		Random gen = new Random();
		
		// construct the doors
		
		doors[0] = new Door();
		doors[1] = new Door();
		doors[2] = new Door();
		
		// make one door the winning door
		(doors[gen.nextInt(3)]).setStatus(true);
		
	}
	
	/**
	 * Assigns a Door to the Player
	 * 
	 */
	private void choosePlayerDoor() {
		Random gen = new Random();
		
		// set the player door to be random
		player.setPlayerDoor(doors[gen.nextInt(3)]);
		
	}
	
	
	
	
	/**
	 * Calculates the successful trials for 
	 * a regular game where the host does not 
	 * reveal a door
	 * 
	 * @param runs The number of simulations
	 */
	public void calculateWins(int runs) {
		
		for (int i = 0; i < runs; i++) {
			
			playGame();
			
		}
		
		double wins = (double) numWins / runs;
		
		System.out.println("Normal wins: " + numWins + " / " 
					+ runs + " = " + wins);
		
	}
	
	/**
	 * Calculates the successful trials for games 
	 * where the host reveals a door.
	 * 
	 * @param runs The number of simulations
	 * @param swap Whether or not the player will stick or swap their door
	 */
	public void calculateWins(int runs, boolean swap) {
		
		for (int i = 0; i < runs; i++) {
			
			playGame();
			
		
				for (Door door: doors) {
					
					if (door.getStatus() == false && player.getPlayerDoor() != door) {
						
						door.setReveal(true);
						
					}
					
				}
				
				// the player will now have two options
				Door[] lessDoors = new Door[2];
				
				// fill the new array with the non-revealed doors
				int index = 0;
				for (Door door: doors) {
					
					if (door.getReveal() == false) {
						lessDoors[index] = door;
						index++;
					}
					
				}
				
		
				if (swap == true) {
					
					// swap the player door 
					if (player.getPlayerDoor() == lessDoors[0])
						player.setPlayerDoor(lessDoors[1]);
					
					if (player.getPlayerDoor() == lessDoors[1])
						player.setPlayerDoor(lessDoors[0]);
					
				}
				
				                                   
				// compare the playerDoor to the winning door
				if (player.getPlayerDoor().getStatus() == true) {
								
					switchWins++;
													
				}

				
			}
		
			
			double wins = (double) switchWins / runs;
		
			System.out.println("Wins when swap door "+ swap + ": " 
					+ switchWins + " / " + runs + " = " + wins);

		}
	
	
	/**
	 * Plays the DoorGame
	 * 
	 */
	private void playGame() {
		
		assignPrizeDoor();
		
		choosePlayerDoor();
		
		if (switchDoor != true)
			
			// compare the playerDoor to the winning door
			if (player.getPlayerDoor().getStatus() == true) {
			
			numWins++;
			
			}                     
		
		
	}
	
	
}