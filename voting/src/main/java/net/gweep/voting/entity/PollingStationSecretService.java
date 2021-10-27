package net.gweep.voting.entity;

import java.util.List;
import java.util.Map;

public class PollingStationSecretService extends PollingStation {

	PollingStationSecretService(int id, Address address, List<Citizen> citizens, int voterCounter,
			Map<Party, Integer> partyVoterCounter) {
		super(id, address, citizens, voterCounter, partyVoterCounter);
	}
}
