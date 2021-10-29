package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.exception.IncorrectVoteCitizenAgeException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollingStation {

	protected int id;
	protected Address address;
	protected List<Citizen> citizens;
	protected int voterCounter;

	// additional exception if citizen < 18 catch and choice delete people or set
	// new age
	// main to do exception

	public List<Citizen> checkValidVoteCitizenAge() {
		Scanner in = new Scanner(System.in);
		for (Citizen citizen : citizens) {
			try {
				if ((LocalDate.now().getYear() - citizen.getAge()) < 18) {
					throw new IncorrectVoteCitizenAgeException("IncorrectVoteCitizenAgeException");
				} else {
					citizen.setAge(citizen.getAge());
				}
			} catch (IncorrectVoteCitizenAgeException e) {
				while (true) {
					System.out.print("Enter age >= 18: ");
					citizen.setAge(in.nextInt());
					if (citizen.getAge() >= 18) {
						System.out.println(citizen);
						break;
					}
				}

			} finally {
				in.close();
			}
		}
		return null;
	}

	public List<Citizen> getCitizensCanVote() {
		citizens.removeIf(citizen -> (LocalDate.now().getYear() - citizen.getAge()) < 18);
		return citizens;
	}

	public Map<Party, Long> getPartyVoterCounter() {
		return citizens.stream().collect(Collectors.groupingBy(Citizen::getParty, Collectors.counting()));
	}
}
