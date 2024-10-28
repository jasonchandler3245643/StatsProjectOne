import java.util.ArrayList;
import java.util.Random;

public class Player {

	// players have a deck, playing hand, and prize hand 
	private ArrayList<Card> deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> prizes;
	private ArrayList<Card> bench;

	// players are either playing or not
	private Pokemon activePokemon;
	private String name;
	
	public Player() {
		
		// construct the ArrayLists
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizes = new ArrayList<Card>();
		bench = new ArrayList<Card>();

		// fill the deck
		fillDeck();
		
		// draw hand & prizes
		drawHand();
		drawPrizes();
		
	}
	
	public Pokemon getActivePokemon() {
		
		return activePokemon;
		
	}
	

	
	
	public void setActivePokemon(Pokemon p) {
		
		activePokemon = p;
		
	}
	
	
	
	public void setName(String word) {
		
		name = word;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	
	public ArrayList<Card> getHand() {
		
		return hand;
		
	}
	
	public void fillDeck() {
		
		// add 20 Pokemon, 4 of each type
		for (int i = 0; i < 4; i++) {
			
			deck.add(new Pokemon("Muk", 30, 10, Type.dark));
			deck.add(new Pokemon("Charmander", 30, 10, Type.fire));
			deck.add(new Pokemon("Butterfree", 30, 30, Type.bug));
			deck.add(new Pokemon("Clefairy", 30, 30, Type.fairy));
			deck.add(new Pokemon("Snivy", 30, 30, Type.grass));
		}
		
		// add 20 energies, 4 for each type of pokemon
		for (int i = 0; i < 4; i++) {
			
			deck.add(new Energy(Type.dark));
			deck.add(new Energy(Type.fire));
			deck.add(new Energy(Type.bug));
			deck.add(new Energy(Type.fairy));
			deck.add(new Energy(Type.grass));
			
		}
		
		for (int i = 0; i < 4; i++) {
			
			deck.add(new Trainer());
			deck.add(new Trainer());
			deck.add(new Trainer());
			deck.add(new Trainer());
			deck.add(new Trainer());
		}
		
		
	}
	
	// adds 7 cards from the player's deck to their hand
	public void drawHand() {
		
		
		Random gen = new Random();
		
		for (int i = 0; i < 7; i++) {
			
			hand.add(deck.get(gen.nextInt(deck.size())));
			
		}
		
	}
	
	
	public void drawPrizes() {
		
	
		
		Random gen = new Random();
		
		for (int i = 0; i < 7; i++) {
			
			prizes.add(deck.get(gen.nextInt(deck.size())));
			
		}
		
		
	}
	
	
	
	
	
	public boolean checkHandForPokemon() {
		
		boolean present = false;
		
		for (Card card : hand) {
			
			if (card instanceof Pokemon) {
				present = true;
				break;
			}
			
		}
		
		
		return present;
		
	}
	
	public void addCardToHand() {
		
		Random gen = new Random();
		Card newCard = deck.get(gen.nextInt(deck.size()));
		
		hand.add(newCard);
		deck.remove(newCard);
		
	}
	
	public void addPrizeCardToHand() {
		
		Random gen = new Random();
		Card newPrize = prizes.get(gen.nextInt(prizes.size()));
		
		hand.add(newPrize);
		prizes.remove(newPrize);
		
	}

	public void sendPokemonToBench() {
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Pokemon) {
				
				bench.add((Pokemon) singleCard);
				
			}
			
		}
		
	}
	
	public void playEnergyOnActive() {
		
		
		
		
	}
	
	
	

	
	
	
	
}
