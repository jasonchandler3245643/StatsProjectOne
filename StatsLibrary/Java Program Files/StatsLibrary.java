
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Every textbook formula from 1.0 - 3.5 programmed
 * Plus some relevant extras (median, mode, sets, etc)
 * 
 * @author Jason Chandler
 * 
 */
public class StatsLibrary
{

    /**
     * Definition 1.1: The Mean of a Sample
     * Returns the "average" valuea
     * 
     * @param listOfNumbers The set to calculate the mean of
     * @return The mean of the set
     */
    public double computeMean(ArrayList<Integer> listOfNumbers) {
    
    	double sum = 0;
        
    	for (int number : listOfNumbers) {
    	
    		sum += number;
        
    	}        
    
    	return sum / listOfNumbers.size();
    
    }
    
    /**
     * Median
     * Returns the middle value of the set
     * 
     * @param listOfNumbers The set to calculate the median of
     * @return The median of the set
     */
    public double computeMedian(ArrayList<Integer> listOfNumbers) {
       
    
        Collections.sort(listOfNumbers);
        int size = listOfNumbers.size();
        
        // if odd numbers, return the middle 
        if (size % 2 != 0) {
    
            return (double) listOfNumbers.get(size / 2);
    
        }
    
        // return the sum of the two middle numbers / 2
        return (double) (listOfNumbers.get((size-1)/2) + listOfNumbers.get(size / 2))/2.0;
        
    }
    
    
    /**
     * Mode
     * Returns the most common item in the set
     * 
     * @param listOfNumbers The set to calculate mode of
     * @return The most common integer in the set
     */

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
    

    /**
     *  Union of two sets
     * 
     * @param A The first set
     * @param B The second set
     * @return The union of sets A and B
     */
    public ArrayList<Integer> computeUnion(ArrayList<Integer> A, ArrayList<Integer> B) {
    
        // clone A
        ArrayList<Integer> union =  (ArrayList<Integer>) A.clone();
        
    
        for (Integer number : B) {
        
            // if the number is not in the union, add it
            if (!union.contains(number)) 
            	 union.add(number);
              
        }
        
        return union;
    
    }
    
    
   /**
    * Intersection of two sets
    * 
    * @param A The first set
    * @param B The second set
    * @return The intersection of sets A and B
    */
    public ArrayList<Integer> computeIntersection(ArrayList<Integer> A, ArrayList<Integer> B) {
    
        ArrayList<Integer> intersection = new ArrayList<Integer>();
    
        for (Integer number : A) {
        
            if (B.contains(number)) {
            
                intersection.add(number);
                
            }
        
        }
        
        return intersection;
        
    }
    
    /**
     * The complement of a set
     * 
     * @param A The set to find the complement of
     * @param universeOfDiscourse The universe of discourse of set A
     * @return The set of things in universeOfDiscourse but not A
     */
    public ArrayList<Integer> computeComplement(ArrayList<Integer> A, ArrayList<Integer> universeOfDiscourse) {
    
        ArrayList<Integer> complement = new ArrayList<Integer>();
    
        for (Integer number : universeOfDiscourse) {
        
            if (!A.contains(number)) {
            
                complement.add(number);
                
            }
        
        }
        
        return complement;
    }
    
    
    /**
     * Definition 1.2: Variance
     * 
     * @param listOfNumbers The set to find variance of
     * @return The variance of the set
     */
    public double computeVariance(ArrayList<Integer> listOfNumbers) {
    	
    	double mean = computeMean(listOfNumbers);
    	double sumOfSquares = 0;
    	
    	for (Integer singleNumber : listOfNumbers) {
    		
    		double difference = singleNumber - mean;
    		sumOfSquares += Math.pow(difference, 2);
    		
    	}
    	
    	// The book says we divide by n - 1
    	return sumOfSquares / (listOfNumbers.size() - 1);

    }
    
    
    /**
     * Definition 1.3: Standard Deviation
     * 
     * @param listOfNumbers The set to find standard deviation of
     * @return The standard deviation of the set	
     */
    public double computeStandardDeviation(ArrayList<Integer> listOfNumbers) {
     
        return Math.sqrt(computeVariance(listOfNumbers));
        
    }

    /**
     * Definition 2.7 / Theorem 2.2: Permutations
     * 
     * @param n The total number of items to choose from
     * @param r The number of items to choose from n
     * @return The number of unique, ordered groups of size r that can be made from n items
     */
    public BigInteger calculatePermutation(int n, int r) {
        
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(n - r));
        
        return numerator.divide(denominator);
    
    }
    
    
    /**
     * Definition 2.8 / Theorem 2.4: Combinations
     * 
     * @param n The total number of items to choose from
     * @param r he number of items to choose from n
     * @return The number of non-ordered sequences of length r that can be made from n items
     */
    public BigInteger calculateCombination(int n, int r) {
    
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(r).multiply(factorial(n - r)));
        
        return numerator.divide(denominator);
    
    }

    
    /**
     * Recursive BigInteger factorial method for
     * solving combinations and permutations.
     * 
     * @param num Each subsequent number being multiplied.
     * @return The BigInteger version of a factorial
     */
    private BigInteger factorial(int num) {

        // base
        if (num == 0) 
            return BigInteger.ONE;
            
        else
            return BigInteger.valueOf(num).multiply(factorial(num-1));
        }
    
    
    /**
     * Definition 2.9: Condition Probability
     * 
     * @param pAIntersectB The probability of A INTERSECT B
     * @param B The probability of the met condition B
     * @return the probability of A given B
     */
    public double probabilityAGivenB(double pAIntersectB, double B) {
    	
    	return (pAIntersectB / B);
    	
    }
    
    /**
     * Definition 2.10: Events A and B are independent if
     * 
     * @param probA The probability of event A
     * @param probB The probability of event B
     * @param aIntersectB The probability of the intersection of A and B
     * @return true if events A and B are independent; false otherwise
     */
    public boolean checkDependency(double probA, double probB, double aIntersectB) {
    	
    	return (probabilityAGivenB(probA, probB) == probA ||
    			probabilityAGivenB(probB, probA) == probB || 
    			aIntersectB == (probA * probB));
    	
    }
    			
    /**
     * Theorem 2.5: The Multiplicative Law of Probability
     * Returns the intersection of non-independent events A and B
     * 
     * 
     * @param probA The probability of event A
     * @param probBGivenA The probability of event B given A
     * @return The probability of the intersection of A and B
     */
    public double calculateEventIntersection(double probA, double probBGivenA) {
    		
    	return (probA * probBGivenA);
    		
    		
    }
    	
    /**
     * Theorem 2.5: The Multiplicative Law of Probability
     * Returns the intersection of independent events A and B
     * 
     * 
     * @param probA The probability of event A
     * @param probB The probability of event B
     * @return The probability of the intersection of A and B
     */
    public double calculateIndependentIntersection(double probA, double probB) {
    		
    		return (probA * probB);
    		
    	}
    	
    	
   /**
    * Theorem 2.6: The Additive Law of Probability
    * 
    * @param probA The probability of event A
    * @param probB The probability of event B
    * @param probAAndB The probability of the intersection of A and B
    * @return The probability of the union of A and B
    */
    public double probAUnionB(double probA, double probB, double probAAndB) {
    	
    	return (probA + probB - probAAndB);
    	
    	
    }
    
    
    /**
     * Theorem 2.7: The Complement of Probability
     * 
     * @param complement The probability of the complement
     * @return The probability of an event
     */
    public double probabilityGivenComplement(double complement) {
    	
    	return 1 - complement;
    	
    }
    
  
    /**
     * Definition 3.7: Binomial Distribution
     * 
     * @param p The probability of success
     * @param q The probability of failure
     * @param n The number of trials
     * @param y The number of successful trials
     * @return The probability of obtaining y successes in n trials
     */
    public BigDecimal calculateBinomialDistribution(double p, double q, int n, int y) {
    	
    	BigDecimal product = BigDecimal.valueOf((Math.pow(p, y)) * (Math.pow(q, (n - y))));
    	
    	return (product.multiply(new BigDecimal(calculateCombination(n, y))));
    	
    }
    

    /**
     * Theorem 3.7: Expected value of binomial distribution
     * 
     * @param p The success rate
     * @param n The number of trials
     * @return The expected value
     */
    public double calculateExpectedBinomialDistribution(double p, double n) {
    	
    	return n * p;
    	
    }
    
    /**
     * Theorem 3.7: Variance of binomial distribution
     * 
     * @param p The success rate
     * @param n The number of trials
     * @return The variance
     */
    public double calculateVarianceBionomialDistribution(double p, double q, double n) {
    	
    	return n * q * p;
    	
    }
    
    /**
     * Definition 3.8: Geometric Distribution
     * 
     * @param p The probability of success
     * @param q The probability of failure
     * @param y The trial of first success
     * @return The probability of having the first success on trial y
     */
    public double calculateGeometricDistribution(double p, double q, int y) {
    	
    	return p * Math.pow(q, y - 1);
    	
    	
    }
    
    /**
     * Theorem 3.8: Expected value of geometric distribution
     * 
     * @param p The success rate
     * @return The average number of trials until first success
     */
    public double calculateExpectedGeometricDistribution(double p) {
    
    	return (1 / p);
    
    }
    
    /**
     * Theorem 3.8: Variance of geometric distribution
     * 
     * @param p The success rate
     * @return The variance of when the first success occurrs 
     */
    public double calculateVarianceGeometricDistribution(double p) {
    
    	return (1 - p) / (Math.pow(p, 2));
    
    }
    
    
    
    
}