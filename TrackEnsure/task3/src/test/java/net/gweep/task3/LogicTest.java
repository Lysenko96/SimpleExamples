package net.gweep.task3;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.gweep.task3.entity.Car;
import net.gweep.task3.entity.Model;
import net.gweep.task3.logic.Logic;

class LogicTest {

	private Logic logic;
	private List<Car> cars;

	@BeforeEach
	void setUp() {
		logic = new Logic();
		cars = List.of(new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"),
				new Car(2, Model.TESLA, 2018, 200000, "AA3578AK"));
	}

	@Test
	void givenModel_whenSortedByYear_thenSortedList() {
		List<Car> expected = List.of(new Car(2, Model.TESLA, 2018, 200000, "AA3578AK"),
				new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"));
		assertEquals(expected, logic.sortModelByYear(cars, Model.TESLA));
	}

	@Test
	void givenModelAndYear_whenExploitModelMoreThen_thenList() {
		List<Car> expected = List.of(new Car(2, Model.TESLA, 2018, 200000, "AA3578AK"));
		assertEquals(expected, logic.exploitModelMoreThen(cars, Model.TESLA, 2));
	}

	@Test
	void givenModelPrice_whenGetByYearPriceMoThen_thenList() {
		cars = List.of(new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"),
				new Car(2, Model.TESLA, 2019, 200000, "AA3578AK"));
		List<Car> expected = List.of(new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"));
		assertEquals(expected, logic.getByYearPriceMoThen(cars, 2019, 200000));
	}

	@Test
	void given_whenGetByPriceReduceYearUp_thenList() {
		cars = List.of(new Car(1, Model.BMW, 2019, 205000, "AC4251CC"),
				new Car(2, Model.TESLA, 2018, 205000, "AA3578AK"));
		List<Car> expected = List.of(new Car(2, Model.TESLA, 2018, 205000, "AA3578AK"),
				new Car(1, Model.BMW, 2019, 205000, "AC4251CC"));
		assertEquals(expected, logic.getByPriceReduceYearUp(cars));
	}

	@Test
	void givenModels_whenGetModels_thenList() {
		Set<Model> expected = Set.of(Model.BMW, Model.TESLA, Model.PORSCHE);
		assertEquals(expected, logic.getModels());
	}

	@Test
	void givenCars_whenGetModelCars_thenGetMapModelCars() {
		cars = List.of(new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"),
				new Car(2, Model.TESLA, 2018, 200000, "AA3578AK"), new Car(3, Model.BMW, 2006, 150000, "AH9532UH"),
				new Car(4, Model.PORSCHE, 2003, 125000, "AE1266AA"));
		Map<Model, List<Car>> expected = new HashMap<>();
		expected.put(Model.BMW, List.of(new Car(3, Model.BMW, 2006, 150000, "AH9532UH")));
		expected.put(Model.PORSCHE, List.of(new Car(4, Model.PORSCHE, 2003, 125000, "AE1266AA")));
		expected.put(Model.TESLA, List.of(new Car(1, Model.TESLA, 2019, 225000, "AC4251CC"),
				new Car(2, Model.TESLA, 2018, 200000, "AA3578AK")));
		assertEquals(expected, logic.getModelCars(cars));
	}

}