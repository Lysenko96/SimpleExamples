package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {

	protected int id;
	protected Address address;
	protected List<Citizen> citizens;
	protected int voterCounter;

	// additional exception if citizen < 18 catch and choice delete people or set
	// new age

	public List<Citizen> getCitizensCanVote() {
		citizens.removeIf(citizen -> (LocalDate.now().getYear() - citizen.getYear()) < 18);
		return citizens;
	}

	public Map<Party, Long> getMapPartyVoterCounter() {
		return citizens.stream().collect(Collectors.groupingBy(Citizen::getParty, Collectors.counting()));
	}

	public List<Party> getParties() {
		return citizens.stream().map(Citizen::getParty).collect(Collectors.toList());
	}

	public Map<Party, Candidate> getMapPartyCandidate() {
		return getParties().stream().collect(Collectors.toMap(p -> p, Party::getTopPartyCandidate));
	}
}