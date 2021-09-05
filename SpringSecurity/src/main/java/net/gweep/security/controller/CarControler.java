package net.gweep.security.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.gweep.security.model.Car;

@RestController
@RequestMapping("/api/cars")
public class CarControler {

	private List<Car> cars = Stream.of(new Car(1, "Tesla", 215), new Car(2, "BMW", 250), new Car(3, "Lada", 160))
			.collect(Collectors.toList());

	@GetMapping
	public List<Car> getAll() {
		return cars;
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('user:read')")
	public Car getByCar(@PathVariable int id) {
		return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('user:write')")
	public Car create(@RequestBody Car car) {
		this.cars.add(car);
		return car;
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('user:write')")
	public void deleteById(@PathVariable int id) {
		this.cars.removeIf(car -> car.getId() == id);
	}

}
