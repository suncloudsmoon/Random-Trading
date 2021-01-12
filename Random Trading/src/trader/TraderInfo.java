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

package trader;

/*
Find a way to save trader's portfolio!
more experience = better trading?
Future Release: Mood affects the amount of logs that the trader is willing to trade!
*/

import main.Guide;

/**
 * This is where I will define the trader's personality (character: angry or
 * happy for bargaining or negotiating), experience (changes over gameplay?),
 * name basic portfolio of a trader; gives the customer a basic introduction
 * 
 * @author suncloudsmoon
 * @version 0.5.5
 * @since 0.2.0
 */
public class TraderInfo {

	private String mood; // Mood stored here

	// Trader's very basic info...
	public static String name;
	private static int experience; // need to set a rand experience...

	public static int getExperience() {
		return experience;
	}

	public static void setExperience(int experience) {
		TraderInfo.experience = experience;
	}

	/**
	 * Outputs the place in which the trader lives in, and smoothly introduces it to
	 * the user
	 * 
	 * @since 0.3.0
	 */
	public void introduceyourself() {
		String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
		int planet_rand = (int) (Math.random() * 7);
		Guide.textarea.append("\n" + Guide.tradername + ": Hi, my name is " + Guide.tradername + " and I am from "
				+ planets[planet_rand] + '!');
		System.out.println();
		Guide.textarea.append(" I am willing to trade goods for dollars in exchange!");
	}

	/**
	 * Generates a random experience for the trader to have
	 * 
	 * @since 0.3.0
	 */
	public static void randexp() {
		String experience_definition = null;
		int random_experience = (int) (Math.random() * 10);
		experience = random_experience; // sets mood_rating_stars to years of experience!

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

		Guide.textarea.append("\nExperience: " + +random_experience + " years " + "(" + experience_definition + ")");
	}

	/**
	 * Generates a random mood from Math.random() and String[]
	 * 
	 * @return A String type containing the mood of the trader
	 * @since 0.4.0
	 */
	public String randmood() {
		String[] random_mood = { "Angry", "Disgusted", "Fearful", "Happy", "Sad", "Suprised" };
		int random_mood_1 = (int) (Math.random() * 5);
		String randmood = random_mood[random_mood_1];
		mood = randmood;
		return randmood;
	}

	/**
	 * Turns mood into a reasonable rating for the trader
	 * 
	 * @return A String value containing the rating of the trader in a full sentence
	 * @since 0.4.0
	 */
	public String randratingmood() {

		String rating;
		if (randmood().contentEquals("Happy")) {
			rating = "Rating: 5 stars";

		} else if (randmood().contentEquals("Suprised")) {
			rating = "Rating: 4 stars";

		} else if ((randmood().contentEquals("Fearful")) || (randmood().contentEquals("Sad"))) {
			rating = "Rating: 3 stars";

		} else if (randmood().contentEquals("Disgusted")) {
			rating = "Rating: 2 stars";

		} else if (randmood().contentEquals("Angry")) {
			rating = "Rating: 1 star";

		} else {
			rating = "Rating: Unknown trader with no previous ratings 👿";
		}
		return rating;
	}

	/**
	 * Generates a random review for the user to look at to determine whether to
	 * trade with the trader
	 * 
	 * @since 0.3.0
	 */
	public void newestreview() {

		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int rand_month = (int) (Math.random() * 11);
		int rand_day = (int) (Math.random() * 29 + 1);
		int rand_year = 2020 - (int) (Math.random() * experience);

		Guide.textarea.append("\nNewest Rating:\n" + "User " + RandName.reviewpersonname() + " on " + months[rand_month]
				+ " " + rand_day + ", " + rand_year);

		if (randratingmood() == "Rating: 1 star") {
			Guide.textarea.append("\n" + randratingmood());
		} else {
			Guide.textarea.append("\n" + randratingmood());
		}

		Guide.textarea.append("\nComment: " + '"' + "Trader " + Guide.tradername + " was " + mood.toLowerCase()
				+ " while I was trying to trade with him!" + '"');

	}

	/**
	 * Randomly determines whether the trader's business is a incorporation or a
	 * limited liability company
	 * 
	 * @return A String value containing the acronym of the randomly selected
	 *         business structure
	 * @since 0.3.5
	 */
	public String businesstype() {

		String business;
		int business_structure = (int) (Math.random() * 2) - 1;

		if (business_structure == 0) {
			business = "Inc.";
		} else {
			business = "LLC";
		}
		return business;
	}

	/**
	 * Generates a random amount of trees that the trader has cut down for one day
	 * 
	 * @return An integer value containing the trees cut per day
	 * @since 0.3.5
	 */
	public int randtreescut() {
		int logs = (int) (Math.random() * 4) + 45;
		return logs;
	}
}
