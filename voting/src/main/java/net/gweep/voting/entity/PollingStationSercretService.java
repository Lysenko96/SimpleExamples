package net.gweep.voting.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PollingStationSercretService extends PollingStation {
	
	public PollingStationSercretService(int id, Address address, List<Citizen> citizens, int voterCounter, String name) {
		super(id, address, citizens, voterCounter, name);
	}
	
	public List<Citizen> getSercretService() {
		return getActualCitizen(Citizen::isSecretService);
	}
}