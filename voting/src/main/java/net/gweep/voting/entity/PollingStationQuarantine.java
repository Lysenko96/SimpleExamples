package net.gweep.voting.entity;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PollingStationQuarantine extends PollingStation {

	PollingStationQuarantine(int id, Address address, List<Citizen> citizens, int voterCounter,
			Map<Party, Integer> partyVoterCounter) {
		super(id, address, citizens, voterCounter, partyVoterCounter);
	}
}
