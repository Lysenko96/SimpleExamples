package te.lesson2.strategy;

import java.util.Scanner;

public class PayCreditCard implements PayStrategy {

	private final Scanner scanner = new Scanner(System.in);
	private CreditCard card;

	@Override
	public boolean pay(int money) {
		if (card != null) {
			System.out.println("Paying " + money + " using CreditCard.");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void getInfo() {
		System.out.print("Enter card number: ");
		int number = scanner.nextInt();
		System.out.print("Enter card expiration date 'mm/yy': ");
		String date = scanner.nextLine();
		int cvv = scanner.nextInt();
		card = new CreditCard(number, date, cvv);
	}
}