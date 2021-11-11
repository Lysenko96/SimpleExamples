package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voting {

	private LocalDate date;
	private List<Party> parties;
	private List<Citizen> citizens;
	private List<PollingStation> stations;

	public List<Citizen> getVoteCitizens() {
		return citizens.stream().filter(Citizen::isVote).collect(toList());
	}

	public void setCitizensByParty() {
		try {
			Scanner in = new Scanner(System.in);
			for (Party party : parties) {
				System.out.println(parties.indexOf(party) + " - " + party.getName());
			}
			for (Citizen citizen : getVoteCitizens()) {
				if (citizen.getParty() == null) {
					System.out.print("Enter party: ");
					int value = in.nextInt();
					citizen.setParty(parties.get(value));
				}
			}
		} finally {
			System.out.println(getVoteCitizens());
		}
	}

	public List<String> showStationCountVoter() {
		List<String> lines = new ArrayList<>();
<<<<<<< HEAD
		for (Station station : stations) {
=======
		for (PollingStation station : stations) {
>>>>>>> f08b87392de270d2d0c52e1d7df8b1f9533a857a
			lines.add(station.getClass().getSimpleName());
			System.out.println(station.getClass().getSimpleName());
			for (Map.Entry<Party, Long> pair : station.getMapPartyVoterCounter().entrySet()) {
				lines.add(pair.getKey().getName() + " = " + pair.getValue());
				System.out.println(pair.getKey().getName() + " = " + pair.getValue());
			}
		}
		return lines;
	}
}