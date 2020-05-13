// This is where I will define the trader's persona (character: angry or happy for bargaining or negotiating), experience (changes over gameplay?), name
// basic portfolio of a trader; gives the customer a basic intro
// Find a way to save trader's portfolio!
// more experience = better trading?

class Trader {
	public String name;
	public static String rand_name;
	public static String mood;
	public static int experience;
	private static int mood_rating_stars = 0;

	void introduce_name() {
		String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
		int planet_rand = (int) (Math.random() * 7);
		System.out.println("Hi, my name is " + name + " and I am from " + planets[planet_rand] + '!');
		System.out.println("I am willing to trade goods for dollars in exchange!");

	}

	static void trading_experience() {
		String experience_definition = null;
		int random_experience = (int) (Math.random() * 10);
		experience = random_experience;
		if (random_experience <= 2) {
			experience_definition = "Fundamental Awareness";
		} else if (random_experience <= 4) {
			experience_definition = "Novice";
		} else if (random_experience <= 6) {
			experience_definition = "Intermediate";
		} else if (random_experience <= 8) {
			experience_definition = "Advanced";
		} else if (random_experience <= 10) {
			experience_definition = "Expert";
		}

		System.out.println("Experience: " + +random_experience + " years " + "(" + experience_definition + ")");
	}

	String mood_for_trading() {
		String[] random_mood = { "Angry", "Disgusted", "Fearful", "Happy", "Sad", "Suprised" };
		int random_mood_1 = (int) (Math.random() * 5);
		String random_mood_display = random_mood[random_mood_1];
		return random_mood_display;
	}

	static void trader_rating() {

		if (mood.equals("Happy")) {
			mood_rating_stars = 5;
			System.out.println("Rating: 5 stars");

		} else if (mood.equals("Suprised")) {
			mood_rating_stars = 4;
			System.out.println("Rating: 4 stars");

		} else if (mood.equals("Fearful") || mood.equals("Sad")) {
			mood_rating_stars = 3;
			System.out.println("Rating: 3 stars");

		} else if (mood.equals("Disgusted")) {
			mood_rating_stars = 2;
			System.out.println("Rating: 2 stars");

		} else if (mood.equals("Angry")) {
			mood_rating_stars = 1;
			System.out.println("Rating: 1 star");

		} else {
			System.out.println("Rating: Unknown trader with no previous ratings 👿");
		}
	}

	void newest_review() {

		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int rand_month = (int) (Math.random() * 11);
		int rand_day = (int) (Math.random() * 29 + 1);
		int rand_year = 2020 - (int) (Math.random() * experience);

		System.out.println("\nNewest Rating: ");
		System.out.println("User " + rand_name + " on " + months[rand_month] + " " + rand_day + ", " + rand_year);
		if (Trader.mood_rating_stars == 1) {
			System.out.println("Rating: " + Trader.mood_rating_stars + " Star!");
		} else {
			System.out.println("Rating: " + Trader.mood_rating_stars + " Stars!");
		}

		System.out.println(
				'"' + "Trader " + name + " was " + mood.toLowerCase() + " while I was trying to trade with him!" + '"');
	}
}
