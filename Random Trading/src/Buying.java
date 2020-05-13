// Sets up stuff so it is easy to subtract total cash in the customer's pockets and from the trader (add)

class Buy {

	int customer_wallet, villager_cashbox;
	// the customer sets the amount of cash in their wallet and the villager is
	// given a random amount of cash!

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
