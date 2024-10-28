# Functional Pokemon Game

A somewhat functional Pokemon Trading Card Game. 

Honestly, I hit a major wall working on this project. All of the groups of cards, the deck, hand, prizes, and bench seem fine. The game loop does too: It alternates between the "user" and "opponent." What I am having trouble with is mostly game logic: I cannot get the two players' active Pokemon to damage eachother. The Pokemon both have a damage and an hp counter, both of which are ints. However, I cannot seem to get one player's active Pokemon's damage to decrease the other's hp. The Game alternates back and forth, allowing for each player to take a turn while their decks do slowly deplete. I know that is true because it outputs hundreds of lines of the players going back-and-forth. 
