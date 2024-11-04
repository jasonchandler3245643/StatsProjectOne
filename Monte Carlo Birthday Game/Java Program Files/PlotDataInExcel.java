

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Plots BirthdayGame data in Excel
 * 
 * @author Jason Chandler
 *
 */
public class PlotDataInExcel {

	public static void plotGameSimulationData(BirthdayGame game, int numTrials) throws IOException {
		
		Workbook bdayPlot = new XSSFWorkbook();
		Sheet page1 = bdayPlot.createSheet("Random Birthday Trials");
		
		// The header is row 0
		Row header = page1.createRow(0);
		
		// the first column is simulation number
		Cell simulationCol = header.createCell(0);
		simulationCol.setCellValue("Trials");
		
		// The second column is simulation wins
		Cell winCol = header.createCell(1);
		winCol.setCellValue("Probability of Success");
		
		// get the data
		game.runSimulations(numTrials);
		
		// for the number of simulations, starting at row index 1
		for (int i = 1; i <= game.getSimulationData().length; i++) {
			
			// create a new row, then create the row's two cells
			Row row = page1.createRow(i);
			Cell cell1 = row.createCell(0);
			Cell cell2 = row.createCell(1);
			
			// fill the new cells
			// the first column is simulation number
			cell1.setCellValue(i);
			
			// the second column is win probability 
			double winProb = ( (double) game.getSimulationData()[i - 1] / i);
			cell2.setCellValue(winProb);
			
		}
		
		
		// put it into an excel file
		try (FileOutputStream fileOut = new FileOutputStream("Birthday Data.xlsx")) {
			
			bdayPlot.write(fileOut);
			System.out.print("It worked! Yay!");
			
			
		} 
		
		catch (IOException e) {
			
			System.out.print("I struggle with error handling");
			
		}
		
		finally {
			
			// close it
			bdayPlot.close();
			
		}
		
		

		
		
		
	}
	
	
}