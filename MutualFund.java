package ePortfolio;

// Sub Class: STOCKS
public class MutualFund extends Investment
{
	public MutualFund(String symbol, String name, int quantity, float price, float bookValue)
    {
    	super(symbol, name, quantity, price, bookValue);
    }

    // Convert arrayList to String
    public String toString()
    {
        super.toString();
        return ("Type = \"MutualFund\"" + "\n" + "Symbol = " + "\"" + getSymbol() + "\"" +"\n" + "Name = " + "\"" + getName() + "\"" + "\n" + "Quantity = " + "\"" + getQuantity() + "\"" + "\n" + "Price = " + "\"" + getPrice() + "\"" + "\n" + "BookValue = " + "\"" + getsomeBookValue() + "\"" + "\n");
    }

    //Get Book Value
    public float getBookval()
    {
    	float result = getPrice() * getQuantity();

        return result;
    }

    // Get (get)Gain
    @Override
    public float getGain()
    {
        float redemptionFee = 45.00f;

        float gain = 0.0f;

        gain = (getQuantity() * getPrice() - redemptionFee) - getsomeBookValue();

        return gain;
    }

    // Calculate Payment Received
    @Override
    public float getPaymentreceived(int quantity, float price)
    {
        float redemptionFee = 45.00f;

        float result = 0.0f;
        result = quantity * price - redemptionFee;

        return result;
    }
}