package net.pack.carfactory.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.pack.carfactory.entity.Car;

@Component
public class CarRepoImpl implements CarRepo {

	@Override
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Tesla", 225));
		return cars;
	}
}