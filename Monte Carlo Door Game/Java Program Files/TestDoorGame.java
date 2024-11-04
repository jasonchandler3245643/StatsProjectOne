

public class TestDoorGame {  

	public static void main(String[] args) {
		
		/** Part a)
		 * 
		 * The sample space is S = {Prize, Dud1, Dud2}
		 * 
		 * Selecting a curtain at random gives the player 
		 * a 1/3 shot of selecting the prize door.
		 * 
		 * Running the game below shows this.
		 * The player does not get a chance to change their answer
		 * 
		 */
		DoorGame normalGame = new DoorGame(false);
		normalGame.calculateWins(10000);
		
		
		/** Part b)
		 * 
		 * There are two cases if the player swaps.
		 * Originally picked the winning door --> they lose
		 * originally picked a dud --> the host reveals a dud door: swapping wins
		 * 
		 * Mathematically, the probability of winning after switching 
		 * is the sum of initially picking a losing door: 1/3 + 1/3 = 2/3
		 * P(Win after switching) = 1/3 + 1/3 = 2/3
		 *
		 * Sticking to the original after revealing a door yield about
		 * the same chance of getting the winning door as picking 1/3.
		 * 
		 * If the player doesn't swap:
		 * Originally picked a dud --> still a dud
		 * Originally picked winning --> still 1/3
		 * 
		 */
		
		DoorGame switchGameSwap = new DoorGame(true);
		switchGameSwap.calculateWins(10000, true);
		
		DoorGame switchGameStick = new DoorGame(true);
		switchGameStick.calculateWins(10000, false);

	}

}