package net.gweep.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		assertEquals(List.of(new Person(15)),
				new Main().findKids(List.of(new Person(15), new Person(22), new Person(51))));
	}

}
