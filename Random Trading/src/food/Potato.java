package food;

import main.Guide;
import money.Buy;

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