import java.util.Random;
import java.util.Scanner;

public class PokemonGame {

	Scanner scan = new Scanner (System.in);
	private Player user;
	private Player opponent;
	
	private Player activePlayer;
	private Player waitingPlayer;
	
	private boolean gamePlaying;
	
	public PokemonGame() {
		
		user = new Player();
		opponent = new Player();
	
		
		
		gamePlaying = true;
	}
	
	
	public void checkHands() {
		
		while (!user.checkHandForPokemon() || !opponent.checkHandForPokemon()) {
			
			
			if (!user.checkHandForPokemon()) {
				
				
					opponent.addCardToHand();
					user.drawHand();
				
				
			}
			
			if (!opponent.checkHandForPokemon()) {
				
				
					user.addCardToHand();
					opponent.drawHand();
				
				
				
			}
			
		
		}
		
	}
	
	
	
	private void swapActivePlayer() {

		if (activePlayer == user) {
			waitingPlayer = user;
			activePlayer = opponent;
			
		}
		
		else {
			activePlayer = user;
			waitingPlayer = opponent;
		}
	}
	
	
	
	
	
		
	public void playRound() {
			
	
			
	}
	
	
	public void runGame() {
		
		// make sure each player has at least one
		// Pokemon in starting hand
		checkHands();
		
		// add a pokemon to each player's active spot
		// this makes starting easier
		makePokemonActive();
		
		// let the user go first
		activePlayer = user;	
		waitingPlayer = opponent;
		
		
		// loop until the game is over (someone loses)
		while (gamePlaying) {
			
			System.out.println(activePlayer + "'s turn");
			offerToAttack();
			
			activePlayer.addCardToHand();
			activePlayer.sendPokemonToBench();
			activePlayer.playEnergyOnActive();
			
			// attack the opponent with the energized active 
			
			
			swapActivePlayer();
			
		}
		
			
			
			
			
		
		
		
	}


	private void offerToAttack() {
		
		    
		
			opponent.getActivePokemon().decreaseHp(activePlayer.getActivePokemon().getHp());
			
			// if the person going is a the human user
			if (activePlayer == user) {
				
				System.out.println("Your pokemon caused " + (activePlayer.getActivePokemon()).getDamage() +
				" to the enemy");
				System.out.println("The enemy's Pokemon has " + (opponent.getActivePokemon()).getHp() + "left.");
				
			}
			
			else {
				
				System.out.println("The opponent's pokemon caused " + opponent.getActivePokemon().getDamage() +
				"to yours!");
				System.out.println("Your pokemon has " + user.getActivePokemon().getHp() + "left.");
				
			} 
			
			
			
			
		}
		
	

	private void makePokemonActive() {
		
		for (Card singleCard : user.getHand()) {
			
			if (singleCard instanceof Pokemon) {
				
				user.setActivePokemon((Pokemon) singleCard);
				
			}
			
			
		} 
		
		
		for (Card singleCard : opponent.getHand()) {
			
			if (singleCard instanceof Pokemon) {
				
				opponent.setActivePokemon((Pokemon) singleCard);
				
			}
			
			
		}
		
	}

	
	
}
