package food;


public class Potato {
	String poisionious_potatoes;
	int num_potatoes = (int) (Math.random() * 100);
	public double potato_price_per_kg = 1;

	public void sell_potatoes() {
		System.out.println("Trader has " + num_potatoes + " potatoes!");
		System.out.println("They cost a total of $" + potato_price_per_kg + " per kg!");
	}

	public String potato_math() {
		double total_price = potato_price_per_kg * num_potatoes;
		String total_price_display = "The total price is $" + total_price;
		return total_price_display;
	}

	public double potato_total_price() {
		double total_price = potato_price_per_kg * num_potatoes;

		return total_price;
	}
}