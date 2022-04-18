package edu.tohaa.carservice.repositories;

import edu.tohaa.carservice.entities.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepo extends CrudRepository<Driver, Long> {

    Driver findByPhone(int phone);
}
