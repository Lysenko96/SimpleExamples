package net.gweep.voting.entity;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.exception.IncorrectDigitsCountException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

	protected String name;
	protected String passNumber;
	protected long idCard;
	protected int year;
	protected PollingStation station;
	protected Party party;
	protected boolean isSecretService;
	protected boolean isQuarantine;
	protected boolean isVote;

	public Citizen(Candidate candidate) {
		this(candidate.getName(), candidate.getPassNumber(), candidate.getIdCard(), candidate.getYear(),
				candidate.getStation(), candidate.getParty(), candidate.isQuarantine(), candidate.isSecretService(),
				candidate.isVote());
	}

	public void setValidIdCard(long idCard) {
		Scanner in = new Scanner(System.in);
		try {
			valid(idCard);
		} catch (IncorrectDigitsCountException e) {
			recheck(idCard, in);
		}
	}

	public void valid(long idCard) throws IncorrectDigitsCountException {
		int counter = 0;
		long temp = idCard;
		counter = getCounter(temp, counter);
		if (counter != 10) {
			throw new IncorrectDigitsCountException("IncorrectDigitsCountException");
		} else {
			this.idCard = idCard;
		}
	}

	public void recheck(long idCard, Scanner in) {
		int counter = 0;
		long temp = idCard;
		counter = getCounter(temp, counter);
		if (counter == 10) {
			this.idCard = idCard;
		}
		while (true) {
			counter = 0;
			System.out.print("Enter idCard (10 digits): ");
			idCard = in.nextLong();
			temp = idCard;
			counter = getCounter(temp, counter);
			if (counter == 10) {
				this.idCard = idCard;
				break;
			}
		}
	}

	public int getCounter(long temp, int counter) {
		while (temp > 0) {
			temp /= 10;
			counter++;
		}
		return counter;
	}

	public void setIdCard(long idCard) {
		setValidIdCard(idCard);
	}

	public long getIdCard() {
		return idCard;
	}

	@Override
	public String toString() {
		if (station != null && party != null) {
			return getString(station.getClass().getSimpleName(), party.getName());
		} else if (party != null) {
			return getString(null, party.getName());
		} else if (station != null) {
			return getString(station.getClass().getSimpleName(), null);
		} else {
			return getString(null, null);
		}
	}

	public String getString(String station, String party) {
		return "Citizen [name=" + name + ", passNumber=" + passNumber + ", idCard=" + idCard + ", year=" + year
				+ ", station=" + station + ", party=" + party + ", isSecretService=" + isSecretService
				+ ", isQuarantine=" + isQuarantine + ", isVote=" + isVote + "]";
	}
}