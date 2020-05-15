import java.util.Scanner;

// Keep it simple!
// Later: make unqiue seeds to save gameplay

public class Trading_Hub {

	public static void main(String[] args) {
		while (true) {
			// Start menu
			Scanner settings = new Scanner(System.in);
			System.out.print("Enter a command: ");

			// Counter used for user experience when "help" command is provoked!
			int counter_1 = 0;

			String command = settings.next();
			if (command.contentEquals("trade")) {

				// Displays the basic portfolio of the trader!
				System.out.println("Which trader do you want to meet?");
				int num_traders = (int) (Math.random() * 5) + 1;
				for (int trade = 0; trade < num_traders; trade++) {
					System.out.print((trade + 1) + ") ");
					new MultipleTraders("hello");
					MultipleTraders.counter++;
				}
				// new MultipleTraders();

				System.out.print("Type the villager you want: ");
				String get_trader = settings.next();

				if (get_trader != null) {
					System.out.println();
					Trader trader1 = new Trader();
					Rand_Trader rand1 = new Rand_Trader();
					trader1.name = Rand_Trader.user();
					Trader.rand_name = Rand_Trader.user_1();
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

					// Trade start menu
					System.out.print("Input a trade command: ");
					String input = settings.next();

					if (input.contentEquals("buy")) {
						// Creates potato object and displays how much potatoes are at sale!
						Potato potato1 = new Potato();
						potato1.sell_potatoes();

						// Asks the user how much potatoes do they want with price and records it
						double num_potato_input;
						double money_spent;
						while (true) {
							System.out.println("How much potatoes do you want?");
							num_potato_input = settings.nextDouble();
							money_spent = (num_potato_input) * (potato1.potato_price_per_kg);
							double real_cash_1 = Double.valueOf(customer_cash);
							num_potato_input = real_cash_1 - money_spent - real_cash_1;
							String num_potato_input_string = Double.toString(num_potato_input);
							String num_potato_input_char_string = String.valueOf(num_potato_input_string.charAt(0));
							if (num_potato_input_char_string.contentEquals("-")) {
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
						System.out.println("Are you willing to pay $" + money_spent + " [y/n]");
						String confirmation = settings.next();

						if (confirmation.contentEquals("y")) {
							Buy buy1 = new Buy();
							buy1.customer_wallet = Integer.parseInt(customer_cash);
							double processing_payment_customer = buy1.customer_wallet - money_spent;
							double processing_payment_trader = buy1.trader_random_money() + money_spent;
							String wallet = " in his/her wallet!", cashbox = " in his/her cashbox!";
							System.out.println("Reciept:\nCustomer has $" + processing_payment_customer + wallet
									+ "\nTrader " + trader1.name + " has $" + processing_payment_trader + cashbox);

							System.out.println("Do you want to save your progress? Type y/n");
							String save_input = settings.next();
							if (save_input.contentEquals("y")) {
								String combined_variable_1 = Double.toString(processing_payment_customer);
								String combined_variable_2 = Double.toString(processing_payment_trader);
								String seed = combined_variable_1 + "/" + combined_variable_2;
								System.out.println("Trader Game Seed: " + seed);

							}

						}
						// save == / is the way to indicate the change in double variable

					} else if (input.contentEquals("code")) { // Currently, there is only one "/", one index
						System.out.println("Please enter trader game seed: ");
						String code_input = settings.next();
						int break_index = code_input.indexOf("/");
						int num_1 = break_index - 1;
						int num_2 = break_index + 1;
						int num_2_max_index = code_input.length();
						num_2_max_index = num_2_max_index - 1;
						System.out.println(num_2_max_index);
						int minus_index = code_input.indexOf("-");

						String total_name_1 = "";
						String total_name_2 = "";

						int code_once = 0;
						if (code_input.contains("-")) {
							for (int store_num_1 = 1; store_num_1 <= num_1; store_num_1++) {
								char name_1 = code_input.charAt(store_num_1);
								total_name_1 = total_name_1 + name_1;

							}
						} else {
							for (int store_num_1 = 0; store_num_1 <= num_1; store_num_1++) {
								char name_1 = code_input.charAt(store_num_1);
								total_name_1 = total_name_1 + name_1;

							}
						}

						for (int store_num_2 = num_2; store_num_2 <= num_2_max_index; store_num_2++) {
							char name_2 = code_input.charAt(store_num_2);

							total_name_2 = total_name_2 + name_2;

						}
						System.out.println("Saved Reciept: ");
						if (code_input.contains("-")) {
							System.out.println("Customer has -$" + total_name_1 + " in his wallet!");
						} else {
							System.out.println("Customer has $" + total_name_1 + " in his wallet!");
						}

						System.out.println("Trader fxxfx has $" + total_name_2 + " in his cashbox!");
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
