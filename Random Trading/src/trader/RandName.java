package trader;

/**
 * Contains a series of functions that generate random stuff for different
 * purposes
 * 
 * @author suncloudsmoon
 * @version 0.5.0
 * @since 0.3.0
 *
 */
public class RandName {

	private String rand_next_12 = "";

	/**
	 * Generates a random trader name
	 * 
	 * @return A String value of the trader's name
	 * @since 0.2.0
	 */
	public static String tradername() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		String rand_next = "";
		for (int i = 0; i < 7; i++) {
			int pure_randomness = (int) (Math.random() * 25);
			rand_next = rand_next + alphabet[pure_randomness];
		}
		return rand_next;

	}

	/**
	 * Generates a random name for the user review person
	 * 
	 * @return A String value of the randomly generated name
	 * @since 0.3.5
	 */
	public static String reviewpersonname() {
		String[] alphabet_1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };

		String rand_next_1 = "";
		for (int i = 0; i < 5; i++) {
			int pure_randomness_1 = (int) (Math.random() * 25);
			rand_next_1 = rand_next_1 + alphabet_1[pure_randomness_1];
		}
		rand_next_1 = rand_next_1 + (int) (Math.random() * 100);

		return rand_next_1;

	}

	/**
	 * Generates a random name for the *logging business
	 * 
	 * @return A String value for the randomly generated log business name
	 * @since 0.3.5
	 */
	public String randbusinessname() {
		String[] alphabet_1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };

		for (int i = 0; i < 4; i++) {
			int pure_randomness_12 = (int) (Math.random() * 25);
			rand_next_12 = rand_next_12 + alphabet_1[pure_randomness_12];
		}
		rand_next_12 = rand_next_12.substring(0, 1).toUpperCase() + rand_next_12.substring(1, rand_next_12.length() - 1)
				+ " logging";

		return rand_next_12;

	}

}
