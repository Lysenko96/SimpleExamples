package net.pack.carfactory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.pack.carfactory.entity.Car;
import net.pack.carfactory.repo.CarRepo;

@Component
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepo carRepo;

	public CarServiceImpl(CarRepo carRepo) {
		this.carRepo = carRepo;
	}

	public List<Car> getCars() {
		return carRepo.getCars();
	}
}