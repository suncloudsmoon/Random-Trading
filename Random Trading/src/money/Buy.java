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

package money;

import main.Guide;
import food.Potato;

/**
 * Sets up stuff so it is easy to subtract total cash in the customer's pockets
 * and from the trader
 * 
 * @author suncloudsmoon
 * @version 0.8.0
 * @since 0.4.0
 */
public class Buy {
	// All about money
	private static String customercash;
	private static double moneyspent;
	private static double customerwallet;

	// All about potatoes
	private double numofpotatoinput;
	private String numofpotatoinputString;

	// Processing the payment requested by the user
	private double processing_payment_customer;
	private double processing_payment_trader;

	public static String getCustomercash() {
		return customercash;
	}

	public static void setCustomercash(String customercash) {
		Buy.customercash = customercash;
	}

	public static double getMoneyspent() {
		return moneyspent;
	}

	public static void setMoneyspent(double moneyspent) {
		Buy.moneyspent = moneyspent;
	}

	public static double getCustomerwallet() {
		return customerwallet;
	}

	public static void setCustomerwallet(double customerwallet) {
		Buy.customerwallet = customerwallet;
	}

	public double getNumofpotatoinput() {
		return numofpotatoinput;
	}

	public void setNumofpotatoinput(double numofpotatoinput) {
		this.numofpotatoinput = numofpotatoinput;
	}

	public String getNumofpotatoinputString() {
		return numofpotatoinputString;
	}

	public void setNumofpotatoinputString(String numofpotatoinputString) {
		this.numofpotatoinputString = numofpotatoinputString;
	}

	/**
	 * Checks if the amount of potatoes entered by the user is within the limits of
	 * the user's amount of cash in the wallet
	 * 
	 * @since 0.3.0
	 */
	public void walletcheck() {

		numofpotatoinput = Double.parseDouble(Guide.userinput);
		moneyspent = (numofpotatoinput) * (Potato.getUnitpricepotato());
		double real_cash_1 = Double.valueOf(customercash);
		numofpotatoinput = real_cash_1 - moneyspent;
		String num_potato_input_string = Double.toString(numofpotatoinput);
		String num_potato_input_char_string = String.valueOf(num_potato_input_string.charAt(0));
		this.numofpotatoinputString = num_potato_input_char_string;
	}

	/**
	 * Outputs the final receipt of the buying transaction
	 * 
	 * @since 0.3.0
	 */
	public void order() {
		customerwallet = Double.parseDouble(numofpotatoinputString);
		processing_payment_customer = customerwallet - moneyspent;
		processing_payment_trader = randtradermoney() + moneyspent;
		String wallet = " in his/her wallet!", cashbox = " in his/her cashbox!";
		Guide.textarea.append("\nReciept:\nCustomer has $" + processing_payment_customer + wallet + "\nTrader "
				+ Guide.tradername + " has $" + processing_payment_trader + cashbox
				+ "\nDo you want to save your progress? Type [y/n]");
	}

	/**
	 * A function that activates when the user requests to save the progress made in
	 * the game
	 * 
	 * @since 0.3.0
	 * @deprecated Use the Game menu to save progress or use a JOptionPane when
	 *             the user clicks on the X button
	 */
	public void saveprogress() {
		if (Guide.userinput == "y") {
			String combined_variable_1 = Double.toString(processing_payment_customer);
			String combined_variable_2 = Double.toString(processing_payment_trader);
			String seed = combined_variable_1 + "/" + combined_variable_2;
			Guide.textarea.append("\nTrader Game Seed: " + seed);
		}
	}

	/**
	 * Generates a random cash amount to be placed in the trader's cashbox
	 * 
	 * @return A int random value that represents the amount of money in the
	 *         trader's cashbox
	 * @since 0.4.0
	 */
	public double randtradermoney() {
		int trader_money = (int) (Math.random() * 100);
		return trader_money;
	}

}
