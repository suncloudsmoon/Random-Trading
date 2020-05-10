class Rand_Trader {

	public String user() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
				"n", "o", "p", "q", "r","s", "t", "u", "v", "w", "x", "y", "z" };
		
		
		String rand_next = "";
		for (int i = 0; i < 5; i++) {
			int pure_randomness = (int) (Math.random() * 25);
			rand_next = rand_next + alphabet[pure_randomness];
		}
		return rand_next;
		
	}

}
