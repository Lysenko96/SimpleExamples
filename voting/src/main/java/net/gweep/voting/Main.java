package net.gweep.voting;

//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import net.gweep.voting.entity.Address;
//import net.gweep.voting.entity.Candidate;
//import net.gweep.voting.entity.Citizen;
//import net.gweep.voting.entity.Fraction;
//import net.gweep.voting.entity.Party;
//import net.gweep.voting.entity.PollingStation;
//import net.gweep.voting.entity.PollingStationQuarantine;
//import net.gweep.voting.entity.PollingStrationSercretService;

public class Main {

	public static void main(String[] args) {

//		Citizen citizen11 = new Citizen();
//		citizen11.setIdCard(123456432l);
//		System.out.println(citizen11.getIdCard());

		// ================================================

//		List<Citizen> citizens = new ArrayList<>();
//		Party party = new Party("party", Fraction.CENTER, LocalDate.now(), null);
//		Party party2 = new Party("party2", Fraction.LEFT, LocalDate.now().minusDays(3), null);
//		Citizen citizen = new Citizen("name2", "bk103452", 1122334456, 2005, null, party, false, false);
//		Citizen citizen2 = new Citizen("name3", "bk103453", 1122334457, 1994, null, party, true, false);
//		Citizen citizen3 = new Citizen("name4", "bk103454", 1122334458, 1996, null, party2, false, true);
//		citizens.add(citizen);
//		citizens.add(citizen2);
//		citizens.add(citizen3);
//		PollingStation station = new PollingStation(1, new Address("street", 9), citizens, citizens.size());
//		PollingStationQuarantine stationQuarantine = new PollingStationQuarantine(2, new Address("street2", 10),
//				citizens, citizens.size());
//		PollingStrationSercretService sercretService = new PollingStrationSercretService(3, new Address("street3", 11),
//				citizens, citizens.size());
//		for (Citizen people : station.getCitizensCanVote()) {
//			if (people.isQuarantine()) {
//				people.setStation(stationQuarantine);
//			} else if (people.isSecretService()) {
//				people.setStation(sercretService);
//			} else {
//				people.setStation(station);
//			}
//		}
//		Candidate candidate = new Candidate("name", "bk103451", 1122334455, 1994, null, party, false, false, 0);
//		Candidate candidate1 = new Candidate("name1", "bk103459", 1122334459, 1999, null, party2, false, false, 0);
//		candidate.setStation(station);
//		candidate1.setStation(station);
//		party.setCandidaties(List.of(candidate));
//		party2.setCandidaties(List.of(candidate1));
//		System.out.println(stationQuarantine.getQuarantine());
//		System.out.println(sercretService.getSercretService());
//		System.out.println(station.getCitizens());
	}
}