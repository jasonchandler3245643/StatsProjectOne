
import java.io.IOException;

public class TestBirthdayGame extends PlotDataInExcel {

	
	public static void main(String args[]) throws IOException {
		
		
		// runs 100,000 simulations of the game
		// and plots the calculated probability using
		// Monte Carlo
		
		plotGameSimulationData(new BirthdayGame(23), 100000);
		
	}
	
	
	
	
	
	
	
}
