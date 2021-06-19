package edu.lysenko.container;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Peoples {

	static final Map<String, Integer> DATA = map(new Pair("Ukraine", Integer.valueOf(45)),
			new Pair("Russia", Integer.valueOf(110)));

	static Map<String, Integer> map(Pair<String, Integer>... pair) {
		Map<String, Integer> map = new HashMap<>();
		for (Pair<String, Integer> p : pair) {
			map.put(p.getKey(), p.getValue());
		}
		return map;
	}

	private static class Flyweight extends AbstractMap<String, Integer> {

		private static class Entry<String, Integer> implements Map.Entry<String, Integer> {

			int index;

			Entry(int index) {
				this.index = index;
			}

			public boolean equals(Object o) {
				return DATA.get(index).equals(o);
			}

			@Override
			public String getKey() {
				return (String) Arrays.asList(DATA.keySet()).get(index);
			}

			@Override
			public Integer getValue() {
				return (Integer) Arrays.asList(DATA.values()).get(index);
			}

			@Override
			public Integer setValue(Integer arg0) {
				return null;
			}

		}

		@Override
		public Set<Map.Entry<String, Integer>> entrySet() {
			return null;
		}

	}

	public static void main(String[] args) {
		System.out.println(DATA);
		System.out.println(new Flyweight.Entry<>(0).getKey());
		System.out.println(new Flyweight.Entry<>(0).getValue());
		System.out.println();
	}

}
