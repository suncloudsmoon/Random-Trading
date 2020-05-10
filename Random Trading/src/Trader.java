// This is where I will define the trader's persona (character: angry or happy for bargaining or negotiating), experience (changes over gameplay?), name
// basic portfolio of a trader; gives the customer a basic intro

class Trader {
	String name, mood;
	int experience; // more experience = better trading??

	void introduce_name() {
		System.out.println("Hi, I am willing to trade potatoes for dollars.\n" + "My name is " + name);
	}

	void mood_for_trading() {
		System.out.println("Trader " + name + " mood: " + mood);
	}

	void trading_experience() {
		System.out.println("Trader " + name + " Experience: " + experience);
	}

	void trader_rating_5stars() {
		if (mood.equals("happy")) {
			int rating = 5;
			System.out.println("Trader " + name + " rating is : " + rating + " stars!");
		} else if (mood.equals("angry")) {
			int rating = 1;
			System.out.println("Trader " + name + " rating is " + rating + " stars :(");
		} else {
			String unknown = "Unknown trader with no previous ratings 👿";
			System.out.println(unknown);
		}
	}
}
