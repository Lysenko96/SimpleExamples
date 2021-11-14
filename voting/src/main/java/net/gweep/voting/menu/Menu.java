package net.gweep.voting.menu;

import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

import static java.lang.System.lineSeparator;

import java.time.LocalDate;

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
				logic.addStationSelect(repo, id);
			} else if (value == 2) {
				logic.addCitizenSelect(repo);
			} else if (value == 3) {
				logic.addPartySelect(repo);
			} else if (value == 4) {
				logic.setPartyCandidateSelect(repo, voting);
			} else if (value == 5) {
				logic.showStationSelect(repo, voting);
			} else if (value == 6) {
				logic.showCitizensSelect(repo);
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