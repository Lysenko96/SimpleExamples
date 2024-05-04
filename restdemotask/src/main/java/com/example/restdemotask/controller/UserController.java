package com.example.restdemotask.controller;

import com.example.restdemotask.entity.Users;
import com.example.restdemotask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Users> validAddUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllByBirthDateRange(@RequestParam(required = false) String from, @RequestParam(required = false) String to){
        return ResponseEntity.ok(userService.getAllByBirthDateRange(from, to));
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @PatchMapping(path = "/patch/{id}", consumes = "application/json")
    public ResponseEntity<Users> patchUser(@PathVariable Long id, @RequestBody Users user) {
        return ResponseEntity.ok(userService.updatePatch(user, id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
