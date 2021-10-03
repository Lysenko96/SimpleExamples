package te.lesson2.strategy;

public class CreditCard {

	private int balance;
	private int number;
	private String date;
	private int cvv;

	public CreditCard() {
	}

	public CreditCard(int number, String date, int cvv) {
		this.balance = 10_000;
		this.number = number;
		this.date = date;
		this.cvv = cvv;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}