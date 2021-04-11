package com.foxminded.university.dao.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapGenerator {

	public Map<Integer, List<Integer>> mapFromLists(List<Integer> listIds, List<Integer> list2Ids) {

		List<Integer> listKeys = listFromSet(listIds);

		List<Integer> lengths = getLengths(listKeys, listIds);

		List<Integer> indexes = getIndexes(listKeys, listIds);

		List<Integer> sortedList2Ids = getSortedList2Ids(indexes, list2Ids);

		return getMap(lengths, sortedList2Ids, listKeys);
	}

	List<Integer> listFromSet(List<Integer> listIds) {
		Set<Integer> setKeys = new HashSet<>();
		for (Integer id : listIds) {
			setKeys.add(id);
		}
		return new ArrayList<>(setKeys);
	}

	List<Integer> getLengths(List<Integer> listKeys, List<Integer> listIds) {
		List<Integer> lengths = new ArrayList<>();
		int counterRepeat = 0;
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int index = 0; index < listIds.size(); index++) {
				if (listKeys.get(keyIndex).equals(listIds.get(index))) {
					counterRepeat++;
				}
			}
			lengths.add(counterRepeat);
			counterRepeat = 0;
		}
		return lengths;
	}

	List<Integer> getIndexes(List<Integer> listKeys, List<Integer> listIds) {
		List<Integer> indexes = new ArrayList<>();
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int index = 0; index < listIds.size(); index++) {
				if (listKeys.get(keyIndex).equals(listIds.get(index))) {
					indexes.add(index);
				}
			}
		}
		return indexes;
	}

	List<Integer> getSortedList2Ids(List<Integer> indexes, List<Integer> list2Ids) {
		List<Integer> sortedList2Ids = new ArrayList<>();
		for (Integer id : indexes) {
			sortedList2Ids.add(list2Ids.get(id));
		}
		return sortedList2Ids;
	}

	Map<Integer, List<Integer>> getMap(List<Integer> lengths, List<Integer> sortedList2Ids, List<Integer> listKeys) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int increment = 0;
		for (int indexKey = 0; indexKey < lengths.size(); indexKey++) {
			List<Integer> values = new ArrayList<>();
			for (int indexValue = increment; indexValue < increment + lengths.get(indexKey); indexValue++) {
				values.add(sortedList2Ids.get(indexValue));
			}
			increment += lengths.get(indexKey);
			map.put(listKeys.get(indexKey), values);
		}
		return map;
	}
}

