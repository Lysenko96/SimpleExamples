package org.gweep.springjpa.service;

import org.gweep.springjpa.entity.Bike;
import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.repository.BikeRepository;
import org.gweep.springjpa.repository.CarRepository;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final BikeRepository bikeRepository;

    public CarService(CarRepository carRepository, BikeRepository bikeRepository) {
        this.carRepository = carRepository;
        this.bikeRepository = bikeRepository;
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> findAllByModel(String model) {
        return carRepository.findAllByModel(model);
    }
    public List<Car> findAllByModelPageable(String model, Pageable pageable) {
        return carRepository.findAllByModelPageable(model, pageable);
    }

    public List<Car> findAllByModelSort(String model, Sort sort) {
        return carRepository.findAllByModelSort(model, sort);
    }

    public List<Car> findAllByNameAndSpeedAfter(String name, double speed) {
        return carRepository.findAllByNameAndSpeedAfter(name, speed);
    }

    public Car findById(long id){
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> findAllByModelAndSpeedEquals(String model, double speed) {
        return carRepository.findAllByModelAndSpeedEquals(model, speed);
    }

    public List<Car> findAllByModelAndSpeedEqualsNumber(String model, double speed) {
        return carRepository.findAllByModelAndSpeedEqualsNumber(model, speed);
    }


    @Transactional//(rollbackFor = Exception.class)
    public void saveCarAndBike(Car car, Bike bike) throws Exception {
        carRepository.save(car);
        throwRuntimeException();
        bikeRepository.save(bike);
       // testSave(car, bike);
    }
    @Transactional
    public void testSave(Car car, Bike bike) throws Exception {
        carRepository.save(car);
        throwRuntimeException();
        bikeRepository.save(bike);
    }

    public void throwRuntimeException() throws Exception {
        throw new RuntimeException();
       // throw new Exception();
    }

}
