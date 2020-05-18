import java.util.Scanner;

public class InputSeed {
	void getseed() {
		System.out.print("Please enter trader game seed: ");
		Scanner code = new Scanner(System.in);
		String code_input = code.next();
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
 // this is where "Which trader do you want to meet?" if function ends
	}

