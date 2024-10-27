import java.util.ArrayList;
import java.util.Random;

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
    
    
    public void fillDeck() {
    
        deck.clear();
        
        // add numPokemon Charmanders
        for (int i = 0; i < numPokemon; i++) {
        
                deck.add(new Charmander() );
        
        }
        
        // add numRareCandies rare candies
        for (int i = 0; i < numRareCandies; i++) {
        
                deck.add(new RareCandy() );
        
        }
        
        // fill the rest with energies
        for (int i = 0; i < 60 - numPokemon - numRareCandies; i++) {
        
                deck.add(new Energy() );
        
            }

        
        
    }
    
    // draw the usable hand
    public void drawHand() {
    
        hand.clear();
        Random gen = new Random();
        
        for (int i = 0; i < 7; i++) {
        
            int cardToTakeIndex = gen.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        
        }
    
    
    }
    
    // check the hand for a Pokemon
    public boolean checkHand() {
    
        for (Card singleCard : hand) {
        
            // if singleCard is a Pokemon
            if (singleCard instanceof Pokemon ) {
                
                return true;
        
            }
        
        }
        
        return false;
        
    }
    
    
    public void fillPrizeHand() {
    
        prizeHand.clear();
        Random gen = new Random();
        
        for (int i = 0; i < 6; i++) {
        
            int cardToTakeIndex = gen.nextInt(deck.size());
            prizeHand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        
        }
    
    
    }
    
    
    

    public boolean isBricked() {
    
        for (Card singleCard : prizeHand) {
        
            // if singleCard is a TRAINER CARD LIKE RARE CANDY
            if (singleCard instanceof RareCandy ) {
                
                return true;
        
            }
        
        }
        
        return false;
    
    }
    
    private void countCandiesInPrizeHands() {
		

    	
    	int count = 0; 
    	
    	for (Card singleCard : prizeHand) {
    		
    		if (singleCard instanceof RareCandy)
    			count++;
    		
    		
    	}
    	
    	prizedCandies.set(count, prizedCandies.get(count) + 1);
		
	}
    
    
    // running does not play a game of pokemon
    // It fills the deck, then draws the hand from it and checks for a Pokemon
    
    // NEW part 2
    // It fills the prize hand and checks for a TRAINER is in it. 
    //
    
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
    



	public void displayPokemonFirstHand() {
    
    	double probabilityPokemonFirstHand = (double) numPokemonFirstHand / numRuns;
    	
        System.out.println("Pokemon first hand: " +numPokemonFirstHand + "/" + numRuns +
        " = " + probabilityPokemonFirstHand);

    }
    
    public void displayBrickedPrizeHand() {
    	
    	double probabilityBrickedPrizeHands = (double) numBricks / numRuns;
    	
    	System.out.println("Bricked prize decks: " + numBricks + "/" + numRuns +
    	        " = " + probabilityBrickedPrizeHands);
    	
    	
    }
    
    public void displayCandiesInPrizeHands() {
    	
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
