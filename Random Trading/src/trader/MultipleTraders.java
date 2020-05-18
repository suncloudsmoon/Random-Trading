package trader;
public class MultipleTraders {
	public static int counter = 0;
	public static String[] new_trader = new String[5];
	private static String rand_next;
	
	
	public MultipleTraders(String a) {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		String rand_next = "";
		for (int i = 0; i < 5; i++) {
			int pure_randomness = (int) (Math.random() * 25);
			rand_next = rand_next + alphabet[pure_randomness];
		}
		
		System.out.println(rand_next);
		MultipleTraders.rand_next = rand_next;
		new_trader[counter] = MultipleTraders.rand_next; 
		
		
	}
	
	// This thing is for storing different traders!
	public MultipleTraders() {
		for (int i = 0; i <= counter; i++) {
			System.out.println(new_trader[i]);
		}
	}
	
}