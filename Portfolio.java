package ePortfolio;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.util.Iterator;

public class Portfolio
{
    public static void main(String[] args)
    {   
        // OPTION (1):
        String userInput;
        int sorM = 0;
        String symbol; // Scan in user's Symbol input - STOCKS
        String name = ""; // Scan in user's Name input - STOCKS
        int quantity = 0; // Scan in user's Qty input - STOCKS
        float price = 0.0f; // Scan in user's Price input - STOCKS
        float bookValue = 0.0f;

        // If stock already exists
        float sum = 0.0f;
        float bkVAL = 0.0f;

        String symbolMF; // Scan in user's Symbol input - MUTUAL FUNDS
        String nameMF = ""; // Scan in user's Name input - MUTUAL FUNDS
        int quantityMF = 0; // Scan in user's Qty input - MUTUAL FUNDS
        float priceMF = 0.0f; // Scan in user's Price input - MUTUAL FUNDS

        float sumMF = 0.0f;
        float bkVALMF = 0.0f;

        // OPTION (2)
        String symbolSell = "";
        int quantitySell = 0;
        float priceSell = 0.0f; 

        // OPTION (3):
        String symbolUpdate = "";
        float priceUpdate = 0.0f;

        // OPTION (4)
        String symCheck;
        String nameCheck = "";
        String priceCheck;

        File f = null;
        Scanner file1 = null;
        String[] array = {};
        String classifyType = "";
        String typeAttribute = "";
        String classifySymbol = "";
        String symbolAttribute = "";
        String classifyName = "";
        String nameAttribute = "";
        String classifyQuantity = "";
        Integer quantityAttribute = 0;
        String classifyPrice = "";
        Float priceAttribute = 0.0f;
        String classifybkVal = "";
        Float bkValAttribute = 0.0f;

        ArrayList <Investment> investList = new ArrayList <Investment>();

        System.out.println("Loading Investment Information from an Input File.");

        try
        {
            f = new File(args[0]);
            file1 = new Scanner(f);
        }

        catch(Exception e)
        {
            System.out.println(e);
        }

        boolean checkInput = true;
        int x = 0;
        while(checkInput)
        {
            String content;
            try 
            {
                content = file1.nextLine();
            } 

            catch (Exception e) 
            {
                content = "";
                checkInput = false;
            }

            // Split atring only if line's 1st character != "\n"
            if(content.length() != 0)
            {
                array = content.split("[ ]+"); // Split string only based on whitespace
                

                if(array[0].equalsIgnoreCase("type"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifyType = array[0];
                    typeAttribute = array[2];
                }

                if(array[0].equalsIgnoreCase("symbol"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifySymbol = array[0];
                    symbolAttribute = array[2];
                }

                if(array[0].equalsIgnoreCase("name"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifyName = array[0];
                    nameAttribute = array[2];
                }

                if(array[0].equalsIgnoreCase("quantity"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifyQuantity = array[0];
                    System.out.println("Array[2]: " + array[2]);
                    quantityAttribute = Integer.valueOf(array[2]);
                }

                if(array[0].equalsIgnoreCase("price"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifyPrice = array[0];
                    priceAttribute = Float.valueOf(array[2]).floatValue();
                }

                if(array[0].equalsIgnoreCase("bookValue"))
                {
                    array[2] = array[2].replace("\"", "");
                    classifybkVal = array[0];
                    bkValAttribute = Float.valueOf(array[2]).floatValue();
                }

            } 

            else
            {
                if(typeAttribute.equalsIgnoreCase("stock"))
                {
                    Stock stockInvestment = new Stock(symbolAttribute, nameAttribute, quantityAttribute, priceAttribute, bkValAttribute);
                    investList.add(stockInvestment);
                }

                else if(typeAttribute.equalsIgnoreCase("mutualfund"))
                {
                    MutualFund mutualfundInvestment = new MutualFund(symbolAttribute, nameAttribute, quantityAttribute, priceAttribute, bkValAttribute);
                    investList.add(mutualfundInvestment);
                }

                System.out.println(investList.size());
            }
        }



        // OUTSIDE OF WHILE LOOP
        for (int i = 0; i < investList.size();i++) 
        {
            System.out.println("Print investments after loading approriately.");               
            System.out.println(investList.get(i));
        }

        // Print out menu options
        do
        {
            bkVAL = 0.0f;

            System.out.println("************************************************");
            System.out.println("Please select one of the following menu options: ");
            System.out.println("************************************************");
            System.out.println("(1) buy: own a new investment or add more quantity to an existing investment.");
            System.out.println("(2) sell: reduce some quantity of an existing investment.");
            System.out.println("(3) update: refresh the prices of all existing investments.");
            System.out.println("(4) getGain: compute the total gain of the portfolio by accumulating the gains of all individual investments.");
            System.out.println("(5) search: find all investments that match a search request and display all attributes of these investments. ");

            Scanner uInput = new Scanner(System.in); // Scan user's menu option input

            // Stock Scanners
            Scanner uSymbol = new Scanner(System.in); //Scan in user's Symbol input
            Scanner uName = new Scanner(System.in); //Scan in user's Name input
            Scanner uQty = new Scanner(System.in); //Scan in user's Quantity input
            Scanner uPrice  = new Scanner(System.in); //Scan in user's Price input

            // Mutual Funds Scanners
            Scanner mfSymbol = new Scanner(System.in); //Scan in user's Symbol input
            Scanner mfName = new Scanner(System.in); //Scan in user's Name input
            Scanner mfQty = new Scanner(System.in); //Scan in user's Quantity input
            Scanner mfPrice  = new Scanner(System.in); //Scan in user's Price input

            // OPTION (2) - Sell Scanner
            Scanner symSell = new Scanner(System.in);
            Scanner qtySell = new Scanner(System.in);
            Scanner priSell = new Scanner(System.in);

            // OPTION (3) - Symbol check Scanner
            Scanner symUpdate = new Scanner(System.in);
            Scanner priUpdate = new Scanner(System.in);

            // OPTION (4) -  (3) User Input Scanner
            Scanner checkSym = new Scanner(System.in); // Scan in user's symbol Check
            Scanner checkKeyword = new Scanner(System.in); // Scan in user's keyword Check
            Scanner checkPrice = new Scanner(System.in); // Scan in user's price Check

            while(true)
            {
                System.out.println("Enter a MENU OPTION: ");
                userInput = uInput.nextLine();

                if(userInput.isEmpty())
                {
                    System.out.println("Please enter a VALID MENU OPTION:) : ");
                }

                else
                {
                    break;
                }
            }


            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /***************************************************OPTION 1**************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/


            // OPTION 1: BUY
            if(userInput.equals("1"))
            {
                System.out.println("Choose the type of investment you would like to make today: ");
                System.out.println("Enter (1) for stocks or (2) for mutual funds: ");

                while(true)
                {
                    Scanner choose = new Scanner(System.in);
                    if(choose.hasNextInt())
                    {
                        sorM = choose.nextInt();
                        break;
                    }

                    else
                    {
                        System.out.println("Option entered is not an integer");
                        System.out.println("Enter (1) for stocks or (2) for mutual funds: ");
                    }
                }

                // Enter type of investment
                // User enters STOCK
                if(sorM == 1)
                {
                    boolean check = false;

                    System.out.println("You have chosen to invest in STOCKS!");

                    while(true)
                    {
                        System.out.println("Enter a STOCK Symbol: ");
                        symbol = uSymbol.nextLine();

                        if(symbol.isEmpty())
                        {
                            System.out.println("Please enter a VALID STOCK Symbol: ");
                        }

                        else
                        {
                            break;
                        }
                    }

                    for(int i = 0; i < investList.size(); i++)
                    {
                        if(symbol.equalsIgnoreCase(investList.get(i).getSymbol()))
                        {
                            check = true;

                            // Ask user to input stock QTY
                            System.out.println("Enter a STOCK Qty: ");

                            if(uQty.hasNextInt())
                            {
                                quantity = uQty.nextInt();
                            }

                            else
                            {
                                while(!uQty.hasNextInt())
                                {
                                    System.out.println("Please enter a VALID STOCK Quantity: ");
                                    uQty.next();
                                }
                                quantity = uQty.nextInt();
                            }

                            // Ask user to input stock PRICE
                            System.out.println("Enter a STOCK Price: ");
                            if(uPrice.hasNextFloat())
                            {
                                price = uPrice.nextFloat();
                            }

                            else
                            {
                                while(!uPrice.hasNextFloat())
                                {
                                    System.out.println("Please enter a VALID STOCK Price: ");
                                    uPrice.next();
                                }

                                price = uPrice.nextFloat();
                            }

                            // Save user inputs into Stock Object
                            investList.get(i).setQuantity(quantity + investList.get(i).getQuantity());
                            investList.get(i).setPrice(price);
                            bkVAL = (quantity * price) + 9.99f;
                            investList.get(i).setBookvalue(bkVAL);
                            System.out.println(investList.get(i).toString());
                        }
                    }

                    if(check == false)
                    {
                        // Ask user to input stock NAME
                        while(true)
                        {
                            System.out.println("Enter a STOCK Name: ");
                            name = uName.nextLine();

                            if(name.isEmpty())
                            {
                                System.out.println("Please enter a VALID STOCK Name: ");
                            }

                            else
                            {
                                break;
                            }
                        }

                        // Ask user to input stock QTY
                        System.out.println("Enter a STOCK Qty: ");
                        if(uQty.hasNextInt())
                        {
                            quantity = uQty.nextInt();
                        }

                        else
                        {
                            while(!uQty.hasNextInt())
                            {
                                System.out.println("Please enter a VALID STOCK Quantity:");
                                uQty.next();
                            }
                            quantity = uQty.nextInt();
                        }

                        // Ask user to input stock PRICE
                        System.out.println("Enter a STOCK Price: ");
                        if(uPrice.hasNextFloat())
                        {
                            price = uPrice.nextFloat();
                        }

                        else
                        {
                            while(!uPrice.hasNextFloat())
                            {
                                System.out.println("Please enter a VALID STOCK Price:");
                                uPrice.next();
                            }

                            price = uPrice.nextFloat();
                        }

                        // Save user inputs into Stock Object
                        bkVAL = (quantity * price) + 9.99f;
                        Stock stock1 = new Stock(symbol, name, quantity, price, bkVAL);

                        // Add stock1 object to arrayList
                        investList.add(stock1);

                        int i = 0;

                        System.out.println(investList.get(i).toString());
                    }
                }

                /*************************************************************************************************************/
                /*************************************************************************************************************/
                /*************************************************************************************************************/
                /*************************************************************************************************************/

                // User enters MUTUAL FUNDS
                if(sorM == 2)
                {
                    boolean check = false;

                    System.out.println("You have chosen to invest in MUTUAL FUNDS!");

                    while(true)
                    {
                        System.out.println("Enter a MUTUAL FUND Symbol: ");
                        symbolMF = mfSymbol.nextLine();

                        if(symbolMF.isEmpty())
                        {
                            System.out.println("Please enter a VALID MUTUAL FUND Symbol:) : ");
                        }

                        else
                        {
                            break;
                        }
                    }

                    for(int i = 0; i < investList.size(); i++)
                    {
                        if(symbolMF.equalsIgnoreCase(investList.get(i).getSymbol()))
                        {
                            check = true;

                            // Ask user to input stock QTY
                            System.out.println("Enter a MUTUAL FUND Qty: ");

                            if(mfQty.hasNextInt())
                            {
                                quantityMF = mfQty.nextInt();
                            }

                            else
                            {
                                while(!mfQty.hasNextInt())
                                {
                                    System.out.println("Please enter a VALID MUTUAL FUND Quantity:) :");
                                    mfQty.next();
                                }
                                quantityMF = mfQty.nextInt();
                            }

                            // Ask user to input stock PRICE
                            System.out.println("Enter a MUTUAL FUND Price: ");

                            if(mfPrice.hasNextFloat())
                            {
                                priceMF = mfPrice.nextFloat();
                            }

                            else
                            {
                                while(!mfPrice.hasNextFloat())
                                {
                                    System.out.println("Please enter a VALID MUTUAL FUND Price:) :");
                                    mfPrice.next();
                                }

                                priceMF = mfPrice.nextFloat();
                            }

                            // Save user inputs into Stock Object
                            investList.get(i).setQuantity(quantityMF + investList.get(i).getQuantity());
                            investList.get(i).setPrice(priceMF);
                            bkVALMF = (quantityMF * priceMF);
                            investList.get(i).setBookvalue(bkVALMF);
                            System.out.println(investList.get(i).toString());
                        }
                    }

                    if(check == false)
                    {

                        // Ask user to input stock NAME
                        while(true)
                        {
                            System.out.println("Enter a MUTUAL FUND Name: ");
                            nameMF = mfName.nextLine();

                            if(nameMF.isEmpty())
                            {
                                System.out.println("Please enter a VALID STOCK Name:) : ");
                            }

                            else
                            {
                                break;
                            }
                        }

                        // Ask user to input stock QTY
                        System.out.println("Enter a MUTUAL FUND Qty: ");
                        if(mfQty.hasNextInt())
                        {
                            quantityMF = mfQty.nextInt();
                        }

                        else
                        {
                            while(!mfQty.hasNextInt())
                            {
                                System.out.println("Please enter a VALID MUTUAL FUND Quantity:) :");
                                mfQty.next();
                            }
                            quantityMF = mfQty.nextInt();
                        }

                        // Ask user to input stock PRICE
                        System.out.println("Enter a MUTUAL FUND Price: ");
                        if(mfPrice.hasNextFloat())
                        {
                            priceMF = mfPrice.nextFloat();
                        }

                        else
                        {
                            while(!mfPrice.hasNextFloat())
                            {
                                System.out.println("Please enter a VALID MUTUAL FUND Price:) :");
                                mfPrice.next();
                            }

                            priceMF = mfPrice.nextFloat();
                        }

                        // Save user inputs into Stock Object
                        bkVALMF = (quantityMF * priceMF);
                        MutualFund mutualFund1 = new MutualFund(symbolMF, nameMF, quantityMF, priceMF, bkVALMF);

                        // Add stock1 object to arrayList
                        investList.add(mutualFund1);
                        int i = 0;
                        System.out.println(investList.get(i).toString());
                    }
                }
            }

            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /***************************************************OPTION 2**************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/

            // OPTION 2: SELL
            if(userInput.equals("2"))
            {
                boolean check = false;

                while(true)
                {
                    System.out.println("Enter a INVESTMENT Symbol: ");
                    symbolSell = symSell.nextLine();

                    if(symbolSell.isEmpty())
                    {
                        System.out.println("Please enter a INVESTMENT Symbol:) : ");
                    }

                    else
                    {
                        break;
                    }
                }

                // Check for STOCKs + MUTUAL FUNDSs
                for(int i = 0; i < investList.size(); i++)
                {
                    if(symbolSell.equals(investList.get(i).getSymbol()))
                    {
                        check = true;

                        System.out.println("Enter the quantity you would like to sell: ");
                        if(qtySell.hasNextInt())
                        {
                            quantitySell = qtySell.nextInt();
                        }

                        else
                        {
                            while(!qtySell.hasNextInt())
                            {
                                System.out.println("Please enter a VALID SELLING Quantity:) :");
                                qtySell.next();
                            }
                            quantitySell = qtySell.nextInt();

                            // Check to make sure that the quantitySell !> quantity available to be sold
                            while((quantitySell > investList.get(i).getQuantity()))
                            {
                                System.out.println("Please enter a VALID SELLING Quantity:) :");
                            }
                        }

                        System.out.println("Enter the price you would like to sell: ");
                        if(priSell.hasNextFloat())
                        {
                            priceSell = priSell.nextFloat();
                        }

                        else
                        {
                            while(!priSell.hasNextFloat())
                            {
                                System.out.println("Please enter a VALID Price:) :");
                                priSell.next();
                            }

                            priceSell = priSell.nextFloat();
                        }

                        System.out.println("SELL! (2)");

                        System.out.println(investList.get(i));

                        System.out.println("The payment received is: " + investList.get(i).getPaymentreceived(quantitySell, priceSell));

                        System.out.println(investList.get(i).getsomeBookValue());

                        if(investList.get(i).getsomeBookValue() == 0)
                        {
                            investList.remove(i); // Remove the investment from the arraylist if the quantity being sold makes the entire leftover quantity of the investment = 0
                            System.out.println("This investment was removed from the arraylist because the quantity leftover = 0");
                        }

                        else
                        {
                            System.out.println("The updated book value is: " + investList.get(i).getSellBookValue(quantitySell));
                        }

                        //System.out.println("The updated book value is: " + investList.get(i).getSellBookValue(quantitySell));
                    }
                }


                if((check == false))
                {
                    System.out.println("This INVESTMENT does not exist and cannot be sold yet.");
                }

            }

            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /***************************************************OPTION 3**************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/

            // OPTION 3: UPDATE
            if(userInput.equals("3"))
            {   
                // Check for STOCK
                for(int i = 0; i < investList.size(); i++)
                {
                    String temp;
                    System.out.println(investList.get(i).toString());
                    System.out.println("Enter a price to update: ");
                    temp = priUpdate.nextLine();

                    if(temp.isEmpty())
                    {
                        System.out.println("Price NOT entered");
                    }

                    else
                    {
                        priceUpdate = Float.parseFloat(temp);

                        // Update price
                        investList.get(i).setPrice(priceUpdate);
                    }
                }
            }

            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /***************************************************OPTION 4**************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/
            /*************************************************************************************************************/

            // OPTION 4: GET GAIN
            if(userInput.equals("4"))
            {
                float investGain = 0.0f;
                float totalGain = 0.0f;
 
                for(int i = 0; i < investList.size(); i++)
                {
                    if(investList.get(i) instanceof Stock)
                    {
                        System.out.println("STOCK #" + i);
                    }

                    if(investList.get(i) instanceof MutualFund)
                    {
                        System.out.println("MUTUAL FUND #" + i);
                    }

                    //System.out.println("INVESTMENT #" + i);
                    System.out.println(investList.get(i).toString());
                    System.out.println("\n");
                }

                // 1. Calculating the total gain for the Stock ArrayList
                for(int i = 0; i < investList.size(); i++)
                {
                    investGain = investGain + investList.get(i).getGain();
                    System.out.println("The total gain from STOCKS is: " + investGain);
                }

                totalGain = investGain;
                System.out.println("The final total gain from all the INVESTMENTS combined is: " + totalGain);
            }

        }while(true);
    }
}
