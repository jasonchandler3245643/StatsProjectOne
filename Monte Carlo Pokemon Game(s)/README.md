# Monte Carlo Pokemon Game(s)

This program runs three experiments Monte Carlo experiments based upon the Pokemon Trading Card Game

## Contents
8 java files, one jpg screenshot of the output, and an excel file that contains experiments one and two plotted & graphed.
<br><br>
**The CardGame class** runs the game and generates all of the data. It has instance variable of a deck, hand, and prize hand; it also has varaiables to fill the decks/hands properly and variables to calculate probabilities. <br>
**The TestCardGame class** creates games with different numbers Pokemon and Rare Candies and runs them.<br>


## Experiment One: Pokemon in opening hand
<br>1 Pokemon --> 116842/1000000 Pokemon drawn = **11.7%**
<br>2 Pokemon --> 221139/1000000 Pokemon drawn = **22.1%**
<br>3 Pokemon --> 314899/1000000 Pokemon drawn = **31.5%**
<br>4 Pokemon --> 400417/1000000 Pokemon drawn = **40%**

**This adheres to the math!**
**P(At least 1 Pokemon in hand) = 1 - P(No Pokemon in hand)**

1. One Pokemon in deck --> P(No Pokemon) = (59 C 7) / (60 C 7) = .883
   <br>P(at least 1 Pokemon) = 1 - .883 = .117 = **11.7%**

3. Two Pokemon in deck --> P(No Pokemon) = (58 C 7) / (60 C 7) = .779
   <br>P(At least 1 Pokemon) = 1 - .779 = .221 = **22.1%**

5. Three Pokemon in deck --> P(No Pokemon) = (57 C 7) / (60 C 7) = 264,385,836 / 386,206,920 = .685
   <br>P(At least 1 Pokemon) = 1 - .685 = .315 = **31.5%**

6. Three Pokemon in deck --> P(No Pokemon) = (56 C 7) / (60 C 7) = 231,917,400 / 386,206,920 = .60
   <br>P(At least 1 Pokemon) = 1 - .60 = .40 = **40%**<br><br>



## Experiment Two: Rare Candies in prize hand ("bricked" hand)

<br>1 Candy --> 99472/1000000 Candies drawn = .0994 = **10%**
<br>2 Candy --> 191535/1000000 Candies drawn = **19.2%**
<br>3 Candy --> 276003/1000000 Candies drawn = **27.6%**
<br>4 Candy --> 351390/1000000 Candies drawn = **35.1%**

**The concept is the same:**
**P(At least 1 Candy in hand) = 1 - P(No Candies in hand)**
**Choose 6 in each step instead of 7 in each formula:**

1. One Candy in deck --> P(No Candies) = (59 C 6) / (60 C 6) = 45,057,474 / 50,063,860 = .90
   <br>P(at least 1 Candy) = 1 - .90 = .10 = **10%**

2. Two Candy in deck --> P(No Candies) = (58 C 6) / (60 C 6) = 40,475,358 / 50,063,860 = .808
   <br>P(At least 1 Candy) = 1 - .808 = .192 = **19.2%**

3. Three Candy in deck --> P(No Candies) = (57 C 6) / (60 C 6) = 36,288,252 / 50,063,860 = .725
   <br>P(At least 1 Candy) = 1 - .725 = .275 = **~27.6%**

4. Three Candy in deck --> P(No Candies) = (56 C 6) / (60 C 6) = 32,468,436 / 50,063,860 = .649
   <br>P(At least 1 Candy) = 1 - .649 = .351 = **35.1%**<br><br>

## Experiment Three: How many Rare Candies?

**1 Rare Candy in prize hand:**<br>
Trials with 0 Rare Candies: 5649870
<br>Trials with 1 Rare Candies: 350130
<br>Trials with 2 Rare Candies: 0
<br>Trials with 3 Rare Candies: 0
<br>Trials with 4 Rare Candies: 0

**2 Rare Candies in prize hand:**<br>
Trials with 0 Rare Candies: 5321524
<br>Trials with 1 Rare Candies: 658545
<br>Trials with 2 Rare Candies: 19931
<br>Trials with 3 Rare Candies: 0
<br>Trials with 4 Rare Candies: 0

**3 Rare Candies in prize hand:**<br>
Trials with 0 Rare Candies: 5008591
<br>Trials with 1 Rare Candies: 933664
<br>Trials with 2 Rare Candies: 56717
<br>Trials with 3 Rare Candies: 1028
<br>Trials with 4 Rare Candies: 0

**4 Rare Candies in prize hand:**<br>
Trials with 0 Rare Candies: 4713436
<br>Trials with 1 Rare Candies: 1176113
<br>Trials with 2 Rare Candies: 106625
<br>Trials with 3 Rare Candies: 3791
<br>Trials with 4 Rare Candies: 35

