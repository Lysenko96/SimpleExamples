package edu.tohaa.carservice.controllers;

import edu.tohaa.carservice.entities.Driver;
import edu.tohaa.carservice.exceptions.DriverByPhoneExistsDatabaseException;
import edu.tohaa.carservice.exceptions.DriverNotExistsDatabaseException;
import edu.tohaa.carservice.repositories.DriverRepo;
import edu.tohaa.carservice.services.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        try {
            driverService.registration(driver);
            return ResponseEntity.ok("Driver registration...");
        } catch (DriverByPhoneExistsDatabaseException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity findDrivers() {
        try {
            return ResponseEntity.ok(driverService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/id")
    public ResponseEntity findById(@RequestParam long id) {
        try {
            return ResponseEntity.ok(driverService.getById(id));
        } catch (DriverNotExistsDatabaseException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
