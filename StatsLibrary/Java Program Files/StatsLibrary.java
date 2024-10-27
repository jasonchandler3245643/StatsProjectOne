
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Every textbook formula from 1.0 - 3.5 programmed
 * Plus some relevant extras (median, mode, )
 */
public class StatsLibrary
{

    // DEFINITION 1.1: The mean of a sample
    public double computeMean(ArrayList<Integer> listOfNumbers) {
    
    	double sum = 0;
        
    	for (int number : listOfNumbers) {
    	
    		sum += number;
        
    	}        
    
    	return sum / listOfNumbers.size();
    
    }
    
    // MEDIAN
    public double computeMedian(ArrayList<Integer> listOfNumbers) {
        // middle when sorted
    
        Collections.sort(listOfNumbers);
        int size = listOfNumbers.size();
        
        // if odd numbers, return the middle 
        if (size % 2 != 0) {
    
            return (double) listOfNumbers.get(size / 2);
    
        }
    
        // return the sum of the two middle numbers / 2
        return (double) (listOfNumbers.get((size-1)/2) + listOfNumbers.get(size / 2))/2.0;
        
    }
    
    
    // MODE -- most common
    public int computeMode(ArrayList<Integer> listOfNumbers) {

    	
	    int mode = 0;
	    int max = 0;
	    int current = 0;
	    
	    for (int i = 0 ; i < listOfNumbers.size(); i++) {
	    	
	    	// reset to count each integer
	    	current = 0;
	    	
	    	for (int j = 1; j < listOfNumbers.size(); j++) {
	    		
	    		// compare (i) to (j)
	    		if (listOfNumbers.get(i) == listOfNumbers.get(j))
	    			// if the same, increment count
	    			current++;
	    			
	    	}
	    	
	    	if (current > max) {
	    		
	    		mode = listOfNumbers.get(i);
	    		max = current;
	    	}
	    	
    	
	    }

	   
	    
	    return mode;
    
    
    }
    
    

    
    // UNION OF TWO SETS -- everything in A and B minus overlap
    public ArrayList<Integer> computeUnion(ArrayList<Integer> A, ArrayList<Integer> B) {
    
        // clone A
        ArrayList<Integer> union =  (ArrayList<Integer>) A.clone();
        
    
        for (Integer number : B) {
        
            // if the number is already in the union, move to next
            if (union.contains(number)) 
                continue;
            
            union.add(number);
            
            
        }
        
        return union;
    
    }
    
    
    // INTERSECTION OF TWO SETS
    public ArrayList<Integer> computeIntersection(ArrayList<Integer> A, ArrayList<Integer> B) {
    
        ArrayList<Integer> intersection = new ArrayList<Integer>();
    
        for (Integer number : A) {
        
            
            if (B.contains(number)) {
            
                intersection.add(number);
                
            }
        
        
        }
        
        
        return intersection;
        
    }
    
    // THE COMPLEMENT OF A SET GIVEN ITS UNIVERSE OF DISCOURSE
    public ArrayList<Integer> computeComplement(ArrayList<Integer> A, ArrayList<Integer> universeOfDiscourse) {
    
        ArrayList<Integer> complement = new ArrayList<Integer>();
    
        for (Integer number : universeOfDiscourse) {
        
            if (!A.contains(number)) {
            
                complement.add(number);
                
            }
        
        }
        
        return complement;
    }
    
    
    // DEFINITION 1.2: VARIANCE
    public double computeVariance(ArrayList<Integer> listOfNumbers) {
    	
    	double mean = computeMean(listOfNumbers);
    	double sumOfSquares = 0;
    	
    	for (Integer singleNumber : listOfNumbers) {
    		
    		double difference = singleNumber - mean;
    		sumOfSquares += Math.pow(difference, 2);
    		
    	}
    	
    	// The book says chapter 8 explains why we divide by n - 1
    	return sumOfSquares / (listOfNumbers.size() - 1);
    	
    	
    }
    
    
    // DEFINITION 1.3: STANDARD DEVITATION
    public double computeStandardDeviation(ArrayList<Integer> listOfNumbers) {
     
        return Math.sqrt(computeVariance(listOfNumbers));
        
    }
    
    
    // DEFINITION 2.7/Theorem 2.2: PERMUTATIONS
    public BigInteger calculatePermutation(int n, int r) {
        
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(n - r));
        
        return numerator.divide(denominator);
    
    }
    
    // DEFINITION 2.8/Theorem 2.4: COMBINATIONS
    public BigInteger calculateCombination(int n, int r) {
    
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(r).multiply(factorial(n - r)));
        
        return numerator.divide(denominator);
    
    }

    
    // Recursive BigInteger factorial method.
    // Necessary for combinations and permutations
    public BigInteger factorial(int num) {

        // base
        if (num == 0) 
            return BigInteger.ONE;
            
        else
            return BigInteger.valueOf(num).multiply(factorial(num-1));
        }
    
    
    // DEFINITION 2.9: CONDITIONAL PROBABILITY
    public double probabilityAGivenB(double pAIntersectB, double B) {
    	
    	return (pAIntersectB / B);
    	
    }
    
    // DEFINITION 2.10: Events A and B are independent if 
    public boolean checkDependency(double probA, double probB, double aIntersectB) {
    	
    	return (probabilityAGivenB(probA, probB) == probA ||
    			probabilityAGivenB(probB, probA) == probB || 
    			aIntersectB == (probA * probB));
    	
    }
    			
    // THEOREM 2.5: THE MULTIPLICATIVE LAW OF PROBABILITY
    	
    	// all events A and B:
    	public double calculateEventIntersection(double probA, double probBGivenA) {
    		
    		return (probA * probBGivenA);
    		
    		
    	}
    	
    	// If A and B are independent
    	public double calculateIndependentIntersection(double probA, double probB) {
    		
    			return (probA * probB);
    		
    	}
    	
    	
    // THEOREM 2.6: THE ADDITIVE LAW OF PROBABILITY
    public double probAUnionB(double probA, double probB, double probAAndB) {
    	
    	return (probA + probB - probAAndB);
    	
    	
    }
    
    
    // THEOREM 2.7: PROBABILITY OF AN EVENT IS 1 MINUS THE EVEN NOT HAPPENING
    public double probabilityGivenComplement(double complement) {
    	
    	return 1 - complement;
    	
    }
    
    
    // DEFINITION 3.7: BINOMIAL DISTRIBUTION
    // I kept getting errors using and returning BigInteger, 
    // but it allowed me to convert from bigDeciimal
    public BigDecimal calculateBinomialDistribution(double p, double q, int n, int y) {
    	
    	BigDecimal product = BigDecimal.valueOf((Math.pow(p, y)) * (Math.pow(q, (n - y))));
    	
    	return (product.multiply(new BigDecimal(calculateCombination(n, y))));
    	
    }
    
    // THEOREM 3.7: EXPECTED VALUE OF BINOMIAL DISTRIBUTION
    public double calculateExpectedBinomialDistribution(double p, double n) {
    	
    	return n * p;
    	
    }
    
 // THEOREM 3.7: Variance OF BINOMIAL DISTRIBUTION
    public double calculateVarianceBionomialDistribution(double p, double q, double n) {
    	
    	return n * q * p;
    	
    }
    
    // DEFINITION 3.8: GEOMETRIC PROBABILITY SISTRIBUTION
    public double calculateGeometricDistribution(double p, double q, int y) {
    	
    	return p * Math.pow(q, y - 1);
    	
    	
    }
    
    // THEOREM 3.8: EXPECTED VALUE OF GEOMETRIC DISTRIBUTION
    public double calculateExpectedGeometricDistribution(double p) {
    
    	return (1 / p);
    
    }
    
 // THEOREM 3.8: Variance  OF GEOMETRIC DISTRIBUTION
    public double calculateVarianceGeometricDistribution(double p) {
    
    	return (1 - p) / (Math.pow(p, 2));
    
    }
    
    
    
    
}
