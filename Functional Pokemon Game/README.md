# Functional Pokemon Game

A functional Pokemon Trading Card Game Java Program<br>

Each game has 2 Players<br>
Each Player has 4 collections of Cards: a deck, hand, prizes, and a bench. <br>

The game alternates between Players, allowing them to each perform 6 options per turn.<br>
Players can swap their active Pokemon, add a Pokemon to their bench, <br>
evolve their active or a benched Pokemon, attack, or use a Trainer. <br>

The game ends when a Player has 0 prize cards left, a Player has 0 cards in <br>
their deck, or a Player has no active or benched Pokemon. <br>

## File Information
**Java Files:** 25 program files <br>
**Other:** Screenshots of my output, including me beating the computer

## Game Nuances
As I am unfamiliar with the rules of the card game, I made slight alterations to the game's rules<br>
Here is a list of notes about the game: 
1. Each game starts by having the players each set an active Pokemon


## Applications of ____
1. The three types of Cards (Pokemon, Energy, and Trainer) all extend the Card superclass, inheriting its name variable.<br>
2. Each subclass of Trainer overrides the perform() method. All Trainer Cards perform a unique action, but that action is different between them.<br>
3. The appropriate Pokemon subclasses (non-final evolutions) override the Pokemon class' evolve() method.<br>


<br>
I enjoyed this assignment. I feel like it tested my ability to design programs like no previous assignments.
