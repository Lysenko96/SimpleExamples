package net.gweep.voting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;

import net.gweep.voting.entity.Address;
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Fraction;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;
import net.gweep.voting.entity.StationType;
import net.gweep.voting.entity.Voting;
import net.gweep.voting.menu.Menu;
import net.gweep.voting.repo.Repository;

public class Main {

	public static void main(String[] args) {

//		Citizen citizen11 = new Citizen("name4", "bk103454", 1122334458, 1996, new Station(), new Party(), true, false, false);
//		citizen11.setIdCard(12345643221l);
//		System.out.println(citizen11);

		// ================================================

		List<Citizen> citizens = new ArrayList<>();
		Party party = new Party("party", Fraction.CENTER, LocalDate.now(), null);
		Party party2 = new Party("party2", Fraction.LEFT, LocalDate.now().minusDays(3), null);
		// Party party3 = new Party("party3", Fraction.RIGTH,
		// LocalDate.now().minusDays(4), null);
		Citizen citizen = new Citizen("name2", "bk103452", 1122334456, 2005, new Station(), party, false, true, true);
		// Citizen citizen2 = new Citizen("name3", "bk103453", 1122334457, 1994, null,
		// party3, true, false);
		Citizen citizen3 = new Citizen("name4", "bk103454", 1122334458, 1996, new Station(), party2, true, false,
				false);

		citizens.add(citizen);
		// citizens.add(citizen2);
		citizens.add(citizen3);
		List<Party> parties = new ArrayList<>();
		parties.add(party);
		parties.add(party2);
		// parties.add(party3);

		// enter list for every station by condition

		Station station = new Station(1, new Address("street", 9), new ArrayList<>(), 0, StationType.STATION);
		Station stationQuarantine = new Station(2, new Address("street2", 10), new ArrayList<>(), 0,
				StationType.QUARANTINE);
		Station secretService = new Station(3, new Address("street3", 11), new ArrayList<>(), 0,
				StationType.SECRETSERVICE);

		citizen.setStation(secretService);
		citizen3.setStation(stationQuarantine);
		List<Citizen> quarantine = new ArrayList<>();
		List<Citizen> stationList = new ArrayList<>();
		List<Citizen> secretServiceList = new ArrayList<>();
		for (Citizen people : station.getCitizens()) {
			if (people.isQuarantine()) {
				people.setStation(stationQuarantine);
				quarantine.add(people);
				stationQuarantine.setCitizens(quarantine);
			} else if (people.isSecretService()) {
				people.setStation(secretService);
				secretServiceList.add(people);
				secretService.setCitizens(secretServiceList);
			} else {
				people.setStation(station);
				stationList.add(people);
				station.setCitizens(stationList);
			}
		}
		Candidate candidate = new Candidate("name", "bk103451", 1122334455, 1994, null, party, false, false, true, 3);
		Candidate candidate1 = new Candidate("name1", "bk103459", 1122334459, 1999, null, party2, false, true, true, 1);
		Candidate candidate2 = new Candidate("name2", "bk103460", 1122334460, 1997, null, party, false, true, true, 2);

		List<Candidate> candidates = List.of(candidate, candidate1, candidate2);

		for (Citizen people : candidates) {
			if (people.isQuarantine()) {
				people.setStation(stationQuarantine);
				quarantine.add(people);
				stationQuarantine.setCitizens(quarantine);
			} else if (people.isSecretService()) {
				people.setStation(secretService);
				secretServiceList.add(people);
				secretService.setCitizens(secretServiceList);
			} else {
				people.setStation(station);
				stationList.add(people);
				station.setCitizens(stationList);
			}
		}

		station.setVoterCounter(stationList.size());
		stationQuarantine.setVoterCounter(quarantine.size());
		secretService.setVoterCounter(secretServiceList.size());

		party.setCandidaties(List.of(candidate, candidate2));
		party2.setCandidaties(List.of(candidate1));
		Repository repo = new Repository();
		repo.setCitizens(citizens);
		repo.setParties(parties);
		repo.setStations(new ArrayList<>(List.of(station, stationQuarantine, secretService)));

//		for (Map.Entry<Party, Candidate> pair : station.getMapPartyCandidate().entrySet()) {
//			System.out.println(pair.getKey().getName());
//			System.out.println(pair.getValue());
//		}
		// System.out.println(station.getMapPartyCandidate());
		// repo.setPartyCandidate(citizen3, 2);

		repo.addCitizen(new Citizen("name55", "bk103411", 1122334451, 1969, station, null, true, false, true));

		// System.out.println(party.getCandidaties());

		repo.addPartyCandidate(
				new Candidate("name222", "vz103460", 1122332260, 1937, station, party, false, false, true, 2));

		Voting voting = new Voting(LocalDate.now().plusDays(1), repo.getParties(), repo.getCitizens(),
				repo.getStations());

		Menu menu = new Menu();

		menu.show(repo);

		// voting.setCitizensByParty();

		// System.out.println(repo.getCitizens());

		// System.out.println(repo.getStations());

		// System.out.println(voting.getVoteCitizens());

//		for (Station st : voting.getStations()) {
//			System.out.println(st);
//		}

		// System.out.println(voting.getCitizens());

//		System.out.println(voting.getCitizens());

		// System.out.println(secretService.getCitizens());

		// System.out.println(party.getCandidaties());

//		System.out.println(party.getCandidaties());
//		
//		repo.deletePartyCandidate(1122332260);
//		
//		System.out.println(party.getCandidaties());

		// System.out.println(party.getCandidaties());

		// System.out.println(station.getMapPartyVoterCounter());

//		for (Map.Entry<Party, Candidate> pair : station.getMapPartyCandidate().entrySet()) {
//			System.out.println(pair.getKey().getName());
//			System.out.println(pair.getValue());
//		}

//		for (Map.Entry<Station, List<Citizen>> pair : repo.getMapStationCitizens().entrySet()) {
//			System.out.println(pair.getKey());
//			System.out.println(pair.getValue());
//		}
//		System.out.println(station.getCitizens());
//		Citizen citizen111 = new Citizen("name55", "bk103411", 1122334452, 1969, station, party2, true, false);
//		repo.addCitizenByStationId(station.getId(), citizen111);
//		System.out.println(station.getCitizens());
//		repo.deleteCitizenCardByStaionIdByIdCard(station.getId(), citizen111.getIdCard());
//		System.out.println(station.getCitizens());
//		for (Map.Entry<Station, List<Citizen>> pair : repo.getMapStationCitizens().entrySet()) {
//			System.out.println(pair.getKey());
//			System.out.println(pair.getValue());
//		}

		// System.out.println(station.getMapPartyCandidate());
		// party3.setCandidaties(List.of(candidate2));
		// party.setCandidaties(candidates);
		// System.out.println(party.getPartyCandidate());
		// System.out.println(station.checkValidVoteCitizenAge());
		// System.out.println(stationQuarantine.getQuarantine());
//		System.out.println(sercretService.getSercretService());
		// System.out.println(station.getCitizens());
	}

}