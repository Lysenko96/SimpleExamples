package net.gweep.voting.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PollingStationQuarantine extends PollingStation {

	public PollingStationQuarantine(int id, Address address, List<Citizen> citizens, int voterCounter) {
		super(id, address, citizens, voterCounter);
	}

	public List<Citizen> getQuarantine() {
		List<Citizen> quarantine = new ArrayList<>();
		for (Citizen citizen : citizens) {
			if (citizen.isQuarantine) {
				quarantine.add(citizen);
			}
		}
		return quarantine;
	}
}