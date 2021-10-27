package net.gweep.voting.entity;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.exception.IncorrectDigitsCountException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Citizen {

	private String name;
	private String passNumber;
	private long idCard;
	private int year;
	private PollingStation station;
	boolean isSecretService;
	boolean isQuarantine;

	
	public boolean checkIdCard(long idCard) {
		Scanner in = new Scanner(System.in);
		int counter = 0;
		boolean isActual = false;
		long temp = idCard;
		try {
			while (temp > 0) {
				temp /= 10;
				counter++;
			}
			if (counter != 10) {
				throw new IncorrectDigitsCountException("IncorrectDigitsCountException");
			}
		} catch (IncorrectDigitsCountException e) {
			while (true) {
				counter = 0;
				System.out.print("Enter idCard (10 digits): ");
				idCard = in.nextLong();
				temp = idCard;
				while (temp > 0) {
					temp /= 10;
					counter++;
				}
				if (counter == 10) {
					isActual = true;
					this.idCard = idCard;
					break;
				}
			}
		} finally {
			in.close();
		}
		return isActual;
	}
	
	public void setIdCard(long idCard) {
			this.idCard = idCard;
	}

	public long getIdCard() {
		return idCard;
	}
}