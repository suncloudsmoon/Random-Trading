import java.util.Scanner;

// Keep it simple
// Later: make unqiue seeds to save gameplay

public class Trading_Hub {

	public static void main(String[] args) {
		Scanner settings = new Scanner(System.in);
		Trader trader1 = new Trader();
		Rand_Trader rand1 = new Rand_Trader();
		trader1.name = rand1.user();
		trader1.introduce_name();
		System.out.println("Please input commands to learn more about the trader or buy food from the trader!");
		String input = settings.next();
		if (input.contentEquals("buy")) {
			Food food1 = new Food();
			food1.sell_potatoes();
			System.out.println("How much potatoes do you want?");
			double num_potato_input = settings.nextDouble();
			double money_spent = (num_potato_input) * (food1.potato_price_per_kg);
			System.out.println("Are you willing to pay $" + money_spent);
			System.out.println("Type y/n to proceed!");
			String confirmation = settings.next();
			if (confirmation.contentEquals("y")) {
				Buy buy1 = new Buy();
				double processing_payment_customer = buy1.customer_initial_money() - money_spent;
				double processing_payment_trader = buy1.trader_initial_money() + money_spent;
				String wallet = " in his/her wallet!", cashbox = " in his/her cashbox!";
				System.out.println("Reciept:\nCustomer has $" + processing_payment_customer + wallet + "\nTrader "
						+ trader1.name + " has $" + processing_payment_trader + cashbox);

				System.out.println("Do you want to save your progress? Type y/n");
				String save_input = settings.next();
				if (save_input.contentEquals("y")) {
					String combined_variable_1 = Double.toString(processing_payment_customer);
					String combined_variable_2 = Double.toString(processing_payment_trader);
					String seed = combined_variable_1 + "/" + combined_variable_2;
					System.out.println("Trader Game Seed: " + seed);
					// System.out.println(seed.lastIndexOf("/"));

					/*
					int char101 = 0;
					for (int i = 0; i < seed.length(); i++) { // indexes print out
						
						char seed101 = seed.charAt(char101);
						String sead101_string = Character.toString(seed101);
						if (sead101_string.contentEquals("/")) {
							System.out.println(char101);
						}
						char101++;
					}
					*/
					
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
				System.out.println("Customer has -$" + total_name_1 + " in his/her wallet!");
			} else {
				System.out.println("Customer has $" + total_name_1 + " in his/her wallet!");
			}
			
			System.out.println("Trader fxxfx has $" + total_name_2 + " in his/her cashbox!" );
		}

	}

}
