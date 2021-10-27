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

	private Party party;
	private int primaries;

	Candidate(String name, String passNumber, long idCard, int year, PollingStation station, boolean isSecretService,
			boolean isQuarantine, Party party, int primeries) {
		super(name, passNumber, idCard, year, station, isSecretService, isQuarantine);
		this.party = party;
		this.primaries = primeries;
	}
}
