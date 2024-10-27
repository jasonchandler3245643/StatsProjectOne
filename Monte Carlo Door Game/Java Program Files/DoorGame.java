import java.util.*;

public class DoorGame {

	private Player player;
	private Door[] doors;	
	private boolean switchDoor;
	
	// these hold the data
	private int numWins;
	private int switchWins;
	
	
	public DoorGame(boolean swap) {
		
		switchDoor = swap;
		
		player = new Player();
		doors = new Door[3];
		
		numWins = 0;
		switchWins = 0;
		
	}
	
	private void assignPrizeDoor() {
		
		Random gen = new Random();
		
		// construct the doors
		
		doors[0] = new Door();
		doors[1] = new Door();
		doors[2] = new Door();
		
		// make one door the winning door
		(doors[gen.nextInt(3)]).setStatus(true);
		
	}
	
	private void choosePlayerDoor() {
		Random gen = new Random();
		
		// set the player door to be random
		player.setPlayerDoor(doors[gen.nextInt(3)]);
		
	}
	
	
	
	
	// starter method for game
	public void calculateWins(int runs) {
		
		for (int i = 0; i < runs; i++) {
			
			playGame();
			
		}
		
		double wins = (double) numWins / runs;
		
		System.out.println("Normal wins: " + numWins + " / " 
					+ runs + " = " + wins);
		
	}
	
	
	
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
		
	
	
	
	
	
		 
	public void playGame() {
		
			
		// assign the prize door and two dud doors (set the doors' statuses)
		assignPrizeDoor();
		
		// select the player's door
		choosePlayerDoor();
		
		// check if the
		if (switchDoor != true)
			
			// compare the playerDoor to the winning door
			if (player.getPlayerDoor().getStatus() == true) {
			
			numWins++;
			
			}                     
		
		
	}
	
	
}
