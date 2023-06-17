package org.gweep.springjpa.service;

import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    //@Autowired
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(Car car){
        carRepository.save(car);
    }
}
