# Monte Carlo Pokemon Game(s)

This program runs two experiments and is based upon the code we did in class a well over a month ago.
I started fresh for my functional Pokemon game


## Experiment One: Pokemon in opening hand
1 Pokemon --> 116842/1000000 Pokemon drawn = **11.7%**
2 Pokemon --> 221139/1000000 Pokemon drawn = **22.1%**
3 Pokemon --> 314899/1000000 Pokemon drawn = **31.5%**
4 Pokemon --> 400417/1000000 Pokemon drawn = **40%**

**This adheres to the math!**
**P(At least 1 Pokemon in hand) = 1 - P(No Pokemon in hand)**

1. One Pokemon in deck --> P(No Pokemon) = (59 C 7) / (60 C 7) = .883
   P(at least 1 Pokemon) = 1 - .883 = .117 = **11.7%**

2. Two Pokemon in deck --> P(No Pokemon) = (58 C 7) / (60 C 7) = .779
   P(At least 1 Pokemon) = 1 - .779 = .221 = **22.1%**

3. Three Pokemon in deck --> P(No Pokemon) = (57 C 7) / (60 C 7) = 264,385,836 / 386,206,920 = .685
   P(At least 1 Pokemon) = 1 - .685 = .315 = **31.5%**

4. Three Pokemon in deck --> P(No Pokemon) = (56 C 7) / (60 C 7) = 231,917,400 / 386,206,920 = .60
   P(At least 1 Pokemon) = 1 - .60 = .40 = **40%**



## Experiment Two: Rare Candies in prize hand ("bricked" hand)

1 Candy --> 99472/1000000 Candies drawn = .0994 = **10%**
2 Candy --> 191535/1000000 Candies drawn = **19.2%**
3 Candy --> 276003/1000000 Candies drawn = **27.6%**
4 Candy --> 351390/1000000 Candies drawn = **35.1%**

**The concept is the same:**
**P(At least 1 Candy in hand) = 1 - P(No Candies in hand)**
**Choose 6 in each step instead of 7 in each formula:**

1. One Candy in deck --> P(No Candies) = (59 C 6) / (60 C 6) = 45,057,474 / 50,063,860 = .90
   P(at least 1 Candy) = 1 - .90 = .10 = **10%**

2. Two Candy in deck --> P(No Candies) = (58 C 6) / (60 C 6) = 40,475,358 / 50,063,860 = .808
   P(At least 1 Candy) = 1 - .808 = .192 = **19.2%**

3. Three Candy in deck --> P(No Candies) = (57 C 6) / (60 C 6) = 36,288,252 / 50,063,860 = .725
   P(At least 1 Candy) = 1 - .725 = .275 = **~27.6%**

4. Three Candy in deck --> P(No Candies) = (56 C 6) / (60 C 6) = 32,468,436 / 50,063,860 = .649
   P(At least 1 Candy) = 1 - .649 = .351 = **35.1%**

## Experiment Three: How many Rare Candies?

**1 Rare Candy in prize hand:**
Trials with 0 Rare Candies: 5649870
Trials with 1 Rare Candies: 350130
Trials with 2 Rare Candies: 0
Trials with 3 Rare Candies: 0
Trials with 4 Rare Candies: 0

**2 Rare Candies in prize hand:**
Trials with 0 Rare Candies: 5321524
Trials with 1 Rare Candies: 658545
Trials with 2 Rare Candies: 19931
Trials with 3 Rare Candies: 0
Trials with 4 Rare Candies: 0

**3 Rare Candies in prize hand:**
Trials with 0 Rare Candies: 5008591
Trials with 1 Rare Candies: 933664
Trials with 2 Rare Candies: 56717
Trials with 3 Rare Candies: 1028
Trials with 4 Rare Candies: 0

**4 Rare Candies in prize hand:**
Trials with 0 Rare Candies: 4713436
Trials with 1 Rare Candies: 1176113
Trials with 2 Rare Candies: 106625
Trials with 3 Rare Candies: 3791
Trials with 4 Rare Candies: 35

