package trader;
public class Rand_Trader_Name {

	public static String user() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		String rand_next = "";
		for (int i = 0; i < 5; i++) {
			int pure_randomness = (int) (Math.random() * 25);
			rand_next = rand_next + alphabet[pure_randomness];
		}
		return rand_next;

	}

	public static String user_1() {
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

	public String rand_next_12 = "";

	public String logging_business() {
		String[] alphabet_1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };

		for (int i = 0; i < 4; i++) {
			int pure_randomness_12 = (int) (Math.random() * 25);
			rand_next_12 = rand_next_12 + alphabet_1[pure_randomness_12];
		}
		rand_next_12 = rand_next_12 + " logging";

		return rand_next_12;

	}

}
