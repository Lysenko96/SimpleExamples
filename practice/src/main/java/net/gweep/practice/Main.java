package net.gweep.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
//		try (BufferedReader reader = new BufferedReader(
//				new FileReader("/home/gweep/eclipse-workspace/practice/file.txt"))) {

//			String line;
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
		// reader.lines().forEach(System.out::println);

//			System.out.println(reader.lines().map(User::parse).collect(Collectors.toList()));
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("IO exception");
//		}

		District district = new District();
		District district2 = new District();

		List<District> districts = List.of(district, district2);
		district.getVotes().put(new Party("first"), 10);
		district2.getVotes().put(new Party("first"), 6);
		district.getVotes().put(new Party("second"), 11);
		district2.getVotes().put(new Party("second"), 11);

		Map<Party, Integer> map = sumVotes(districts);
		System.out.println(map);
	}

	public Map<Party, Integer> sumVotes(List<District> d) {
		return d.stream().map(District::getVotes).map(Map::entrySet).flatMap(Collection::stream)
				.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
	}

}