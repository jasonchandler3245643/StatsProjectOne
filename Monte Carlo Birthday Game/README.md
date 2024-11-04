# Monte Carlo Birthday Game Description:

This program uses Monte Carlo simulation to calculate
the probability that at least two people in an arbitrary group size
share the same birthday. Passing an int through the BirthdayGame constructor  
picks the group size. <br>

The program plots the data in excel. <br>
I used Apache poi to make the first column the trial number
and the second column the probability (in decimal form)
that at least two share the same bday. I used an array to track 
changs in the number of simulation wins. I divided that number by 
the simulation number (the row number) to get the probability.<br>


As expected, the program produces that the odds two people 
share the same birthday in a group of 23 is ~.50 <br>
The unintuitive math explanation: P(at least one match) = 1 - P(0 matches),
P(0 matches) = (365/365) * (364/365) * (363/365) * . . . * (343/365) = ~.4927
Therefore, P(at least one match) = 1 - .4927 = .5073 = ~ 50%<br>

I manually graphed the data into a scatterplot to 
visualize the probablity getting closer to the expected
value as the number of trials increased. 

## File Information

**Java files:**
1. **BirthdayGame** class "plays the game" and runs the simulations
2. **Person** class holds a birthday as an int
3. **PlotDataInExcel** gets the data and puts it into excel
4. **TestBirthdayGame** contains the main, testing method.
<br>

**Other (Results):** <br>
5. **Birthday Data.xlsx** contains the data from 100,000 trials of a group size of 23. <br>
6. **Monte Birthday Output.jpg** is a screenshot of my Eclipse output (not the same trial as excel plots)<br><br>

**Relevant JAR Files:**
I used Apache POI to plot my data in excel, but I struggled figuring out which
JARs to add. I just followed the errors, adding what they said I was missing to my classpath until they stopped
and my it properly plotted the data. 
