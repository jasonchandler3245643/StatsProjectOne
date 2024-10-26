import java.util.*;

public class DoorGame {

	private boolean switchDoor;
	private Player player;
	private Door[] doors;	
	
	// these hold th
	private int numWins;
	private int switchWin;
	
	
	public DoorGame(boolean swap) {
		
		switchDoor = swap;
		
		player = new Player();
		doors = new Door[3];
		
		numWins = 0;
		switchWin = 0;
		
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
	public void runGames(int num) {
		
		for (int i = 0; i < num; i++) {
			
			playGame();
			
		}
		
		System.out.println(numWins);
		
	}
	
	
	
	public void runSwitchGames(int num) {
		
		for (int i = 0; i < num; i++) {
			
			playGame();
			
		}
		
		System.out.println(switchWin);
		
	}
	
	
	
		 
	public void playGame() {
		
			
		// assign the prize door and two dud doors (set the doors' statuses)
		assignPrizeDoor();
		
		// select the player's door
		choosePlayerDoor();
		
		if (switchDoor != true)
		// compare the playerDoor to the winning door
		if (player.getPlayerDoor().getStatus() == true) {
			
			numWins++;
			
		}                     
		
		// the next part is part b) of the problem
		// if switchDoor is true
		if (switchDoor == true) {
	
			//reveal a dud door
			
			for (Door door: doors) {
				
				if (door.getStatus() == false && player.getPlayerDoor() != door) {
					
					door.setReveal(true);
					
				}
				
			}
			
			// the player will now have two options
			Door[] swapped = new Door[2];
			
			// fill the new array with the non-revealed doors
			int index = 0;
			for (Door door: doors) {
				
				if (door.getReveal() == false) {
					swapped[index] = door;
					index++;
				}
				
			}
			
			// swap the player door always
			if (player.getPlayerDoor() == swapped[0])
				player.setPlayerDoor(swapped[1]);
			
			if (player.getPlayerDoor() == swapped[1])
				player.setPlayerDoor(swapped[0]);
			                                   
			// compare the playerDoor to the winning door
			if (player.getPlayerDoor().getStatus() == true) {
							
				switchWin++;
							
							
			}
			
					
			
			
		}
	
		
	}
	
	
}
