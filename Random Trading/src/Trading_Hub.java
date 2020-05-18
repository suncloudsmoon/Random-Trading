import java.util.Scanner;

import food.Potato;
import money.Buy;
import trader.MultipleTraders;
import trader.Rand_Trader_Name;
import trader.Trader;

// Keep it simple!
// Later: make unqiue seeds to save gameplay

public class Trading_Hub {

	public static void main(String[] args) {
		while (true) {
			// Start menu
			Scanner settings = new Scanner(System.in);
			System.out.print("Enter a command: ");
			String command = settings.next();
			int counter_1 = 0; // Counter used for user experience when "help" command is provoked!

			// Trade Command Provoked
			if (command.contentEquals("trade")) {

				// Displays the basic portfolio of the trader!
				System.out.println("Which trader do you want to meet?");
				int num_traders = (int) (Math.random() * 5) + 1;
				for (int trade = 0; trade < num_traders; trade++) {
					System.out.print((trade + 1) + ") ");
					new MultipleTraders("hello");
					MultipleTraders.counter++;
				}

				System.out.print("Type the villager you want: ");
				String get_trader = settings.next();

				if (get_trader != null) { // change this!
					System.out.println();
					Trader trader1 = new Trader();
					Rand_Trader_Name rand1 = new Rand_Trader_Name();
					trader1.name = Rand_Trader_Name.user();
					Trader.rand_name = Rand_Trader_Name.user_1();
					trader1.introduce_name();
					System.out.println();
					System.out.println("Trader's Profile:");
					Trader.trading_experience();
					Trader.mood = trader1.mood_for_trading();
					Trader.trader_rating();
					trader1.newest_review();

					// Lists and describes the business owned by the trader
					System.out.print("\nBusiness owned by this person: " + rand1.logging_business() + " "
							+ Trader.businesstype());
					System.out.print(", a company that cuts down trees!");
					double experience_proportional_log = Trader.amountoflogs() - (((1) / (Trader.experience) * 10));
					int experience_proportional_log_int = (int) experience_proportional_log;
					System.out.println("\nHis business cuts down " + experience_proportional_log_int + " per day!");

					// Asks the user to input the desired amount of money they want!
					System.out.println();
					System.out.println("How much money do want to start with?");
					System.out.print("$ ");
					String customer_cash = settings.next();
					Buy.customer_cash = customer_cash;

					// Trade start menu
					System.out.print("Input a trade command: ");
					String input = settings.next();

					if (input.contentEquals("buy")) {
						// Creates potato object and displays how much potatoes are at sale!
						Potato potato1 = new Potato();
						potato1.sell_potatoes();

						// Asks the user how much potatoes do they want with price and records it
						while (true) {
							Buy buy2 = new Buy();
							buy2.walletcheck();
							if (buy2.num_potato_input_char_string.contentEquals("-")) {
								System.out.println(
										"The amount of money spent on good exceeds the amount of money you have!");
								System.out.println(
										"Please enter a monetary value within the limits of the amount of cash you have!");
							} else {
								break;
							}
						}

						// double money_spent = (num_potato_input) * (potato1.potato_price_per_kg);

						// The user is asked to confirm their purchase!
						System.out.println("Are you willing to pay $" + Buy.money_spent + " [y/n]");
						String confirmation = settings.next();

						if (confirmation.contentEquals("y")) {
							Buy buy1 = new Buy();
							buy1.order();

						}
						// save == / is the way to indicate the change in double variable

					} else if (input.contentEquals("code")) { // Currently, there is only one "/", one index
						InputSeed seed1 = new InputSeed();
						seed1.getseed();
					}

					// help command will guide new users and tell them how to use commands in this
					// program!
				} // this is where "Which trader do you want to meet?" if function ends

			} else if (command.contentEquals("help")) {
				char trade = '"';
				System.out.println("Type " + trade + "trade" + trade + " in order to trade with a villager!");
				counter_1++;
			} // if command block ends here!

			// User has the option to restart the program!
			if (counter_1 == 0) {
				System.out.println("Do you want to restart the program? [y/n]");
			} else {
				System.out.println("Do you want to play the game? [y/n]");
			}

			String restart_confirmation = settings.next();
			if (restart_confirmation.contentEquals("y")) {
				System.out.println("Restarting...");
			} else {
				System.out.println("Program Halted!"); // add a bit of flavor to this program!
				break;
			}

		} // while loop ends here!

	} // this is where the main method ends!

}
