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

## Game Run Through
1. The game verifies that each Player has a Pokemon in their opening hand. <br>
2. Each player sets a Pokemon in their hand as active. <br>
3. The user plays their turn by selecting their options. <br>
4. The computer opponent plays their turn by perform each action once whenever possible. <br>


## Applications of Superclasses/Inheritance
1. The three types of Cards (Pokemon, Energy, and Trainer) all extend the Card superclass, inheriting its name variable.<br>
2. Each subclass of Trainer overrides the perform() method. All Trainer Cards perform a unique action, but that action is different between them.<br>
3. The appropriate Pokemon subclasses (non-final evolutions) override the Pokemon class' evolve() method.<br>


<br>
I enjoyed this assignment. I feel like it tested my ability to design programs like no previous assignments.
