package net.gweep.voting.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PollingStation {

	private int id;
	private Address address;
	private List<Citizen> citizens;
	private int voterCounter;
	private Map<Party, Integer> partyVoterCounter;
	
}
