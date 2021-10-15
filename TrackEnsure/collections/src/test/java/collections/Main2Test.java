package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.gweep.collections.Main2;

class Main2Test {

	Main2 main;

	@BeforeEach
	void setUp() {
		main = new Main2();
	}

	@Test
	void testCreateSet() {
		Set<Integer> set = main.createSet();
		assertTrue(set.isEmpty());
	}

	@Test
	void testDemo() {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 3, 2, 5, 9));
		Set<Integer> set = new HashSet<>(list);
		assertEquals(7, set.size());
	}

	@Test
	void testMap() {
		Map<String, Integer> map = new HashMap<>();
		//rewrite value in map
		map.put("txt", 0);
		map.put("rxt", 0);
		map.put("txt", 1);
		for (Map.Entry<String, Integer> pair : map.entrySet()) {
			if (map.containsKey(pair.getKey())) {
				int value = pair.getValue() + 1;
				map.put(pair.getKey(), value);
			}
		}
		System.out.println(map);
		assertEquals(map.get("txt"), Integer.valueOf(2));
		assertEquals(map.get("rxt"), Integer.valueOf(1));

	}
}