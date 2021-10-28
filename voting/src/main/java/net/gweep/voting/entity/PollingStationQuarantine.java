package net.gweep.voting.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PollingStationQuarantine extends PollingStation {
	
	private List<Citizen> quarantine = new ArrayList<>();
	
	public PollingStationQuarantine(int id, Address address, List<Citizen> citizens, int voterCounter) {
		super(id, address, citizens, voterCounter);
		//need clone citizens change data in citizens when change in quarantine
		quarantine = citizens;
		System.out.println(quarantine);
		quarantine.removeIf(citizen -> !citizen.isQuarantine());
		System.out.println(citizens);
	}
}