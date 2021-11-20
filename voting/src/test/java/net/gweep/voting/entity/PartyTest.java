package net.gweep.voting.entity;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartyTest {

	Party party;
	Candidate candidate;
	Candidate candidate2;
	Candidate candidate3;

	@BeforeEach
	void setUp() {
		party = new Party("name", Fraction.LEFT, LocalDate.now(), new ArrayList<>());
		candidate = new Candidate("name", "DK12344321", 1233211231, 2000, new PollingStation(), party, false, false,
				true, 3);
		candidate2 = new Candidate("name1", "DK12344322", 1233211232, 2001, new PollingStation(), party, false, false,
				true, 4);
		candidate3 = new Candidate("name2", "DK12344323", 1233211233, 1999, new PollingStation(), party, false, false,
				true, 2);
		List<Candidate> candidates = List.of(candidate, candidate2, candidate3);
		party.setCandidaties(candidates);
	}

	@Test
	void sortedByPrimariesTest() {
		assertEquals(List.of(candidate2, candidate, candidate3), party.sortedByPrimaries());
	}

	@Test
	void getTopPartyCandidateTest() {
		assertEquals(candidate2, party.getTopPartyCandidate());
	}

}