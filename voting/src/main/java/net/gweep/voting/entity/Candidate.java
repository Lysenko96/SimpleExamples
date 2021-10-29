package net.gweep.voting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends Citizen {

	private int primaries;

	public Candidate(String name, String passNumber, long idCard, int year, PollingStation station, Party party,
			boolean isSecretService, boolean isQuarantine, int primeries) {
		super(name, passNumber, idCard, year, station, party, isSecretService, isQuarantine);
		this.primaries = primeries;
	}

	@Override
	public String toString() {
		return "Candidate [primaries=" + primaries + ", name=" + name + ", passNumber=" + passNumber + ", idCard="
				+ idCard + ", year=" + year + ", station=" + station + ", party=" + party.getName() + ", isSecretService="
				+ isSecretService + ", isQuarantine=" + isQuarantine + "]";
	}	
}