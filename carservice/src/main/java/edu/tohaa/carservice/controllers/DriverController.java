package edu.tohaa.carservice.controllers;

import edu.tohaa.carservice.entities.Driver;
import edu.tohaa.carservice.repositories.DriverRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private DriverRepo driverRepo;

    public DriverController(DriverRepo driverRepo){
        this.driverRepo = driverRepo;
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody Driver driver){
        try {
            driverRepo.save(driver);
            return ResponseEntity.ok("Driver saved...");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity<String> findDrivers() {
        try {
            return ResponseEntity.ok("Server running...");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
