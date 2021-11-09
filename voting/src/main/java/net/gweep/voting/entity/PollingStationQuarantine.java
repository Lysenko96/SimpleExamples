package net.gweep.voting.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollingStationQuarantine extends PollingStation {

	public PollingStationQuarantine(int id, Address address, List<Citizen> citizens, int voterCounter, String name) {
		super(id, address, citizens, voterCounter, name);
	}

	public List<Citizen> getQuarantine() {
		return getActualCitizen(Citizen::isQuarantine);
	}
}