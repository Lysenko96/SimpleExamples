package net.gweep.voting.entity;

import java.time.LocalDate;
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
	private List<Station> stations;

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

	public void showStationCountVoter() {
		for (Station station : stations) {
			System.out.println(station.getType());
			for (Map.Entry<Party, Long> pair : station.getMapPartyVoterCounter().entrySet()) {
				System.out.println(pair.getKey().getName() + " = " + pair.getValue());
			}
		}
	}
}