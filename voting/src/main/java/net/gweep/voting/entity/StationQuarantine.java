package net.gweep.voting.entity;

import java.util.List;

import static java.util.stream.Collectors.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StationQuarantine extends Station {

	public StationQuarantine(int id, Address address, List<Citizen> citizens, int voterCounter) {
		super(id, address, citizens, voterCounter);
	}

	public List<Citizen> getQuarantine() {
		return citizens.stream().filter(citizen -> citizen.isQuarantine).collect(toList());
	}
}