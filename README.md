©2015 JPMorgan Chase & Co Unauthorized reproduction or distribution of all or any of this material is strictly prohibited
Example Assignment – Super Simple Stock Market
Requirements
1. Provide working source code that will :-
a. For a given stock,
i. Given any price as input, calculate the dividend yield
ii. Given any price as input, calculate the P/E Ratio
iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes
b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks
Constraints & Notes
1. Written in one of these languages:
 Java, C#, C++, Python
2. No database or GUI is required, all data need only be held in memory
3. No prior knowledge of stock markets or trading is required – all formulas are provided below.
Table1. Sample data from the Global Beverage Corporation Exchange
Stock Symbol Type Last Dividend Fixed Dividend Par Value
TEA
Common
0
100
POP
Common
8
100
ALE
Common
23
60
GIN
Preferred
8
2%
100
JOE
Common
13
250
All number values in pennies
Table 2. Formula Common Preferred Dividend Yield 𝐿𝑎𝑠𝑡 𝐷𝑖𝑣𝑖𝑑𝑒𝑛𝑑𝑃𝑟𝑖𝑐𝑒 𝐹𝑖𝑥𝑒𝑑 𝐷𝑖𝑣𝑖𝑑𝑒𝑛𝑑 .𝑃𝑎𝑟 𝑉𝑎𝑙𝑢𝑒𝑃𝑟𝑖𝑐𝑒 P/E Ratio
𝑃𝑟𝑖𝑐𝑒𝐷𝑖𝑣𝑖𝑑𝑒𝑛𝑑 Geometric Mean √𝑝1𝑝2𝑝3…𝑝𝑛𝑛 Volume Weighted Stock Price
Σ 𝑇𝑟𝑎𝑑𝑒𝑑 𝑃𝑟𝑖𝑐𝑒𝑖×𝑄𝑢𝑎𝑛𝑡𝑖𝑡𝑦𝑖𝑖Σ𝑄𝑢𝑎𝑛𝑡𝑖𝑡𝑦𝑖𝑖
V1.5
