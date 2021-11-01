package net.gweep.voting.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

import static java.lang.System.lineSeparator;

import java.time.LocalDate;

import net.gweep.voting.entity.Address;
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Fraction;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;
import net.gweep.voting.entity.StationType;
import net.gweep.voting.entity.Voting;
import net.gweep.voting.fileworker.FileWorker;
import net.gweep.voting.repo.Repository;

public class Menu {

	private static StringBuilder writeMenu = new StringBuilder("1 - write in file").append(lineSeparator())
			.append("2 - not write").append(lineSeparator()).append("Enter: ");
	private static FileWorker fileWorker = new FileWorker();

	public void show() {
		Repository repo = new Repository();
		Voting voting = new Voting();
		Scanner in = new Scanner(System.in);
		StringBuilder menu = new StringBuilder("1 - add station").append(lineSeparator()).append("2 - add citizen")
				.append(lineSeparator()).append("3 - add party").append(lineSeparator())
				.append("4 - set party candidate").append(lineSeparator()).append("5 - show station")
				.append(lineSeparator()).append("6 - show citizens").append(lineSeparator()).append("7 - show parties")
				.append(lineSeparator()).append("8 - show voting").append(lineSeparator())
				.append("9 - show voting result").append(lineSeparator()).append("10 - exit").append(lineSeparator());
		int value = 0;
		int id = 0;
		while (true) {
			System.out.println(menu);
			value = in.nextInt();
			if (value == 1) {
				System.out.print("Enter street: ");
				String street = in.nextLine();
				System.out.print("Enter number: ");
				int number = in.nextInt();
				System.out.print("Enter stationType: ");
				List<StationType> types = Arrays.asList(StationType.values());
				for (StationType type : types) {
					System.out.println(types.indexOf(type) + " - " + type);
				}
				int stationIndex = in.nextInt();
				repo.addStation(
						new Station(++id, new Address(street, number), new ArrayList<>(), 0, types.get(stationIndex)));
				writeInFileStations(repo.getStations());
			} else if (value == 2) {
				System.out.print("Enter name: ");
				String name = in.nextLine();
				System.out.print("Enter passNumber: ");
				String passNumber = in.nextLine();
				System.out.print("Enter idCard: ");
				long idCard = in.nextLong();
				System.out.print("Enter year: ");
				int year = in.nextInt();
				List<StationType> types = Arrays.asList(StationType.values());
				for (StationType type : types) {
					System.out.println(types.indexOf(type) + " - " + type);
				}
				int stationIndex = in.nextInt();
				for (Party party : repo.getParties()) {
					System.out.println(repo.getParties().indexOf(party) + " - " + party.getName());
				}
				int partyIndex = in.nextInt();
				List<Boolean> flags = List.of(false, true);
				StringBuilder flagMenu = new StringBuilder(
						"0 - false" + lineSeparator() + "1 - true" + lineSeparator());
				System.out.print(flagMenu + "Enter isSecretService: ");
				int isSecretService = in.nextInt();
				System.out.print(flagMenu + "Enter isQuarantine: ");
				int isQuarantine = in.nextInt();
				System.out.print(flagMenu + "Enter isVote: ");
				int isVote = in.nextInt();
				Citizen citizen = new Citizen(name, passNumber, idCard, year, repo.getStations().get(stationIndex),
						repo.getParties().get(partyIndex), flags.get(isSecretService), flags.get(isQuarantine),
						flags.get(isVote));
				citizen.setValidIdCard(idCard);
				repo.addCitizen(citizen);
				writeInFileCitizens(repo.getCitizens());
			} else if (value == 3) {
				System.out.print("Enter name");
				String name = in.nextLine();
				List<Fraction> fractions = Arrays.asList(Fraction.values());
				for (Fraction fraction : fractions) {
					System.out.println(fractions.indexOf(fraction) + " - " + fraction);
				}
				int fractionIndex = in.nextInt();
				System.out.print("Enter year: ");
				int year = in.nextInt();
				System.out.print("Enter month (1-12): ");
				int month = in.nextInt();
				System.out.print("Enter day: ");
				int day = in.nextInt();
				repo.addParty(new Party(name, fractions.get(fractionIndex), LocalDate.of(year, month, day),
						new ArrayList<>()));
				writeInFileParties(repo.getParties());
			} else if (value == 4) {
				System.out.println(repo.getCitizens().stream().map(Citizen::getIdCard).collect(toList()));
				System.out.print("Enter idCard: ");
				long idCard = in.nextLong();
				Citizen citizen = repo.getCitizenByIdCard(idCard);
				System.out.print("Enter primaries: ");
				int primaries = in.nextInt();
				if (citizen.getParty() == null) {
					voting.setCitizensByParty();
				}
				repo.setPartyCandidate(citizen, primaries);
				Candidate candidate = new Candidate(citizen, primaries);
				repo.addPartyCandidate(candidate);
				repo.addCandidate(candidate);
				writeInFileCandidates(repo.getCandidates());
			} else if (value == 5) {
				System.out.println("1 - show stations" + lineSeparator() + "2 - add citizen by stationId"
						+ lineSeparator() + "3 - delete citizen by stationId, idCard");
				int index = in.nextInt();
				if (index == 1) {
					System.out.println(voting.getStations());
				} else if (index == 2) {
					System.out.println(repo.getStations().stream().map(Station::getId).collect(toList()));
					System.out.print("Enter stationId: ");
					int stationId = in.nextInt();
					System.out.println(repo.getCitizens().stream().map(Citizen::getIdCard).collect(toList()));
					System.out.print("Enter idCard: ");
					long idCard = in.nextLong();
					Citizen citizen = repo.getCitizenByIdCard(idCard);
					repo.addCitizenByStationId(stationId, citizen);
				} else if (index == 3) {
					System.out.println(repo.getStations().stream().map(Station::getId).collect(toList()));
					System.out.print("Enter stationId: ");
					int stationId = in.nextInt();
					System.out.println(repo.getCitizens().stream().map(Citizen::getIdCard).collect(toList()));
					System.out.print("Enter idCard: ");
					long idCard = in.nextLong();
					repo.deleteCitizenByStaionIdByIdCard(stationId, idCard);
				}
				writeInFileStations(repo.getStations());
			} else if (value == 6) {
				System.out.println(repo.getCitizens());
				writeInFileCitizens(repo.getCitizens());
			} else if (value == 7) {
				System.out.println("1 - show parties" + lineSeparator() + "2 - add party candidate" + lineSeparator()
						+ "3 - delete party candidate by idCard");
				int index = in.nextInt();
				if (index == 1) {
					System.out.println(repo.getParties());
				} else if (index == 2) {
					System.out.println(repo.getCitizens().stream().map(Citizen::getIdCard).collect(toList()));
					System.out.print("Enter idCard: ");
					long idCard = in.nextLong();
					Citizen citizen = repo.getCitizenByIdCard(idCard);
					System.out.print("Enter primaries: ");
					int primaries = in.nextInt();
					repo.addPartyCandidate(new Candidate(citizen, primaries));
				} else if (index == 3) {
					System.out.println(repo.getCitizens().stream().map(Citizen::getIdCard).collect(toList()));
					System.out.print("Enter idCard: ");
					long idCard = in.nextLong();
					repo.deletePartyCandidate(idCard);
				}
				writeInFileParties(repo.getParties());
			} else if (value == 8) {
				voting.setCitizensByParty();
				writeInFileVotings(repo.getVotings());
			} else if (value == 9) {
				voting.showStationCountVoter();
				writeInFileVotings(repo.getVotings());
			} else if (value == 10) {
				break;
			}
			in.close();
		}
	}

	static void writeInFileStations(List<Station> stations) {
		Scanner in = new Scanner(System.in);
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeStations(stations, fileName);
		}
		in.close();
	}

	static void writeInFileCitizens(List<Citizen> citizens) {
		Scanner in = new Scanner(System.in);
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeCitizens(citizens, fileName);
		}
		in.close();
	}

	static void writeInFileParties(List<Party> parties) {
		Scanner in = new Scanner(System.in);
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeParties(parties, fileName);
		}
		in.close();
	}

	static void writeInFileCandidates(List<Candidate> candidates) {
		Scanner in = new Scanner(System.in);
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeCandidates(candidates, fileName);
		}
		in.close();
	}

	static void writeInFileVotings(List<Voting> votings) {
		Scanner in = new Scanner(System.in);
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeVotings(votings, fileName);
		}
		in.close();
	}
}