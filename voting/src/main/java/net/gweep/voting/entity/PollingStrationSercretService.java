package net.gweep.voting.entity;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PollingStrationSercretService extends PollingStation {
	
	public PollingStrationSercretService(int id, Address address, List<Citizen> citizens, int voterCounter) {
		super(id, address, citizens, voterCounter);
	}
	
	public List<Citizen> getSercretService() {
		return citizens.stream().filter(citizen -> citizen.isSecretService).collect(toList());
	}
}