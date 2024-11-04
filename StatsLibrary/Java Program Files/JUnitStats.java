import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tester for StatsLibrary
 * 
 * @author Jason Chandler
 *
 */
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
	void testUnion() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		
		B.add(3);
		B.add(4);
		B.add(5);
		
		ArrayList<Integer> union = new ArrayList<Integer>();
		union.add(1);
		union.add(2);
		union.add(3);
		union.add(4);
		union.add(5);
		assertEquals(tester.computeUnion(A, B), union);
		
	}
	
	@Test
	void testIntersection() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		
		B.add(3);
		B.add(4);
		B.add(5);
		
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		intersection.add(3);
		
		assertEquals(tester.computeIntersection(A, B), intersection);
		
	}
	
	@Test
	void computeComplement() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> universe = new ArrayList<Integer>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		
		universe.add(1);
		universe.add(2);
		universe.add(3);
		universe.add(4);
		universe.add(5);
		
		ArrayList<Integer> complementA = new ArrayList<Integer>();
		complementA.add(4);
		complementA.add(5);
		
		assertEquals(tester.computeComplement(A, universe), complementA);
		
		
	}
	
	@Test
	void testDependency() {
		
		assertEquals(tester.checkDependency(.4, .6, .24), true);
		
	}
	
	@Test
	void testFailedDependency() {
		
		assertEquals(tester.checkDependency(.2, .5, .24), false);
		
	}
	
	@Test
	void testProbabilityGivenComplement() {
		
		assertEquals(tester.checkDependency(.4, .6, .24), true);
		
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
	
	@Test
	void testBinomialDistribution() {
		
		BigDecimal binomialDist = tester.calculateBinomialDistribution(.5, .5, 5, 3);
		int comparison = binomialDist.compareTo(new BigDecimal(0.31250));
		
		assertEquals(0, comparison);
		
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