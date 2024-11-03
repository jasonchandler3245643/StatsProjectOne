# Monte Carlo Door Game

## Description
This program is a Monte Carlo simulation of the famous "Price is right" problem described on textbook page 34


## Content
**Four Java files:**<br>
1. **DoorGame** runs the game and keeps track of the wins. It uses an array of length 3 to keep track of each Door.
Each game randomly assigns the winning door and the player's door. Then, typical games continue by checking if the
player's door is winning. Alternatively, the game will reveal a dud door and give the player the opprotunity to swap
their door if true is passed through the constructor. The player will always swap their door if true is passed through
its run method; the player will stick if false is passed.<br>

2. **TestDoorGame** creates and runs the games. It runs one normal game and two games where they swap.
The slides for this assignment ask for only 4 lines of code in the main method; however, I use 6 to
illustrate the three probabilities: winning with original door, winning when swapping after reveal,
and winning when sticking after reveal.<br>

3. **Door:** holds two booleans. Status is true if the door is the winning door. Reveal is true if the door was revealed.<br>

4. **Player:** holds a Door object representing the door they chose.<br><br>

**One output screenshot (jpg)**<br>

## Textbook pg 34 question 2.20 answer:
I also answered this in the comment of my main method

Part a)<br>
The sample space is S = {Prize, Dud1, Dud2}<br>
Selecting a curtain at random gives the player 
1/3 shot of selecting the prize door.

Part b)<br>
The probability of winning by switching is 2/6<br>
There are two scenarios: <br>
Originally picked a dud --> When the host reveals the other dud, the player swaps to the winning door.<br>
Originally picked the winning door --> When the host reveals a dud, the player swaps to the other dud.<br>
Since the probability of picking a dud door is 2/3, so is the probability of winning by switching. <br> <br>

The probability of winning by sticking is 1/3, as revealing a door does not alter the player's current door.
