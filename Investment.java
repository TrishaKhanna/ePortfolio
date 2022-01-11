package ePortfolio;

/* 
  SIMILARITIES b/w STOCKS + MUTUAL FUNDS:
- **********Same constructor**********
- **********Same toString() Method**********
- **********Same getSymbol() Method**********
- **********Same setQuantity() Method**********
- **********Same getQuantity() Method**********
- **********Same setPrice() Method**********
- **********Same setBookvalue() Method**********
- **********Same getSellBookValue() Method**********
- **********Same getsomeBookValue() Method**********
*/


/* 
  DIFFERENCES b/w STOCKS + MUTUAL FUNDS:
  - **********different getBookval() Method**********
  - **********different getGain() Method**********
  - **********different getPaymentreceived() Method**********
*/


 /*
  QUESTIONS:
  - DONE -- Do we still have to call the Portfolio class Portfolio, if so, how do we run our files with the new Investment Super Class? --Can do it the SAME WAY AS THE LAST TIME; ePortfolio.Portfolio

  - DONE -- How to access different getPaymentreceievd methods from STOCKS/MUTUAL FUNDS since the formula is diff for stocks, mutual funds, however,
    both are being stored in the same arraylist, investList? -- NO NEED!!

  - DONE -- How to apply DIFFERENT getGain() formulae if the stocks and mutual funds are being stored in the same arraylist, investList? -- NO NEED!

  - DONE -- GET RID OF DOUBLE FN IN UPDATE

  - DONE -- Do we have to include the "" in the input file we load content from?

  - DONE -- Can I split using \n?

  - When do we add the loading from file and saving to file functionality? -- within do-while loop or outside of it?

  - How do we update indices for buying and selling if we're only supposed to use a hashmap for the search method?

  - How to print investment if found in hashmap?

  - How to check for symbol, price ranges since the key in the hashmap consists of the name keyword?

  - NOT PRINTING OUT FULL ARRAYLIST WHEN BUY IS CALLED?

  - PRINTING OUT 0  FOR LOAD PART?

  - HOW TO UPDATE BUY/SELL WITH HASHMAP?
 */

// Super Class: INVESTMENT
public class Investment
{
	private String symbol;
    private String name; 
    private int quantity; 
    private float price;
    private float bookValue;
    private float commission = 9.99f;

    public Investment(String symbol, String name, int quantity, float price, float bookValue)
    {
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }

    // Convert arrayList to String
    /*public String toString()
    {
    	int i;
    	if(Investment.get(i) instanceof Stock)
    	{
    		System.out.println("type = stock");
    	}

    	if(Investment.get(i) instanceof MutualFund)
    	{
    		System.out.println("type = mutualfund");
    	}

    	super.toString();

        return ("Symbol: " + this.symbol + "\n" + "Name: " + this.name + "\n" + "Quantity: " + this.quantity + "\n" + "Price: " + this.price + "\n" + "BookValue: " + this.bookValue + "\n");
    }*/

    // Get Symbol
    public String getSymbol() 
    {
        return this.symbol;
    }

    // Get Name
    public String getName() 
    {
        return this.name;
    }

    // Set Quantity
    public void setQuantity(int newQuantity) 
    {
        this.quantity = newQuantity;
    }

    // Get Quantity
    public int getQuantity()
    {
        return this.quantity;
    }

    // Get Price
    public float getPrice()
    {
        return this.price;
    }

    // Set Price
    public void setPrice(float newPrice) 
    {
        this.price = newPrice;
    }

    // Set BookValue
    public void setBookvalue(float newBookvalue) 
    {
        this.bookValue += newBookvalue;
    }

    // Get Sell BookValue
    public float getSellBookValue(int quantity2)
    {
        float finalVal = 0.0f;

        finalVal = ((float)(this.bookValue) * (((float)(this.quantity) - (float)(quantity2))/(float)(this.quantity)));

        this.quantity = this.quantity - quantity2;
        this.bookValue = finalVal;

        System.out.println("finalVal = " + finalVal);

        return finalVal;
    }

    public float getsomeBookValue()
    {
        return this.bookValue;
    }

    // Calculate Payment Received
    public float getPaymentreceived(int quantity, float price)
    {
        // Need to return something because its a float; can't leave it blank
        return 0;
    }

     public float getGain()
     {
     	return 0;
     }
}