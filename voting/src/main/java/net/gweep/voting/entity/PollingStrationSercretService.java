package net.gweep.voting.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PollingStrationSercretService extends PollingStation {

	//private List<Citizen> secretService = new ArrayList<>();
	
	public PollingStrationSercretService(int id, Address address, List<Citizen> citizens, int voterCounter) {
		super(id, address, citizens, voterCounter);
//		citizens.removeIf(citizen -> !citizen.isSecretService());
//		secretService = citizens;
	}
}