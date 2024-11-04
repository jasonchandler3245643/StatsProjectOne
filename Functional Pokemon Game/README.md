# Functional Pokemon Game

A functional Pokemon Trading Card Game Java Program<br>

## Game Overview
Each game has 2 Players<br>
Each Player has 4 collections of Cards: a deck, hand, prizes, and a bench. <br>
The default Player constructor calls methods that fills the deck with about 6 of each Card type (Pokemon, Energy, and Trainer) <br>
To make testing easier and playing faster, I made the deck size significantly smaller. All the card containers are ArrayLists, so to increase the deck size, alter the fillDeck() method in Player.


The game alternates between the user and a computer opponent, allowing them to each perform 6 options per turn.<br>
Players can swap their active Pokemon, add a Pokemon to their bench, <br>
evolve their active Pokemon, attach an energy, attack, or use Trainer cards. <br>
The user selects which action to perform, the order, and the cards involved. However, the computer opponent
will make exactly one of each deicision in that order if possible.<br>

The game ends when a Player has 0 prize cards left, a Player has 0 cards in <br>
their deck AND hand, or a Player has no active OR benched Pokemon. <br>

## Content
**Java Files:** 25 program files <br> <br>

**Output Proof #1:** Screenshots of my output where I beat the computer.<br>
The 3 screenshots show me evolving a Charmander into a Charmeleon, adding the two energies necessary
for the stage 2 Pokemon to attack, knocking out the opponent's active, getting a prize card from that, <br>
and finally winning because the computer no longer has an active and could not yet add a pokemon to its bench.<br> <br>

**Output Proof #2:** Screenshots of my output where the computer beats me. This example shows off more of the Trainer<br>
card functionalities as well as rapidly swapping cards from the hand/bench to active spot.

## Game Run Through
1. The game verifies that each Player has a Pokemon in their opening hand. <br>
2. Each player sets a Pokemon in their hand as active. <br>
3. The game loops the user's turn and the computer opponent's turn, checking the game's status after each. <br>

## Unique Pokemon 
1. Charmander, Charmeleon, Charizard<br>
2. Clefairy, Clefable<br>
3. Psyduck, Golduck<br>
4. Foongus, Amoongus<br>
5. Grimer, Muk<br><br>

## Unique Trainers
1. Rare Candy: evolves the Player's active Pokemon<br>
2. Professor's Research: discards the Player's hand then draws 7 cards<br>
3. Potion: heals the Player's active for 30 hp<br>
4. Ultra Ball: discards 2 random cards from hand, then adds random Pokemon from deck to hand<br>
5. Youngster: shuffles hand into deck, then draws 5 cards.
6. Nemona: draws 3 cards

## Applications of Superclasses/Inheritance
1. The three types of Cards (Pokemon, Energy, and Trainer) all extend the Card superclass, inheriting its name variable.<br>
2. Each subclass of Trainer overrides the perform() method. All Trainer Cards perform a unique action, but that action is different between them.<br>
3. The appropriate Pokemon subclasses (non-final evolutions) override the Pokemon class' evolve() method.<br>


<br>
I enjoyed this assignment. I feel like it tested my ability to design program from top-to-bottom like no others have.<br>
I learned a lot about inheritance and referencing objects.
