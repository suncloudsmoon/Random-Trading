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

package food;

import main.Guide;

/**
 * Defines how the potato will be traded
 * 
 * @author suncloudsmoon
 * @version 0.8.0
 * @since 0.3.0
 *
 */
public class Potato {
	// Future Release: Add the feature of gaining poisonous potatoes && a chance of
	// trading a 1,000 potatoes!
	private int numpotatoes = (int) (Math.random() * 100);
	private static float unitpricepotato = (float) Math.random() * 2 + 1;

	/**
	 * A function used to fetch the random unit price of a potato
	 * 
	 * @return a random float primitive type price ($) of a potato
	 * @since 0.8.0
	 */
	public static float getUnitpricepotato() {
		return unitpricepotato;
	}

	/**
	 * A function used to set a unit price for a potato
	 * 
	 * @param unitpricepotato Defined float type unit price of a potato
	 * @since 0.8.0
	 */
	public void setUnitpricepotato(float unitpricepotato) {
		this.unitpricepotato = unitpricepotato;
	}

	/**
	 * Outputs the number of potatoes that the trader has
	 * 
	 * @since 0.4.0
	 */
	public void sellpotatoes() {
		Guide.textarea.append("\n" + Guide.tradername + "I have " + numpotatoes + " potatoes!"
				+ "\nThey cost a total of $" + unitpricepotato + " per kg!");
	}

	/**
	 * Computes the total amount to be payed by the user for the goods that are
	 * being purchased
	 * 
	 * @return A String value containing the total price to be payed at checkout
	 * @since 0.3.0
	 */
	public String computepotato() {
		double total_price = unitpricepotato * numpotatoes;
		String total_price_display = "The total price is $" + total_price;
		return total_price_display;
	}
}