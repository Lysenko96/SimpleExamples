package org.gweep.springjpa.service;

import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> findAllByModel(String model) {
        return carRepository.findAllByModel(model);
    }

    public List<Car> findAllByNameAndSpeedAfter(String name, double speed) {
        return carRepository.findAllByNameAndSpeedAfter(name, speed);
    }
}
