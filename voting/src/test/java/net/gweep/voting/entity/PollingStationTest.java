package net.gweep.voting.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PollingStationTest {

	List<Citizen> citizens;
	Party party, party2;
	PollingStation station;
	Citizen citizen;
	Citizen citizen2;

	@BeforeEach
	void setUp() {
		citizens = new ArrayList<>();
		party = new Party("party", Fraction.LEFT, LocalDate.now(), new ArrayList<>());
		party2 = new Party("party2", Fraction.CENTER, LocalDate.now(), new ArrayList<>());
		station = new PollingStation(1, new Address(), citizens, citizens.size(), "station");
		citizen = new Citizen("name", "DK12344321", 1233211231, 2008, station, party, true, false, true);
		citizen2 = new Citizen("name2", "DK12344322", 1233211232, 2000, station, party2, false, true, true);
		citizens.add(citizen);
		citizens.add(citizen2);
		station.setCitizens(citizens);
	}

	@Test
	void getCitizensCanVoteTest() {
		assertEquals(List.of(citizen2), station.getCitizensCanVote());
	}

	@Test
	void getActualCitizenTest() {
		assertEquals(List.of(citizen2), station.getActualCitizen(Citizen::isQuarantine));
		assertEquals(List.of(citizen), station.getActualCitizen(Citizen::isSecretService));
	}

	@Test
	void getMapPartyVoterCounterTest() {
		Map<Party, Long> expected = new HashMap<>();
		expected.put(party, 1l);
		expected.put(party2, 1l);
		assertEquals(expected, station.getMapPartyVoterCounter());
	}
}