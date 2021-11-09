package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.exception.IncorrectVoteCitizenAgeException;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.groupingBy;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollingStation {

	protected int id;
	protected Address address;
	protected List<Citizen> citizens;
	protected int voterCounter;
	protected String name;

	// additional exception if citizen < 18 catch and choice delete people or set
	// new age
	// main to do exception

	public List<Citizen> checkValidVoteCitizenAge() {
		Scanner in = new Scanner(System.in);
		List<Citizen> validCitizens = new ArrayList<>();
		List<Citizen> checked = new ArrayList<>();
		for (Citizen citizen : citizens) {
			try {
				checked = valid(citizen, validCitizens);
			} catch (IncorrectVoteCitizenAgeException e) {
				checked = recheck(citizen, validCitizens, in);
			} finally {
				in.close();
			}
		}
		return checked;
	}

	List<Citizen> valid(Citizen citizen, List<Citizen> validCitizens) throws IncorrectVoteCitizenAgeException {
		if ((LocalDate.now().getYear() - citizen.getYear()) < 18) {
			throw new IncorrectVoteCitizenAgeException("IncorrectVoteCitizenAgeException");
		} else {
			citizen.setYear(citizen.getYear());
			validCitizens.add(citizen);
		}
		return validCitizens;
	}

	List<Citizen> recheck(Citizen citizen, List<Citizen> validCitizens, Scanner in) {
		while (true) {
			System.out.print("Enter year that age >= 18: ");
			citizen.setYear(in.nextInt());
			if ((LocalDate.now().getYear() - citizen.getYear()) >= 18) {
				System.out.println(citizen);
				validCitizens.add(citizen);
				break;
			}
		}
		return validCitizens;
	}

	public List<Citizen> getCitizensCanVote() {
		citizens.removeIf(citizen -> (LocalDate.now().getYear() - citizen.getYear()) < 18);
		return citizens;
	}

	public Map<Party, Long> getMapPartyVoterCounter() {
		return citizens.stream().collect(groupingBy(Citizen::getParty, counting()));
	}

	public List<Party> getParties() {
		return citizens.stream().map(Citizen::getParty).collect(toList());
	}

	public Map<Party, Candidate> getMapPartyCandidate() {
		return getParties().stream().collect(toMap(p -> p, Party::getTopPartyCandidate));
	}

	public List<Citizen> getQuarantine(Predicate<Citizen> condition) {
		return citizens.stream().filter(condition).collect(toList());
	}
}
