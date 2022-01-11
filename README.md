# ePortfolio
**Digital Investment Portfolio**

********************************************************************
###### (1) Problem being solved
********************************************************************
  This ePortfolio banking system allows the user to:
* a) load investments from a text file that is inputted at the command line
* b) buy - investments of 2 types; stocks and mutual funds
* c) sell - investments of 2 types; stocks and mutual funds
* d) calculate gains - after buying and or selling certain stocks and mutual funds
* e) update - update values for prices of all stocks and mutual funds according to the user's input
* f) Save all the newly created investments from running the program into the original user-inputted text file

********************************************************************
###### (2) How can the user build and test your program
********************************************************************
- the folder can be run using the following commands:
  javac *.java
  java ePortfolio.Portfolio

********************************************************************
###### (3) How is the program tested?
********************************************************************
- Testing Plan - Example test scenario
-> For STOCKS:
* (a) Buy: Price = 110.08, Quantity = 500 therefore bookValue = $55,049.99
* (b) Update: Price update = 142.23
* (c) Gain: Gain/share = $16,055.02
* (d) Sell: 200 shares of this stock at $142.23 therefore payment received = $28,436.01, bookValue =  $33,029.9

-> For MUTUAL FUNDS:
* (a) Buy: 450 units of SSETX at $53.26 per unit, therefore bookValue =  $23,967.00.
* (b) Update: Price Update = 42.21
* (c) Gain: Gain/share = –$5,017.50
* (d) Sell:  150 units of this fund at $42.21 per unit, therefore payment received = $6,286.50, bookValue = $15,978.00

-> Additional testing factors:
* (a) The Load section of this assignment replaces the double-inverted commas used in the text file to read the contents of the file correctly
* (b) It also makes sure that the user always enters an integer variable, a float variable, a String, in all the places that inputs are expected in.

