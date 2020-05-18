package money;
// Sets up stuff so it is easy to subtract total cash in the customer's pockets and from the trader (add)

import java.util.Scanner;

import food.Potato;
import trader.Trader;

public class Buy {
	public static String customer_cash;
	public static double money_spent;
	public static int customer_wallet;
	
	// the customer sets the amount of cash in their wallet and the villager is
	// given a random amount of cash!
	public int villager_cashbox;

	public double num_potato_input;
	public double money_spent_check;
	public String num_potato_input_char_string;
	Potato potato1 = new Potato();
	public void walletcheck() {
		System.out.println("How much potatoes do you want?");
		Scanner amount_potatoes = new Scanner(System.in);
		num_potato_input = amount_potatoes.nextDouble();
		money_spent = (num_potato_input) * (potato1.potato_price_per_kg);
		double real_cash_1 = Double.valueOf(customer_cash);
		num_potato_input = real_cash_1 - money_spent;
		String num_potato_input_string = Double.toString(num_potato_input);
		String num_potato_input_char_string = String.valueOf(num_potato_input_string.charAt(0));
		this.num_potato_input_char_string = num_potato_input_char_string;
	}

	
	Trader trader1 = new Trader();
	public void order() {
		Scanner codeinput = new Scanner(System.in);
		customer_wallet = Integer.parseInt(customer_cash);
		double processing_payment_customer = customer_wallet - money_spent;
		double processing_payment_trader = trader_random_money() + money_spent;
		String wallet = " in his/her wallet!", cashbox = " in his/her cashbox!";
		System.out.println("Reciept:\nCustomer has $" + processing_payment_customer + wallet + "\nTrader "
				+ trader1.name + " has $" + processing_payment_trader + cashbox);

		System.out.println("Do you want to save your progress? Type y/n");
		String save_input = codeinput.next();
		if (save_input.contentEquals("y")) {
			String combined_variable_1 = Double.toString(processing_payment_customer);
			String combined_variable_2 = Double.toString(processing_payment_trader);
			String seed = combined_variable_1 + "/" + combined_variable_2;
			System.out.println("Trader Game Seed: " + seed);
		}
	}

	// Should I remove this?
	public double default_customer_money() {
		double customer_money = 20;

		return customer_money;
	}

	public double trader_random_money() {
		double trader_money = (int) (Math.random() * 100);

		return trader_money;
	}

}
