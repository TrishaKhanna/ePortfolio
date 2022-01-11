package ePortfolio;

// Sub Class: STOCKS
public class Stock extends Investment
{
    public Stock(String symbol, String name, int quantity, float price, float bookValue)
    {
    	super(symbol, name, quantity, price, bookValue);
    }

    // Convert arrayList to String
    public String toString()
    {
        super.toString();
        return ("Type = \"Stock\"" + "\n" + "Symbol = " + "\"" + getSymbol() + "\"" + "\n" + "Name = " + "\"" + getName() + "\"" + "\n" + "Quantity = " + "\"" + getQuantity() + "\"" + "\n" + "Price = " + "\"" + getPrice() + "\"" + "\n" + "BookValue = " + "\"" + getsomeBookValue() + "\"" + "\n");
    }

	//Get Book Value
    public float getBookval()
    {
        float commission = 9.99f;

        float result = getPrice() * getQuantity() + commission;

        return result;
    }

    // Get (get)Gain
    @Override
    public float getGain()
    {
        float commission = 9.99f;

        float gain = 0.0f;
        gain = getQuantity() * getPrice() - commission - getsomeBookValue();

        return gain;
    }

    // Calculate Payment Received
    @Override
    public float getPaymentreceived(int quantity, float price)
    {
        float commission = 9.99f;

        float result = 0.0f;
        result = quantity * price - commission;

        return result;
    }
}