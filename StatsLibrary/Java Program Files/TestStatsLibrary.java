import java.util.ArrayList;
import java.math.BigInteger;

public class TestStatsLibrary
{
   
    
    public static void main(String[] args) {
        
        StatsLibrary tester = new StatsLibrary();
    
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        ArrayList<Integer> smallerList = new ArrayList<Integer>();
        
        for (int i = 1; i <= 100; i++) {
        
             listOfNumbers.add(i);
        
        }
        
        smallerList.add(1);
        smallerList.add(2);
        smallerList.add(3);
        smallerList.add(2);
        
        // mean!
        System.out.println("Mean of the set of first 100 natural numbers: " 
        + tester.computeMean(listOfNumbers));
    
        // median!
        System.out.println("Median of the set of first 100 natural numbers: " 
        + tester.computeMedian(listOfNumbers));
        
        // mode!
      System.out.println("Mode of the set of first 100 natural numbers: " 
                + tester.computeMode(listOfNumbers));
        System.out.println("Mode of the set of {1, 2, 3, 2}: " 
                + tester.computeMode(smallerList));
                
        
        
        System.out.println("");
        
        // Set operations:
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        
        a.add(1);
        a.add(2);
        a.add(3);
        
        b.add(3);
        b.add(4);
        b.add(5);
        
        System.out.println("A: {1, 2, 3}   B: {3, 4, 5}");
        
        System.out.print("Union: ");
        ArrayList<Integer> union = tester.computeUnion(a,b);
        for (int i = 0; i < union.size(); i++) {
        
            System.out.print(union.get(i) + " ");
        
        }
        System.out.println("");
        
        System.out.print("Intersection: ");
        ArrayList<Integer> intersection = tester.computeIntersection(a,b);
        for (int i = 0; i < intersection.size(); i++) {
        
            System.out.print(intersection.get(i) + " ");
        
        }
        System.out.println("");
        
        System.out.print("Complement of A, B is Universe of Discourse: ");
        ArrayList<Integer> complement = tester.computeComplement(a,b);
        for (int i = 0; i < complement.size(); i++) {
        
            System.out.print(complement.get(i) + " ");
        
        }
        System.out.println("\n");
        
        
        
        // VARIANCE
        
        listOfNumbers.clear();
        
        for (int i = 1; i <= 100; i++) {
            
            listOfNumbers.add(i);
       
       }
        
        System.out.println("Variance of the first 100 natural numbers: "
        		+ tester.computeVariance(listOfNumbers));
        
     
        // Standard Deviation
        System.out.println("Standard Deviation of the first 100 natural numbers: "
        		+ tester.computeStandardDeviation(listOfNumbers));
        
        System.out.println("");
        
        
        // Combination and Permutation
        BigInteger combination = tester.calculateCombination(60, 7);
        BigInteger permutation = tester.calculatePermutation(10, 3);
        
        System.out.println("60 C 7: " + combination);
        System.out.println("10 P 3: " + permutation);
        
        System.out.println("");
        
        
        // Probability axioms
        // P(A | B)
        System.out.println("P(A AND B): .2,    P(B) = .4"); 
        System.out.println("P(A | B) = " + tester.probabilityAGivenB(.2, .4));
        System.out.println("");
        
        System.out.println("P(A) = .3,  P(B) = .4, P(A AND B) = .2"); 
        System.out.println("A and B are independent: " + tester.checkDependency(.3, .4, .2));
        System.out.println("");
        
        System.out.println("P(A) = .3,  P(B | A) = .2"); 
        System.out.println("Intersection:  " + tester.calculateEventIntersection(.3, .2));
        System.out.println("");
        
        System.out.println("P(A) = .3,  P(B) = .4"); 
        System.out.println("Intersection of Independents:  " + tester.calculateIndependentIntersection(.3, .24));
        System.out.println("");
        
        System.out.println("P(A) = .5, P(B) =.2, P(A INTERSECT B) = .1 ");
        System.out.println("Union: P(A) + P(B) - P (A INTERSECT B) = "  + tester.probAUnionB(.5, .2, .1));
        System.out.println("");
        
        System.out.println("P(A) = .5");
        System.out.println("P(~A) = 1 - P(A) = " + tester.probabilityGivenComplement(.5));
        System.out.println("");
        
        
        // BINOMIAL DISTRIBUTION
        
        System.out.println("Binomial Distribution for getting head on 3 / 5 coint flips ");
        System.out.println(tester.calculateBinomialDistribution(.5, .5, 5, 3));
        
        // flip coin 5 times --> 50% or 2.5 heads
        System.out.println("Expected value: " + tester.calculateExpectedBinomialDistribution(.5, 5));
        System.out.println("Variance: "  + tester.calculateVarianceBionomialDistribution(.5, .5, 5));
        System.out.println("");
        
        
        
        // GEOMETRIC DISTRIBUTION
        System.out.println("Geometric Distribution for getting heads for the FIRST TIME on flip 3 / 5 ");
        System.out.println(tester.calculateGeometricDistribution(.5, .5, 3));
        
        System.out.println("Expected value: " + tester.calculateExpectedGeometricDistribution(.5));
        System.out.println("Variance: "  + tester.calculateVarianceGeometricDistribution(.5));
    }
    
    
    
}
