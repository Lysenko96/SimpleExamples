package te.lesson2.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Map<Integer, Integer> price = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);
	private static Order order = new Order();
	private static PayStrategy strategy;

	static {
		price.put(1, 2250);
		price.put(2, 1600);
		price.put(3, 900);
		price.put(4, 3700);
	}

	public static void main(String[] args) {

		while (!order.isClosed()) {

			int cost;

			String aContinue;

			do {
				System.out.print("Please, select a product:" + System.lineSeparator() + "1 - TV"
						+ System.lineSeparator() + "2 - Smartphone" + System.lineSeparator() + "3 - Car"
						+ System.lineSeparator() + "4 - Motocyrcle" + System.lineSeparator());
				int choice = scanner.nextInt();
				cost = price.get(choice);
				System.out.print("Count: ");
				int count = scanner.nextInt();
				order.setTotal(count * cost);
				System.out.print("Do you want continue selecting product? Y/N: ");
				aContinue = scanner.next();
			} while (aContinue.equalsIgnoreCase("Y"));

			if (strategy == null) {
				System.out.println("Please, select a payment method:" + System.lineSeparator() + "1 - PalPay"
						+ System.lineSeparator() + "2 - Credit Card");

				String payment = scanner.next();

				if (payment.equals("1")) {
					strategy = new PayPal();
				} else if (payment.equals("2")) {
					strategy = new PayCreditCard();
				} else {
					System.out.println("not found");
				}
			}
			order.process(strategy);

			System.out.print("Pay " + order.getTotal() + " units or Continue? P/C: ");
			String proceed = scanner.next();
			if (proceed.equalsIgnoreCase("P")) {
				if (strategy.pay(order.getTotal())) {
					System.out.println("Payment successful.");
				} else {
					System.out.println("FAIL! Check data.");
				}
				order.setClosed(true);
			}

		}
	}
}
