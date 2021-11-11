package net.gweep.voting.menu;

import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

import static java.lang.System.lineSeparator;

import java.time.LocalDate;

<<<<<<< HEAD
import net.gweep.voting.entity.Address;
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Fraction;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.QuarantineStation;
import net.gweep.voting.entity.SecretServiceStation;
import net.gweep.voting.entity.Station;
=======
>>>>>>> f08b87392de270d2d0c52e1d7df8b1f9533a857a
import net.gweep.voting.entity.Voting;
import net.gweep.voting.fileworker.FileWorker;
import net.gweep.voting.repo.Repository;

public class Menu {

	private static StringBuilder writeMenu = new StringBuilder("1 - write in file").append(lineSeparator())
			.append("2 - not write").append(lineSeparator()).append("Enter: ");
	private static FileWorker fileWorker = new FileWorker();
	private static Scanner in = new Scanner(System.in);

	public void show(Repository repo) {
		MenuLogic logic = new MenuLogic();
		Voting voting = new Voting(LocalDate.now().plusDays(1), repo.getParties(), repo.getCitizens(),
				repo.getStations());
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
			System.out.print("Enter value: ");
			value = in.nextInt();
			if (value == 1) {
<<<<<<< HEAD
				System.out.print("Enter street: ");
				String street = in.next();
				System.out.print("Enter number: ");
				int number = in.nextInt();
				List<String> types = List.of(Station.class.getClass().getSimpleName(),
						QuarantineStation.class.getClass().getSimpleName(),
						SecretServiceStation.class.getClass().getSimpleName());
				for (String type : types) {
					System.out.println(types.indexOf(type) + " - " + type);
				}
				System.out.print("Enter stationType: ");
				int stationIndex = in.nextInt();
				repo.addStation(
						new Station(++id, new Address(street, number), new ArrayList<>(), 0, types.get(stationIndex)));
				writeInFileStations(repo.getStations());
			} else if (value == 2) {
				System.out.print("Enter name: ");
				String name = in.next();
				System.out.print("Enter passNumber: ");
				String passNumber = in.next();
				System.out.print("Enter idCard: ");
				long idCard = in.nextLong();
				System.out.print("Enter year: ");
				int year = in.nextInt();
				List<String> types = List.of(Station.class.getClass().getSimpleName(),
						QuarantineStation.class.getClass().getSimpleName(),
						SecretServiceStation.class.getClass().getSimpleName());
				for (String type : types) {
					System.out.println(types.indexOf(type) + " - " + type);
				}
				System.out.print("Enter stationIndex: ");
				int stationIndex = in.nextInt();
				for (Party party : repo.getParties()) {
					System.out.println(repo.getParties().indexOf(party) + " - " + party.getName());
				}
				System.out.print("Enter partyIndex: ");
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
=======
				logic.addStationSelect(repo, id);
			} else if (value == 2) {
				logic.addCitizenSelect(repo);
>>>>>>> f08b87392de270d2d0c52e1d7df8b1f9533a857a
			} else if (value == 3) {
				logic.addPartySelect(repo);
			} else if (value == 4) {
				logic.setPartyCandidateSelect(repo, voting);
			} else if (value == 5) {
				logic.showStationSelect(repo, voting);
			} else if (value == 6) {
				System.out.println(repo.getCitizens());
				writeInFileObjects(repo.getCitizens().stream().map(c -> c).collect(toList()));
			} else if (value == 7) {
				logic.showPartiesSelect(repo);
			} else if (value == 8) {
				voting.setCitizensByParty();
			} else if (value == 9) {
				writeInFileObjects(voting.showStationCountVoter().stream().map(s -> s).collect(toList()));
			} else if (value == 10) {
				break;
			}
		}
	}

	static void writeInFileObjects(List<Object> objects) {
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print("Enter fileName: ");
			String fileName = in.next();
			fileWorker.writeObjects(objects, fileName);
		}
	}
}