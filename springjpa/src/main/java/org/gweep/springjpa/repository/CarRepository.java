package org.gweep.springjpa.repository;

import org.gweep.springjpa.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
