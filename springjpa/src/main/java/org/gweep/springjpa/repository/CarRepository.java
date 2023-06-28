package org.gweep.springjpa.repository;

import org.gweep.springjpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByNameAndSpeedAfter(String name, double speed);
    List<Car> findAllByModel(String model);
}
