## StatsLibrary

This program contains all of the relevant formulas from textbook sections 1.0 - 3.5
plus some relevant extras like median, mode and set operations.

There is a main method and a JUnit tester. Both run the same tests, but I wanted to
try working with JUnit. <br><br> I used JUnit Jupiter on Eclipse, and it put the JARs there for me.
One of my tests, the one for binomial distribution, fails. I am not sure why. I tried fixing it but was unable. It says my expected is .31250 and my actual is .3125. I think it may have something to do with the BigDecimal I used. It is interesting that the two numbers are the same, and JUnit/Eclipse did not give me a red error message; it was blue instead.


