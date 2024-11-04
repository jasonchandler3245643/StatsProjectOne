import java.util.ArrayList;
import java.util.Random;

/**
 * Hosts a Pokemon Card Game
 * 
 * @author Jason Chandler
 *
 */
public class CardGame
{
    
    // Player deck and hands
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeHand;
    
    // used to fill deck for the experiment
    private int numPokemon;
    private int numRareCandies;
    
    // counters for the odds
    private int numRuns;
    private int numPokemonFirstHand;
    private int numBricks;
    private ArrayList<Integer> prizedCandies;
    
    public CardGame() {
    
        deck = new ArrayList<Card>();    
        hand = new ArrayList<Card>();
        prizeHand = new ArrayList<Card>();
        numRuns = 0;
        numPokemon = 1;
        numRareCandies = 1;
        
        prizedCandies = new ArrayList<Integer>();
    	
    	// 5 options: 0, 1, 2, 3, or 4 candies
    	for (int j = 0; j < 5; j++) {
    		
    		prizedCandies.add(0);
    		
    	}
        
        
    }
    
    /**
     * Constructs a CardGame with a set number of Pokemon and Rare Candies
     * 
     * @param pokemon
     * @param candies
     */
    public CardGame(int pokemon, int candies) {
    
        deck = new ArrayList<Card>();    
        hand = new ArrayList<Card>();
        prizeHand = new ArrayList<Card>();
        numRuns = 0;
        numPokemon = pokemon;
        numRareCandies = candies;
        
        prizedCandies = new ArrayList<Integer>();
    	
    	// 5 options: 0, 1, 2, 3, or 4 candies
    	for (int j = 0; j < 5; j++) {
    		
    		prizedCandies.add(0);
    		
    	}
    }
    
    /**
     * Fills the player's deck
     * 
     */
    private void fillDeck() {
    
        deck.clear();
        
        for (int i = 0; i < numPokemon; i++) {
        
                deck.add(new Charmander() );
        
        }
        
        for (int i = 0; i < numRareCandies; i++) {
        
                deck.add(new RareCandy() );
        
        }
        
        for (int i = 0; i < 60 - numPokemon - numRareCandies; i++) {
        
                deck.add(new Energy() );
        
            }

        
        
    }
    
    /**
     * Takes a card from the deck and puts it in the hand
     * 
     */
    private void drawHand() {
    
        hand.clear();
        Random gen = new Random();
        
        for (int i = 0; i < 7; i++) {
        
            int cardToTakeIndex = gen.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        
        }
    
    
    }
    
    /**
     * Checks the hand for a Pokemon
     * 
     * @return true if there is a Pokemon in the hand; false otherwise
     */
    private boolean checkHand() {
    
        for (Card singleCard : hand) {
        
            // if singleCard is a Pokemon
            if (singleCard instanceof Pokemon ) {
                
                return true;
        
            }
        
        }
        
        return false;
        
    }
    
    /**
     * Fills the prize hand
     * 
     */
    private void fillPrizeHand() {
    
        prizeHand.clear();
        Random gen = new Random();
        
        for (int i = 0; i < 6; i++) {
        
            int cardToTakeIndex = gen.nextInt(deck.size());
            prizeHand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        
        }
    
    
    }
    
    /**
     * Checks the prizeHand for RareCandy
     * 
     * @return true if there is a RareCandy in prizeHand
     */
    private boolean isBricked() {
    
        for (Card singleCard : prizeHand) {
        
            // if singleCard is a TRAINER CARD LIKE RARE CANDY
            if (singleCard instanceof RareCandy ) {
                
                return true;
        
            }
        
        }
        
        return false;
    
    }
    
    /**
     * Counts the number of RareCandy in prizeHand and saves it
     * 
     */
    private void countCandiesInPrizeHands() {
		
    	int count = 0; 
    	
    	for (Card singleCard : prizeHand) {
    		
    		if (singleCard instanceof RareCandy)
    			count++;
    		
    		
    	}
    	
    	prizedCandies.set(count, prizedCandies.get(count) + 1);
		
	}
    
    
   /**
    * Runs the game
    * 
    * @param trials The number of runs
    */
    public void run(int trials) {
    
            for (int i = 0; i < trials; i++) {
            numRuns++;
            
            // fill the deck and draw the hand
            fillDeck();
            drawHand();
            
            // if in the hand, increment numPokemonFirstHand
            if (checkHand()) {
                
                numPokemonFirstHand++;
                
            }

        
            fillPrizeHand(); 
 
            countCandiesInPrizeHands();
            
            if (isBricked()) {
            
                numBricks++;
            
            }
            
            
            
        }
        
        System.out.println(numPokemon + " Pokemon " + numRareCandies + " candies \n");    
       
        displayPokemonFirstHand();
        displayBrickedPrizeHand();
        displayCandiesInPrizeHands();
        
    }
    
    /**
     * Prints the number of Pokemon in first hand and its data
     * 
     */
	private void displayPokemonFirstHand() {
    
    	double probabilityPokemonFirstHand = (double) numPokemonFirstHand / numRuns;
    	
        System.out.println("Pokemon first hand: " +numPokemonFirstHand + "/" + numRuns +
        " = " + probabilityPokemonFirstHand);

    }
    
	/**
     * Prints the number of bricked prize hands
     * (prize hands with at least one RareCandy)
     * 
     */
	private void displayBrickedPrizeHand() {
    	
    	double probabilityBrickedPrizeHands = (double) numBricks / numRuns;
    	
    	System.out.println("Bricked prize decks: " + numBricks + "/" + numRuns +
    	        " = " + probabilityBrickedPrizeHands);
    	
    	
    }
    
	/**
	 * Prints the number of trials with 0, 1, 2, 3, and 4 
	 * RareCandy in prizeHand
	 * 
	 */
	private void displayCandiesInPrizeHands() {
    	
    	double probabilityNumCandy;
    	
    	for (int i = 0; i < prizedCandies.size(); i++) {
    		
    		probabilityNumCandy = (double) prizedCandies.get(i) / numRuns;
    		
    		System.out.println("Trials with " + i + " Rare Candies: " 
    		+ prizedCandies.get(i) + " / " + numRuns + " = " 
    				+ probabilityNumCandy);
    		
    	}
    	
    	System.out.println("");
    	
    }
    
}