
import java.io.IOException;

/**
 * Tests a BirthdayGame
 * 
 * @author Jason Chandler
 *
 */
public class TestBirthdayGame extends PlotDataInExcel {

	
	public static void main(String args[]) throws IOException {
		
		/**
		 *  Checks to see if at least 2/23 random Person
		 *  have the same birthday 100,000 times. Plots the data
		 *  in excel
		 *  
		 */
		
		plotGameSimulationData(new BirthdayGame(23), 100000);
		
	}
	
	
	
	
	
	
	
}