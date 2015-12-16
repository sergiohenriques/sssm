
#Super Simple Stock Market

##Requirements 
1. Provide working source code that will:

  a. For a given stock, 
  
      i. Given any price as input, calculate the dividend yield 
    
      ii. Given any price as input, calculate the P/E Ratio 
    
      iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price 
    
      iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes 
    
  b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks 


##Constraints & Notes 
1. Written in one of these languages: 
   Java, C#, C++, Python 
2. No database or GUI is required, all data need only be held in memory 
3. No prior knowledge of stock markets or trading is required – all formulas are provided below. 

##Solution

For this exercise it was used a basic layered architechture approach.

![Alt text](https://github.com/sergiohenriques/sssm/blob/master/src/main/resources/architecture.PNG)

This application has been done developed using a TDD approach. The whole suite of tests can be run from AllTests.java

All required features were implemented in the service layer with access to the model objects. 

Since there was no need to have a connection to a database there was created two singletons to keep all the data in memory for stocks and trades.

The point of entry on this application is the main class SSSM.java, this has the single purpose of showing a possible implementation to access the service layer. Because all functionalities were already tested by the suite of tests, the application only runs to add the mentioned example stocks and a few trades.

It is expectedt that the applications is going to be access through the available service layer interfaces.



