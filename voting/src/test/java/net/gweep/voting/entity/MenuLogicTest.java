package net.gweep.voting.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.gweep.voting.menu.MenuLogic;
import net.gweep.voting.repo.Repository;

class MenuLogicTest {

	Repository repoExc;
	Repository repoAct;
	MenuLogic menuLogic;

	@BeforeEach
	void setUp() {
		menuLogic = new MenuLogic();
		repoExc = new Repository(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());
		repoExc.addStation(new PollingStation(1, new Address("street", 9), null, 0, "PollingStation"));
		repoAct = new Repository(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());
		menuLogic.addStationSelect(repoAct, 1);
	}

	@Test
	void test() {
		PollingStation station = repoExc.getStationById(1);
		station.setCitizens(new ArrayList<>());
		assertEquals(station, repoAct.getStationById(1));
	}

}
