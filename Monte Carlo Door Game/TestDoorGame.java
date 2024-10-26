
// Tests the DoorGame class
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDoorGame {  

	public static void main(String[] args) {
		
		/** Part a)
		 * 
		 * Selecting a curtain at random gives the player 
		 * a 1/3 shot of selecting the prize door.
		 * 
		 * Running the game below shows this
		 * 
		 */
		DoorGame normalGame = new DoorGame(false);
		normalGame.runGames(10000);
		
		
		/** Part b)
		 * 
		 * Cho
		 * 
		 * Running the game below shows this
		 * 
		 */
		
		DoorGame switchGame = new DoorGame(true);
		switchGame.runSwitchGames(10000);

	}

}
