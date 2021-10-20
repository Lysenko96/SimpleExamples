package net.gweep.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// System.out.println(new Main().nestedMap());
		System.out.println(new Main().nestedMapNew());
	}

//	public Map<String, Map<Integer, List<String>>> nestedMap() {
//		Map<String, Map<Integer, List<String>>> map = null;
//		BufferedReader reader;
//		try {
//			reader = Files.newBufferedReader(Paths.get("/home/gweep/eclipse-workspace/lambda/SonnetI.txt"),
//					StandardCharsets.UTF_8);
//			map = reader.lines().flatMap(s -> Stream.of(s.split("\\W+"))).filter(s -> !s.isEmpty())
//					.collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.groupingBy(String::length)));
//			reader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return map;
//	}

	// For example, given the words "foo bar baz bazz" the string
	// representation of the result would be:
//	     {f={3=[foo]}, b={3=[bar, baz], 4=[bazz]}}.

	public Map<String, Map<Integer, List<String>>> nestedMapNew() {
		Map<String, Map<Integer, List<String>>> map = new HashMap<>();
		Map<Integer, List<String>> nMap = new HashMap<>();
		BufferedReader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("/home/gweep/eclipse-workspace/lambda/SonnetI.txt"),
					StandardCharsets.UTF_8);
//			List<String> strings = reader.lines().flatMap(s -> Stream.of(s.split("\\W+"))).filter(s -> !s.isEmpty())
//					.map(String::toLowerCase).collect(Collectors.toList());

			List<String> strings = reader.lines().flatMap(s -> Stream.of(s.split("\\W+"))).filter(s -> !s.isEmpty())
					.collect(Collectors.toList());

			for (String s : strings) {
				nMap.put(s.length(), null);
			}
			// System.out.println(nMap);

			for (Map.Entry<Integer, List<String>> pair : nMap.entrySet()) {
				// Set<String> list = new HashSet<>();
				List<String> list = new ArrayList<>();
				for (String s : strings) {
					if (s.length() == pair.getKey()) {
						list.add(s);
					}
				}
				// System.out.println(list);
				List<String> l = new ArrayList<>(list);
				nMap.put(l.get(0).length(), l);
			}
			// System.out.println(nMap);
			for (Map.Entry<Integer, List<String>> pair : nMap.entrySet()) {
				for (String st : pair.getValue()) {
					map.put(st.substring(0, 1), null);
				}
			}
			// System.out.println(map);

			for (Map.Entry<String, Map<Integer, List<String>>> pair : map.entrySet()) {
				Map<Integer, List<String>> newMap = new HashMap<>();
				for (Map.Entry<Integer, List<String>> pairTwo : nMap.entrySet()) {
					List<String> lis = new ArrayList<>();
					for (String s : pairTwo.getValue()) {
						if (pair.getKey().equals(s.substring(0, 1))) {
							lis.add(s);
						}
					}
					// System.out.println(lis);

					if (!lis.isEmpty()) {
						newMap.put(lis.get(0).length(), lis);
						map.put(lis.get(0).substring(0, 1), newMap);
					}
				}
			}
			// System.out.println(map);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<Person> findKids(List<Person> people) {
		return people.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
	}
}
