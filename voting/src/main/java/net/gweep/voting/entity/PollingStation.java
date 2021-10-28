package net.gweep.voting.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollingStation {

	protected int id;
	protected Address address;
	protected List<Citizen> citizens;
	protected int voterCounter;

	public List<Citizen> getCitizensCanVote() {
		citizens.removeIf(citizen -> citizen.getYear() < 18);
		return citizens;
	}

	public Map<Party, Long> getPartyVoterCounter() {
		return citizens.stream().collect(Collectors.groupingBy(Citizen::getParty, Collectors.counting()));
	}

	@Override
	public String toString() {
		return "PollingStation [id=" + id + ", address=" + address + ", voterCounter=" + voterCounter + "]";
	}
	
}
