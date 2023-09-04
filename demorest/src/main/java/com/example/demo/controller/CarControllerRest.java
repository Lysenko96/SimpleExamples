package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CarControllerRest {

    private CarRepository carRepository;

    public CarControllerRest(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
//        if (car.isPresent()) {
//            return ResponseEntity.ok(car.get());
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
    }

    @PostMapping(consumes = "application/json")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/delete/{id}")
    // @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        // public void deleteCarById(@PathVariable Long id){
        carRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return ResponseEntity.ok(carRepository.save(car));
    }

    @PatchMapping(path = "/patch/{id}", consumes = "application/json")
    public ResponseEntity<Car> patchCar(@PathVariable Long id, @RequestBody Car car) {
        Car result = null;
        Car carDb = carRepository.findById(id).orElse(null);
        if (carDb != null) {
            carDb.setModel(car.getModel() != null ? car.getModel() : carDb.getModel());
            carDb.setSpeed(car.getSpeed() != null ? car.getSpeed() : carDb.getSpeed());
            result = carRepository.save(carDb);
        }
        return ResponseEntity.ok(result);
    }


}
