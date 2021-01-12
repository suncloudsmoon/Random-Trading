/*
* Copyright (c) 2020 suncloudsmoon
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

package main;

import javax.swing.JOptionPane;

import food.Potato;
import money.Buy;
import seed.InputSeed;
import trader.RandName;
import trader.TraderInfo;

/*
Keep it simple!
Later: make unique seeds to save gameplay!
*/

/**
 * This is where the trader spits out *entertaining words and comes up with
 * trade deals
 * 
 * @author suncloudsmoon
 * @version 0.8.0
 * @since 0.0.1
 *
 */
public class TradingHub {

	/**
	 * A class object that contains many void functions that outputs random names
	 * for different purposes
	 * 
	 * @deprecated This object is used only once
	 * @since 0.3.0
	 */
	protected static RandName rand1 = new RandName();
	private Buy buy1 = new Buy();

	/**
	 * Outputs the trader's portfolio for the user to analyze
	 * 
	 * @since 0.7.0
	 */
	public void traderprofile() {
		// Trade Command Provoked
		try {
			TraderInfo trader1 = new TraderInfo();
			trader1.introduceyourself();
			Guide.textarea.append("\nTrader's Profile:");
			TraderInfo.randexp();
			trader1.randratingmood();
			trader1.newestreview();

			// Lists and describes the business owned by the trader
			Guide.textarea.append("\nBusiness owned by this person: " + rand1.randbusinessname() + " "
					+ trader1.businesstype() + ", a company that cuts down trees!");
			double experience_proportional_log = trader1.randtreescut() - (((1) / (TraderInfo.getExperience()) * 10));
			int experience_proportional_log_int = (int) experience_proportional_log;
			Guide.textarea.append("\nHis business cuts down " + experience_proportional_log_int + " trees per day!");

			// Asks the user to input the desired amount of money they want!
			Guide.textarea.append("\nHow much money do want to start with?\n");
			Guide.textfield.setSelectedItem("$");
			Guide.stage++;
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Unable to fetch trader's profile info:\n" + e.getMessage(),
					"Info Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * This function processes the user input of money and asks the user for how
	 * many potatoes do they want
	 * 
	 * @since 0.7.0
	 */
	public void buyinginterest() {
		try {
			if (Guide.userinput.startsWith("$")) {
				Double cashstart = Double.parseDouble(Guide.userinput.substring(1, Guide.userinput.length() - 1));
				Buy.setCustomercash(cashstart.toString());
			} else {
				Double cashstart = Double.parseDouble(Guide.userinput);
				Buy.setCustomercash(cashstart.toString());
			}

			// Creates potato object and displays how much potatoes are at sale!
			Potato potato1 = new Potato();
			potato1.sellpotatoes();

			// Asks the user how much potatoes do they want with price and records it
			Guide.textarea.append("\nHow many potatoes do you want?\n");

			Guide.stage++;
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Unable to process the buying transaction:\n" + e.getMessage(),
					"Buying Error", JOptionPane.ERROR_MESSAGE);
			Guide.textarea.append(Guide.tradername + "\nHow much money do want to start with?\n");
			Guide.textfield.setSelectedItem("$");
		}
	}

	/**
	 * Checks if the amount of potatoes that the user wants is within the limits of
	 * the total amount of money that the user has
	 * 
	 * @since 0.7.0
	 */
	public void moneycheck() {
		try {
			buy1.walletcheck();
			if (buy1.getNumofpotatoinputString().contentEquals("-")) {
				throw new IllegalArgumentException(
						"The cost of buying these commodities exceeds the amount of money in your wallet!");
			}
			Guide.textarea.append(Guide.tradername + "\nAre you willing to pay $" + Buy.getMoneyspent() + " [y/n]");
			Guide.stage++;
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Unable to process the buying transaction:\n" + e.getMessage(),
					"Buying Error", JOptionPane.ERROR_MESSAGE);
			Guide.textarea.append("\n" + Guide.tradername + ": How many potatoes do you want?\n");
		}
	}

	/**
	 * Asks the user to confirm the purchase of certain amount of potatoes with a
	 * receipt
	 * 
	 * @since 0.7.0
	 */
	public void askreceipt() {
		if (Guide.userinput.equals("y")) {
			try {
				buy1.order();
				Guide.stage++;
			} catch (Exception e) {
				JOptionPane.showInternalMessageDialog(null,
						"Unable to process the buying transaction:\n" + e.getMessage(), "Buying Error",
						JOptionPane.ERROR_MESSAGE);
				Guide.textarea.append("\nAre you willing to pay $" + Buy.getMoneyspent() + " [y/n]");
			}

		}
	}

	// Add more features!
	// Different options to be displayed at the start of the game (text)
	/**
	 * A command that can be provoked at the beginning of the game to convert
	 * gameseed to a purchase receipt
	 * 
	 * @since 0.7.0
	 */
	public void seedtoreceipt() {
		try {
			InputSeed seed1 = new InputSeed();
			seed1.getseed();
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Unable to process the buying transaction:\n" + e.getMessage(),
					"Buying Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Another option for the user to request help by provoking this command at the
	 * beginning of the game
	 * 
	 * @since 0.7.0
	 */
	public void userneedshelp() {
		try {
			char trade = '"';
			Guide.textarea.append("\nType " + trade + "trade" + trade + " in order to trade with a villager!");
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Unable to process the buying transaction:\n" + e.getMessage(),
					"Buying Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
