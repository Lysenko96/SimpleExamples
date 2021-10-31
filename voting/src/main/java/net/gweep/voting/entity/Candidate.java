package net.gweep.voting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends Citizen {

	private int primaries;

	public Candidate(String name, String passNumber, long idCard, int year, Station station, Party party,
			boolean isSecretService, boolean isQuarantine, int primaries) {
		super(name, passNumber, idCard, year, station, party, isSecretService, isQuarantine);
		this.primaries = primaries;
	}

	public Candidate(Citizen citizen, int primaries) {
		super(citizen.getName(), citizen.getPassNumber(), citizen.getIdCard(), citizen.getYear(), citizen.getStation(),
				citizen.getParty(), citizen.isSecretService(), citizen.isQuarantine());
		this.primaries = primaries;
	}

	@Override
	public String toString() {
		return "Candidate [primaries=" + primaries + ", name=" + name + ", passNumber=" + passNumber + ", idCard="
				+ idCard + ", year=" + year + ", station=" + station.getClass().getSimpleName() + ", party="
				+ party.getName() + ", isSecretService=" + isSecretService + ", isQuarantine=" + isQuarantine + "]";
	}
}