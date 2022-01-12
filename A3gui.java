package ePortfolio;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A3gui
{
	public static void main(String[] args)
	{
		GUItest obj = new GUItest();
	}
}

class GUItest extends JFrame
{
	// MAIN MENU
	JPanel mainPanel;
	JMenu menu;
	JMenuBar bar;
	JMenuItem buy;
	JMenuItem sell;
	JMenuItem update;
	JMenuItem getGain;
	JMenuItem search;
	JLabel choose;
	JLabel welcome;

	// BUY
	JPanel panel1;
	JPanel subPanel1;
	JPanel subsubPanel1;
	JPanel subPanel2;
	JLabel l1;
	JLabel buyType;
	JLabel buySymbol;
	JLabel buyName;
	JLabel buyQuantity;
	JLabel buyPrice;
	JTextField buySymbolInput;
	JComboBox <Object>combobox = new JComboBox<>(new Object[] {"Stock", "MutualFund"});
	JTextField buyNameInput;
	JTextField buyQtyInput;
	JTextField buyPriceInput;
	JButton buyReset;
	JButton buyButton;
	JLabel empty1;
	JLabel empty2;
	JLabel empty3;
	JLabel messagesBuy;
	JTextArea buyMessageDisplay;
	JScrollPane buyScroll;

	// SELL
	JPanel panel2;
	JPanel subPanel3;
	JPanel subsubPanel3;
	JPanel subPanel4;
	JLabel l2;
	JLabel sellSymbol;
	JLabel sellQty;
	JLabel sellPrice;
	JTextField sellSymbolInput;
	JTextField sellQtyInput;
	JTextField sellPriceInput;
	JButton sellReset;
	JButton sellButton;
	JLabel emptySell;
	JLabel messagesSell;
	JTextArea sellMessageDisplay;
	JScrollPane sellScroll;

	// UPDATE
	JPanel panel3;
	JPanel subPanel5;
	JPanel subsubPanel5;
	JPanel subPanel6;
	JLabel l3;
	JLabel updateSymbol;
	JLabel updateName;
	JLabel updatePrice;
	JTextField updateSymbolInput;
	JTextField updateNameInput;
	JTextField updatePriceInput;
	JButton prev;
	JButton next;
	JButton save;
	JLabel messagesUpdate;
	JTextArea updateMessageDisplay;
	JScrollPane updateScroll;

	// GET GAIN
	JPanel panel4;
	JPanel subPanel7;
	JPanel subsubPanel7;
	JPanel subPanel8;
	JLabel l4;
	JLabel totalGain;
	JTextArea totalGainOuput;
	JLabel emptyGetGain;
	JLabel messagesGetGain;
	JTextArea getGainMessageDisplay;
	JScrollPane getGainScroll;

	// SEARCH
	JPanel panel5;
	JPanel subPanel9;
	JPanel subsubPanel9;
	JPanel subPanel10;
	JLabel l5;
	JLabel searchSymbol;
	JLabel searchNameKeyword;
	JLabel searchLow;
	JLabel searchHigh;
	JTextField searchSymbolInput;
	JTextField searchKeywordInput;
	JTextField searchLPInput;
	JTextField searchHPInput;
	JLabel empty4;
	JLabel empty5;
	JButton resetSearch;
	JButton searchButton;
	JLabel messagesSearch;
	JTextArea searchMessageDisplay;
	JScrollPane searchScroll;

	// METHOD 1 - BUY
	float bkValue;

	// Declare arraylist for Investments -- STOCKS + MUTUAL FUNDS
    ArrayList<Investment> investList = new ArrayList<Investment>();

    /*********************************************
		OPTION 1 METHOD a) - BUY
	**********************************************/
	private void buyInvestment(Container parent)
	{

		System.out.println("Hi!");
		String stockORmf = (String)combobox.getSelectedItem();

		System.out.println("Stock or MF = " + stockORmf);

		String userSymInput = buySymbolInput.getText();
		String userNameInput = "";
		String userQtyInput = "";
		Integer convertQty = 0;
		String userPriceInput = "";
		Float convertPrice = 0.0f;
		float bkValue = 0.0f;
		boolean investmentExists = false;
		boolean check = false;
		boolean sorMF = false;
		int i = 0;

		buyMessageDisplay.setText("");

		if(stockORmf.equals("Stock"))
		{
			sorMF = true;

			for(i = 0; i < investList.size(); i++)
	        {
	            if(userSymInput.equalsIgnoreCase(investList.get(i).getSymbol()))
	            {
	            	System.out.println("Entering if: ");
	            	investmentExists = true;

	            	// Set Quantity for STOCK
					userQtyInput = buyQtyInput.getText();
					convertQty = Integer.parseInt(userQtyInput);
					System.out.println("UserQtyInput  = " + userQtyInput);
					System.out.println("convertQty  = " + convertQty);

					// Set Price for STOCK
					userPriceInput = buyPriceInput.getText();
					convertPrice = Float.parseFloat(userPriceInput);
					System.out.println("userPriceInput  = " + userPriceInput);
					System.out.println("convertPrice  = " + convertPrice);

					// Save user inputs into Stock Object
	                investList.get(i).setQuantity(convertQty + investList.get(i).getQuantity());
	                investList.get(i).setPrice(convertPrice);
	                bkValue = (convertQty * convertPrice) + 9.99f;
	                investList.get(i).setBookvalue(bkValue);

	                //buyMessageDisplay.append("This investment already exists so do not enter a name Input:)");
	            }
	        }

	        if(investmentExists == false)
	        {
	        	// Set Symbol for STOCK
				//userSymInput = buySymbolInput.getText();

				// Set Name for STOCK
				userNameInput = buyNameInput.getText();

				// Set Quantity for STOCK
				userQtyInput = buyQtyInput.getText();
				convertQty = Integer.parseInt(userQtyInput);
				System.out.println("UserQtyInput  = " + userQtyInput);
				System.out.println("convertQty  = " + convertQty);

				// Set Price for STOCK
				userPriceInput = buyPriceInput.getText();
				convertPrice = Float.parseFloat(userPriceInput);
				System.out.println("userPriceInput  = " + userPriceInput);
				System.out.println("convertPrice  = " + convertPrice);
	        }
		}

		if(stockORmf.equals("MutualFund"))
		{
			sorMF = false;

			for(i = 0; i < investList.size(); i++)
	        {
	            if(userSymInput.equalsIgnoreCase(investList.get(i).getSymbol()))
	            {
	            	investmentExists = true;

	            	// Set Quantity for MF
					userQtyInput = buyQtyInput.getText();
					convertQty = Integer.parseInt(userQtyInput);

					// Set Price for MF
					userPriceInput = buyPriceInput.getText();
					convertPrice = Float.parseFloat(userPriceInput);

					// Save user inputs into Stock Object
	                investList.get(i).setQuantity(convertQty + investList.get(i).getQuantity());
	                investList.get(i).setPrice(convertPrice);
	                bkValue = (convertQty * convertPrice);
	                investList.get(i).setBookvalue(bkValue);

	                //buyMessageDisplay.append("This investment already exists so do not enter a name Input:)");
	            }
	        }

	        if(investmentExists == false)
	        {
	        	// Set Symbol for MF
				//userSymInput = buySymbolInput.getText();

				// Set Name for MF
				userNameInput = buyNameInput.getText();

				// Set Quantity for MF
				userQtyInput = buyQtyInput.getText();
				convertQty = Integer.parseInt(userQtyInput);

				// Set Price for MF
				userPriceInput = buyPriceInput.getText();
				convertPrice = Float.parseFloat(userPriceInput);
	        }

		}

		if((investmentExists == false) && (userSymInput instanceof String) && (userNameInput instanceof String) && (convertQty instanceof Integer) && (convertPrice instanceof Float))
		{
			check = true;

			if(sorMF == true)
			{
				bkValue = (convertQty * convertPrice) + 9.99f;
	            Stock stock1 = new Stock(userSymInput, userNameInput, convertQty, convertPrice, bkValue);

	            // Add stock1 object to arrayList
	            investList.add(stock1);

	            buyMessageDisplay.append("BookValue = " + bkValue);
	            //int i = 0;
	            System.out.println(investList.get(i).toString());
	            //buyMessageDisplay.append("<br>" + str);
			}

			else if(sorMF == false)
			{
				bkValue = (convertQty * convertPrice);
	            MutualFund mutualFund1 = new MutualFund(userSymInput, userNameInput, convertQty, convertPrice, bkValue);

	            // Add mutualFund1 object to arrayList
	            investList.add(mutualFund1);

	            buyMessageDisplay.append("BookValue = " + bkValue);
	            //int i = 0;
	            System.out.println(investList.get(i).toString());
	            //buyMessageDisplay.append("<br>" + str);
			}
		}

		else if(investmentExists == true)
		{
			buyMessageDisplay.append("This investment already exists so do not enter a name Input:)");
		}

		else
		{
			buyMessageDisplay.append("<html>The input formats entered are wrong. <br> Kindly enter the above inputs in the correct format.");
		}
	}

	/*********************************************
			OPTION 1 METHOD b) - RESET BUY
	**********************************************/
	private void resetBuy(Container parent)
	{
		buySymbolInput.setText("");
		buyNameInput.setText("");
		buyQtyInput.setText("");
		buyPriceInput.setText("");
		buyMessageDisplay.setText("");
	}

	/*********************************************
		OPTION 2 METHOD a) - SELL
	**********************************************/
	private void sellInvestment(Container parent)
	{
		boolean check = false;
		boolean check2 = false;
		String userSymInput = "";
		String userQtyInput = "";
		Integer convertQty = 0;
		String userPriceInput = "";
		Float convertPrice = 0.0f;
		int i = 0;
		int count = 0;

		// Get Symbol for Selling
		userSymInput = sellSymbolInput.getText();


		// Check for STOCKs + MUTUAL FUNDSs
        for(i = 0; i < investList.size(); i++)
        {
            if(userSymInput.equals(investList.get(i).getSymbol()))
            {
            	check = true;
            	count++;

            	// Sell Quantity for STOCK + MF
				userQtyInput = sellQtyInput.getText();
				convertQty = Integer.parseInt(userQtyInput);

				// Selling Price for STOCK + MF
				userPriceInput = sellPriceInput.getText();
				convertPrice = Float.parseFloat(userPriceInput);

				/*if(((investList.get(i).getQuantity()) - convertQty) == 0)
				{
					investList.remove(i);
					System.out.println("This investment was removed because the qty to be sold resulted in the total qty after the sell to be set to 0.");
				}*/

				//sellMessageDisplay.setText("The updated book value is: " + investList.get(i).getSellBookValue(quantitySell));
            }
        }

        if((check == true) && (userSymInput instanceof String) && (convertQty instanceof Integer) && (convertPrice instanceof Float))
		{
			//check2 = true;
			sellMessageDisplay.append("<html>" + investList.get(i).getsomeBookValue() + "<br>The updated book value is: "+ "\n" + investList.get(i).getSellBookValue(convertQty));

			/*if(investList.get(i).getQuantity() == 0)
			{
				investList.remove(i);
				System.out.println("This investment was removed because the qty to be sold resulted in the total qty after the sell to be set to 0.");
			}*/
		}

        if(check == false)
        {
        	sellMessageDisplay.append("<html> This Investment does not exist and cannot be sold yet.");
        }

        if(!(userSymInput instanceof String) && !(convertQty instanceof Integer) && !(convertPrice instanceof Float))
		{
			sellMessageDisplay.append("<html>The input formats entered are wrong. <br> Kindly enter the above inputs in the correct format.");
		}
	}

	/*********************************************
			OPTION 2 METHOD b) - RESET SELL
	**********************************************/
	private void resetSell(Container parent)
	{
		sellSymbolInput.setText("");
		sellQtyInput.setText("");
		sellPriceInput.setText("");
		sellMessageDisplay.setText("");
	}

	public GUItest()
	{
		super("ePortfolio");
		setVisible(true);
		setSize(500, 350); // Set size of the frame
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FlowLayout f = new FlowLayout(FlowLayout.LEFT, 10, 40);

		mainPanel = new JPanel();
		mainPanel.setLayout(f);
		//mainPanel.setBackground(Color.RED);
		add(mainPanel);

		//Set the MENU
		menu = new JMenu("Commands");
		mainPanel.add(menu);
		bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(menu);

		welcome = new JLabel("Welcome to ePortfolio.");
		mainPanel.add(welcome);
		choose = new JLabel("<html>Choose a command from the Commands menu to buy or sell<br>an investment, update prices for all investments, get gain for the<br>portfolio, search for relevant investments, or quit the program.");
		mainPanel.add(choose);

		/**************************************************************/
		// BUY PANEL -- OPTION 1 !
		/**************************************************************/
		buy = new JMenuItem("Buy");
		menu.add(buy);

		GridLayout g1 = new GridLayout(2, 0, 10, 5);
		panel1 = new JPanel();
		add(panel1);
		panel1.setVisible(false);
		panel1.setLayout(g1);

		FlowLayout f1 = new FlowLayout(FlowLayout.LEFT, 20, 5);
		subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(200, 160));
		//subPanel1.setBackground(Color.RED);
		subPanel1.setLayout(f1);
		panel1.add(subPanel1);

		l1 = new JLabel("Buying an Investment                                                                                                ");
		subPanel1.add(l1);

		GridLayout g11 = new GridLayout(5, 3, 5, 5);
		subsubPanel1 = new JPanel();
		subsubPanel1.setPreferredSize(new Dimension(450, 110));
		//subsubPanel1.setBackground(Color.PINK);
		subsubPanel1.setLayout(g11);
		subPanel1.add(subsubPanel1);

		buyType = new JLabel("Type");
		subsubPanel1.add(buyType);

		subsubPanel1.add(combobox);

		buyReset = new JButton("Reset");
		buyReset.addActionListener(click -> resetBuy(subsubPanel1));
		subsubPanel1.add(buyReset);

		buySymbol = new JLabel("Symbol");
		subsubPanel1.add(buySymbol);

		buySymbolInput = new JTextField(20);
		subsubPanel1.add(buySymbolInput);

		empty1 = new JLabel("");
		subsubPanel1.add(empty1);

		buyName = new JLabel("Name");
		subsubPanel1.add(buyName);

		buyNameInput = new JTextField(20);
		subsubPanel1.add(buyNameInput);

		empty2 = new JLabel("");
		subsubPanel1.add(empty2);

		buyQuantity = new JLabel("Quantity");
		subsubPanel1.add(buyQuantity);

		buyQtyInput = new JTextField(20);
		subsubPanel1.add(buyQtyInput);

		buyButton = new JButton("Buy");
		buyButton.addActionListener(click -> buyInvestment(subsubPanel1));
		subsubPanel1.add(buyButton);

		buyPrice = new JLabel("Price");
		subsubPanel1.add(buyPrice);

		buyPriceInput = new JTextField(20);
		subsubPanel1.add(buyPriceInput);

		empty3 = new JLabel("");
		subsubPanel1.add(empty3);

		subPanel2 = new JPanel();
		subPanel2.setPreferredSize(new Dimension(200, 160));
		//subPanel2.setBackground(Color.BLUE);
		BoxLayout b1 = new BoxLayout(subPanel2, BoxLayout.PAGE_AXIS);
		panel1.add(subPanel2);

		messagesBuy = new JLabel("Messages");
		messagesBuy.setAlignmentX(Component.LEFT_ALIGNMENT);
		subPanel2.add(messagesBuy);

		buyMessageDisplay = new JTextArea(6,45);
		subPanel2.add(buyMessageDisplay);

		buyScroll = new JScrollPane(buyMessageDisplay); 
		buyScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	buyScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		subPanel2.add(buyScroll);

		ActionListener al1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				mainPanel.setVisible(false);
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		};

		buy.addActionListener(al1);

		/**************************************************************/
		// SELL PANEL -- OPTION 2 !
		/**************************************************************/
		sell = new JMenuItem("Sell");
		menu.add(sell);

		GridLayout g2 = new GridLayout(2, 0, 10, 5);
		panel2 = new JPanel();
		add(panel2);
		panel2.setVisible(false);
		panel2.setLayout(g2);

		FlowLayout f2 = new FlowLayout(FlowLayout.LEFT, 20, 5);
		subPanel3 = new JPanel();
		subPanel3.setPreferredSize(new Dimension(200, 160));
		//subPanel3.setBackground(Color.RED);
		subPanel3.setLayout(f2);
		panel2.add(subPanel3);

		l2 = new JLabel("Selling an Investment                                                                                                ");
		subPanel3.add(l2);

		GridLayout g22 = new GridLayout(3, 3, 5, 5);
		subsubPanel3 = new JPanel();
		subsubPanel3.setPreferredSize(new Dimension(450, 110));
		//subsubPanel3.setBackground(Color.PINK);
		subsubPanel3.setLayout(g22);
		subPanel3.add(subsubPanel3);

		sellSymbol = new JLabel("Symbol");
		subsubPanel3.add(sellSymbol);

		sellSymbolInput = new JTextField(20);
		subsubPanel3.add(sellSymbolInput);

		sellReset = new JButton("Reset");
		sellReset.addActionListener(click -> resetSell(subsubPanel3));
		subsubPanel3.add(sellReset);

		sellQty = new JLabel("Quantity");
		subsubPanel3.add(sellQty);

		sellQtyInput = new JTextField(20);
		subsubPanel3.add(sellQtyInput);

		emptySell = new JLabel("");
		subsubPanel3.add(emptySell);

		sellPrice = new JLabel("Price");
		subsubPanel3.add(sellPrice);

		sellPriceInput = new JTextField(20);
		subsubPanel3.add(sellPriceInput);

		sellButton = new JButton("Sell");
		sellButton.addActionListener(click -> sellInvestment(subsubPanel3));
		subsubPanel3.add(sellButton);

		subPanel4 = new JPanel();
		subPanel4.setPreferredSize(new Dimension(200, 160));
		//subPanel4.setBackground(Color.BLUE);
		BoxLayout b2 = new BoxLayout(subPanel4, BoxLayout.PAGE_AXIS);
		panel2.add(subPanel4);

		messagesSell = new JLabel("Messages");
		messagesSell.setAlignmentX(Component.LEFT_ALIGNMENT);
		subPanel4.add(messagesSell);

		sellMessageDisplay = new JTextArea(6,45);
		subPanel4.add(sellMessageDisplay);

		sellScroll = new JScrollPane(sellMessageDisplay); 
		sellScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	sellScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		subPanel4.add(sellScroll);

		ActionListener al2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				mainPanel.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		};

		sell.addActionListener(al2);

		/**************************************************************/
		// UPDATE PANEL -- OPTION 3 !
		/**************************************************************/
		update = new JMenuItem("Update");
		menu.add(update);

		GridLayout g3 = new GridLayout(2, 0, 10, 5);
		panel3 = new JPanel();
		add(panel3);
		panel3.setVisible(false);
		panel3.setLayout(g3);

		FlowLayout f3 = new FlowLayout(FlowLayout.LEFT, 20, 5);
		subPanel5 = new JPanel();
		subPanel5.setPreferredSize(new Dimension(200, 160));
		//subPanel5.setBackground(Color.RED);
		subPanel5.setLayout(f3);
		panel3.add(subPanel5);

		l3 = new JLabel("Updating Investments                                                                                                ");
		subPanel5.add(l3);

		GridLayout g33 = new GridLayout(3, 3, 5, 5);
		subsubPanel5 = new JPanel();
		subsubPanel5.setPreferredSize(new Dimension(450, 110));
		//subsubPanel5.setBackground(Color.PINK);
		subsubPanel5.setLayout(g33);
		subPanel5.add(subsubPanel5);

		updateSymbol = new JLabel("Symbol");
		subsubPanel5.add(updateSymbol);

		updateSymbolInput = new JTextField(20);
		subsubPanel5.add(updateSymbolInput);

		prev = new JButton("Prev");
		subsubPanel5.add(prev);

		updateName = new JLabel("Name");
		subsubPanel5.add(updateName);

		updateNameInput = new JTextField(20);
		subsubPanel5.add(updateNameInput);

		next = new JButton("Next");
		subsubPanel5.add(next);

		updatePrice = new JLabel("Price");
		subsubPanel5.add(updatePrice);

		updatePriceInput = new JTextField(20);
		subsubPanel5.add(updatePriceInput);

		save = new JButton("Save");
		subsubPanel5.add(save);

		subPanel6 = new JPanel();
		subPanel6.setPreferredSize(new Dimension(200, 160));
		//subPanel6.setBackground(Color.BLUE);
		BoxLayout b3 = new BoxLayout(subPanel6, BoxLayout.PAGE_AXIS);
		panel3.add(subPanel6);

		messagesUpdate = new JLabel("Messages");
		messagesUpdate.setAlignmentX(Component.LEFT_ALIGNMENT);
		subPanel6.add(messagesUpdate);

		updateMessageDisplay = new JTextArea(6,45);
		subPanel6.add(updateMessageDisplay);

		updateScroll = new JScrollPane(updateMessageDisplay); 
		updateScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	updateScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		subPanel6.add(updateScroll);

		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Al3 being called");
				mainPanel.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		};

		update.addActionListener(al3);

		/**************************************************************/
		// GET GAIN PANEL -- OPTION 4 !
		/**************************************************************/
		getGain = new JMenuItem("Get Gain");
		menu.add(getGain);

		GridLayout g4 = new GridLayout(2, 0, 10, 5);
		panel4 = new JPanel();
		add(panel4);
		panel4.setVisible(false);
		panel4.setLayout(g4);

		FlowLayout f4 = new FlowLayout(FlowLayout.LEFT, 20, 5);
		subPanel7 = new JPanel();
		subPanel7.setPreferredSize(new Dimension(200, 160));
		//subPanel7.setBackground(Color.RED);
		subPanel7.setLayout(f4);
		panel4.add(subPanel7);

		l4 = new JLabel("Getting total gain                                                                                                ");
		subPanel7.add(l4);

		GridLayout g44 = new GridLayout(1, 3, 5, 5);
		subsubPanel7 = new JPanel();
		subsubPanel7.setPreferredSize(new Dimension(450, 50));
		//subsubPanel7.setBackground(Color.PINK);
		subsubPanel7.setLayout(g44);
		subPanel7.add(subsubPanel7);

		totalGain = new JLabel("Total gain");
		subsubPanel7.add(totalGain);

		totalGainOuput = new JTextArea(2, 10);
		subsubPanel7.add(totalGainOuput);

		emptyGetGain = new JLabel("");
		subsubPanel7.add(emptyGetGain);

		subPanel8 = new JPanel();
		subPanel8.setPreferredSize(new Dimension(200, 160));
		//subPanel8.setBackground(Color.BLUE);
		BoxLayout b4 = new BoxLayout(subPanel8, BoxLayout.PAGE_AXIS);
		panel4.add(subPanel8);

		messagesGetGain = new JLabel("Individual gains");
		messagesGetGain.setAlignmentX(Component.LEFT_ALIGNMENT);
		subPanel8.add(messagesGetGain);

		getGainMessageDisplay = new JTextArea(6,45);
		subPanel8.add(getGainMessageDisplay);

		getGainScroll = new JScrollPane(getGainMessageDisplay); 
		getGainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	getGainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		subPanel8.add(getGainScroll);

		ActionListener al4 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Al3 being called");
				mainPanel.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(true);
				panel5.setVisible(false);
			}
		};

		getGain.addActionListener(al4);

		/**************************************************************/
		// SEARCH PANEL -- OPTION 5 !
		/**************************************************************/
		search = new JMenuItem("Search");
		menu.add(search);

		GridLayout g5 = new GridLayout(2, 0, 10, 5);
		panel5 = new JPanel();
		add(panel5);
		panel5.setVisible(false);
		panel5.setLayout(g5);

		FlowLayout f5 = new FlowLayout(FlowLayout.LEFT, 20, 5);
		subPanel9 = new JPanel();
		subPanel9.setPreferredSize(new Dimension(200, 160));
		//subPanel9.setBackground(Color.RED);
		subPanel9.setLayout(f5);
		panel5.add(subPanel9);

		l5 = new JLabel("Searching Investments                                                                                                ");
		subPanel9.add(l5);

		GridLayout g55 = new GridLayout(4, 3, 5, 5);
		subsubPanel9 = new JPanel();
		subsubPanel9.setPreferredSize(new Dimension(450, 110));
		//subsubPanel9.setBackground(Color.PINK);
		subsubPanel9.setLayout(g55);
		subPanel9.add(subsubPanel9);

		searchSymbol = new JLabel("Symbol");
		subsubPanel9.add(searchSymbol);

		searchSymbolInput = new JTextField(20);
		subsubPanel9.add(searchSymbolInput);

		resetSearch = new JButton("Reset");
		subsubPanel9.add(resetSearch);

		searchNameKeyword = new JLabel("Name Keywords");
		subsubPanel9.add(searchNameKeyword);

		searchKeywordInput = new JTextField(20);
		subsubPanel9.add(searchKeywordInput);	

		empty4 = new JLabel("");
		subsubPanel9.add(empty4);

		searchLow = new JLabel("Low Price");
		subsubPanel9.add(searchLow);

		searchLPInput = new JTextField(20);
		subsubPanel9.add(searchLPInput);

		searchButton = new JButton("Search");
		subsubPanel9.add(searchButton);

		searchHigh = new JLabel("High Price");
		subsubPanel9.add(searchHigh);

		searchHPInput = new JTextField(20);
		subsubPanel9.add(searchHPInput);

		empty5 = new JLabel("");
		subsubPanel9.add(empty5);

		subPanel10 = new JPanel();
		subPanel10.setPreferredSize(new Dimension(200, 160));
		//subPanel10.setBackground(Color.BLUE);
		BoxLayout b5 = new BoxLayout(subPanel10, BoxLayout.PAGE_AXIS);
		panel5.add(subPanel10);

		messagesSearch = new JLabel("Search results");
		messagesSearch.setAlignmentX(Component.LEFT_ALIGNMENT);
		subPanel10.add(messagesSearch);

		searchMessageDisplay = new JTextArea(6,45);
		subPanel10.add(searchMessageDisplay);

		searchScroll = new JScrollPane(searchMessageDisplay); 
		searchScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	searchScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		subPanel10.add(searchScroll);


		ActionListener al5 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Al5 being called");
				mainPanel.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(true);
			}
		};

		search.addActionListener(al5);
	}

}