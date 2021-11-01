package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

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
	protected StationType type;

	// additional exception if citizen < 18 catch and choice delete people or set
	// new age

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

	public List<Citizen> getQuarantine() {
		return citizens.stream().filter(citizen -> citizen.isQuarantine).collect(toList());
	}

	public List<Citizen> getSercretService() {
		return citizens.stream().filter(citizen -> citizen.isSecretService).collect(toList());
	}
}