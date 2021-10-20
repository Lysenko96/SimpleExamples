package net.gweep.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Main().nestedMapNew());
	}

	// get nested map world length and null
	public Map<Integer, List<String>> getNestedMapWorldLengthNull(Map<Integer, List<String>> nMap,
			List<String> strings) {
		for (String s : strings) {
			nMap.put(s.length(), null);
		}
		return nMap;
	}

	// get nested map world length and worlds with it length
	public Map<Integer, List<String>> getNestedMapWorldLengthList(Map<Integer, List<String>> nMap,
			List<String> strings) {
		for (Map.Entry<Integer, List<String>> pair : nMap.entrySet()) {
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
		return nMap;
	}

	// get map first symbol from world and null
	public Map<String, Map<Integer, List<String>>> getMapWorldFirstLetterNull(Map<Integer, List<String>> nMap,
			Map<String, Map<Integer, List<String>>> map) {
		for (Map.Entry<Integer, List<String>> pair : nMap.entrySet()) {
			for (String st : pair.getValue()) {
				map.put(st.substring(0, 1), null);
			}
		}
		// System.out.println(map);
		return map;
	}

	// get map first symbol and map world length and list words with it first symbol
	// and it length
	public Map<String, Map<Integer, List<String>>> getMapWorldFirstLetterMapLengthListWorlds(
			Map<Integer, List<String>> nMap, Map<String, Map<Integer, List<String>>> map) {
		for (Map.Entry<String, Map<Integer, List<String>>> pair : map.entrySet()) {
			Map<Integer, List<String>> newMap = new HashMap<>();
			for (Map.Entry<Integer, List<String>> pairTwo : nMap.entrySet()) {
				List<String> lis = new ArrayList<>();
				for (String s : pairTwo.getValue()) {
					if (pair.getKey().equals(s.substring(0, 1))) {
						lis.add(s);
					}
				}
				// get list with equals first symbol and length
				// System.out.println(lis);
				if (!lis.isEmpty()) {
					newMap.put(lis.get(0).length(), lis);
					map.put(lis.get(0).substring(0, 1), newMap);
				}
			}
		}
		// System.out.println(map);
		return map;
	}

	public Map<String, Map<Integer, List<String>>> nestedMapNew() {
		Map<String, Map<Integer, List<String>>> map = new HashMap<>();
		Map<Integer, List<String>> nMap = new HashMap<>();
		BufferedReader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("/home/gweep/eclipse-workspace/lambda/SonnetI.txt"),
					StandardCharsets.UTF_8);

			List<String> strings = reader.lines().flatMap(s -> Stream.of(s.split("\\W+"))).filter(s -> !s.isEmpty())
					.collect(Collectors.toList());

			nMap = getNestedMapWorldLengthNull(nMap, strings);

			nMap = getNestedMapWorldLengthList(nMap, strings);

			map = getMapWorldFirstLetterNull(nMap, map);

			map = getMapWorldFirstLetterMapLengthListWorlds(nMap, map);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}