package com.te.jsonlesson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.jsonlesson.entity.Car;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		String s;
		//String sList;
		Car c = new Car(1, "Tesla", 225);
		List<Car> cars = new ArrayList<>(List.of(c, new Car(2, "Bmw", 235), new Car(3, "Lada", 180)));
		ObjectMapper mapper = new ObjectMapper();
		try {
			s = mapper.writeValueAsString(c);
			//sList = mapper.writeValueAsString(cars);
			System.out.println(s);
			System.out.println(cars);
			Car car = mapper.readValue(s, Car.class);
			System.out.println(car);
			// List<Car> cars2 = mapper.readValue(sList, new TypeReference<>() {});
			// cars2.forEach(System.out::println);
			mapper.writeValue(new File("cars.json"), cars);
			List<Car> cars3 = mapper.readValue(new File("cars.json"), new TypeReference<>() {
			});
			cars3.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
