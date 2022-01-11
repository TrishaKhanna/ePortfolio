package ePortfolio;

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
