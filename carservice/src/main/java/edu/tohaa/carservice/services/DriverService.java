package edu.tohaa.carservice.services;

import edu.tohaa.carservice.entities.Driver;
import edu.tohaa.carservice.exceptions.DriverByPhoneExistsDatabaseException;
import edu.tohaa.carservice.exceptions.DriverNotExistsDatabaseException;
import edu.tohaa.carservice.repositories.DriverRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class DriverService {

    private DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    public void registration(@RequestBody Driver driver) throws DriverByPhoneExistsDatabaseException {
        if (driverRepo.findByPhone(driver.getPhone()) != null) {
            throw new DriverByPhoneExistsDatabaseException("Driver phone exists database");
        }
        driverRepo.save(driver);
    }

    public Iterable<Driver> getAll() {
        return driverRepo.findAll();
    }

    public Driver getById(long id) throws DriverNotExistsDatabaseException {
        if(driverRepo.findById(id).isEmpty()){
          throw new DriverNotExistsDatabaseException("Driver not exists database exception");
        }
        return driverRepo.findById(id).get();
    }
}
