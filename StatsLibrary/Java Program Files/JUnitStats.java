import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitStats {

	private StatsLibrary tester;
	
	@BeforeEach
	void setUp() throws Exception {
		
		tester = new StatsLibrary();
	}

	@Test
	void testMean() {
		
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++) {
	        
            listOfNumbers.add(i);
       
       }
       
		
		assertEquals(tester.computeMean(listOfNumbers), 50.5);
	}
	
	@Test 
	void testMedian() {
		
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++) {
	        
            listOfNumbers.add(i);
       
       }
       
		
		assertEquals(tester.computeMedian(listOfNumbers), 50.5);
	}
	
	
	@Test
	void testMode() {
		
		 ArrayList<Integer> smallerList = new ArrayList<Integer>();
		
		 smallerList.add(1);
	     smallerList.add(2);
	     smallerList.add(3);
	     smallerList.add(2);
	     
	     assertEquals(tester.computeMode(smallerList), 2);
	}
	
	
	@Test
	void testVariance() {
		
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		
		 for (int i = 1; i <= 100; i++) {
	            
	         listOfNumbers.add(i);
	       
	      }
		 
		 assertEquals(tester.computeVariance(listOfNumbers), 841.6666666666666);
		
	}
	
	@Test
	void testStandardDeviation() {
		
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		
		 for (int i = 1; i <= 100; i++) {
	            
	         listOfNumbers.add(i);
	       
	      }
		 
		 assertEquals(tester.computeStandardDeviation(listOfNumbers), 29.011491975882016);
		
	}
	
	@Test
	void testCombo() {
		
		BigInteger intBig = BigInteger.valueOf(386206920);
		
		 assertEquals(tester.calculateCombination(60, 7), intBig);
		
	}
	
	@Test
	void testPermutation() {
		BigInteger intBig = BigInteger.valueOf(720);
		
		assertEquals(tester.calculatePermutation(10, 3), intBig);
		
	}
	
	// this method is giving me alot of trouble.
	// it keeps saying the expected is .31250 and the actual is .3125
	// I am leaving it is marked as a failure in the JUnit pannel, not an error
	@Test
	void testBinomialDistribution() {
		
		BigDecimal actual = tester.calculateBinomialDistribution(.5, .5, 5, 3);
		
		assertEquals(tester.calculateBinomialDistribution(.5, .5, 5, 3), new BigDecimal(.31250));
		
	}
	
	@Test
	void testExpectedBinomialDistribution() {
		
		
		assertEquals(tester.calculateExpectedBinomialDistribution(.5, 5), 2.5);
		
	}
	
	@Test
	void testVarienceBinomialDistribution() {
		
		
		assertEquals(tester.calculateVarianceBionomialDistribution(.5, .5, 5), 1.25);
		
	}
	
	
	@Test
	void testGeometricDistribution() {
		
		assertEquals(tester.calculateGeometricDistribution(.5, .5, 3), .125);
		
	}
	
	@Test
	void testExpectedGeometricDistribution() {
		
		
		assertEquals(tester.calculateExpectedGeometricDistribution(.5), 2.0);
		
	}
	
	@Test
	void testVarienceGeometricDistribution() {
		
		
		assertEquals(tester.calculateVarianceGeometricDistribution(.5), 2.0);
		
	}
	
}
