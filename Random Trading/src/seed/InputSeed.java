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

package seed;

import main.Guide;
/**
 * A function dedicated to get a seed and output a human-readable transaction receipt
 * @author suncloudsmoon
 * @version 0.6.0
 * @since 0.3.0
 * @deprecated Use the game menu to input or export seeds via JOptionPane
 *
 */
public class InputSeed {
	/**
	 * A function that gets the input seed and outputs a receipt
	 * @since 0.3.0
	 */
	public void getseed() {
		Guide.textarea.append("Please enter trader game seed: ");
		int break_index = Guide.userinput.indexOf("/");
		int num_1 = break_index - 1;
		int num_2 = break_index + 1;
		int num_2_max_index = Guide.userinput.length();
		num_2_max_index = num_2_max_index - 1;
		int minus_index = Guide.userinput.indexOf("-");

		String total_name_1 = "";
		String total_name_2 = "";

		int code_once = 0;
		if (Guide.userinput.contains("-")) {
			for (int store_num_1 = 1; store_num_1 <= num_1; store_num_1++) {
				char name_1 = Guide.userinput.charAt(store_num_1);
				total_name_1 = total_name_1 + name_1;

			}
		} else {
			for (int store_num_1 = 0; store_num_1 <= num_1; store_num_1++) {
				char name_1 = Guide.userinput.charAt(store_num_1);
				total_name_1 = total_name_1 + name_1;

			}
		}

		for (int store_num_2 = num_2; store_num_2 <= num_2_max_index; store_num_2++) {
			char name_2 = Guide.userinput.charAt(store_num_2);

			total_name_2 = total_name_2 + name_2;

		}

		Guide.textarea.append("\nSaved Reciept: ");
		if (Guide.userinput.contains("-")) {
			Guide.textarea.append("\nCustomer has -$" + total_name_1 + " in his wallet!");
		} else {
			Guide.textarea.append("\nCustomer has $" + total_name_1 + " in his wallet!");
		}

		Guide.textarea.append("\nTrader fxxfx has $" + total_name_2 + " in his cashbox!");
	}

}
