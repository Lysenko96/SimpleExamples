package com.example.restdemotask.controller;

import com.example.restdemotask.entity.User;
import com.example.restdemotask.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<User> validAddUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllByBirthDateRange(HttpServletRequest request){
        String fromStr = request.getParameter("from");
        String toStr = request.getParameter("to");
        return ResponseEntity.ok(userService.getAllByBirthDateRange(fromStr, toStr));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @PatchMapping(path = "/patch/{id}", consumes = "application/json")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody User user) {
        User result = null;
        User userMemory = userService.getById(id);
        if (userMemory != null) {
            userMemory.setFirstName(user.getFirstName() != null ? user.getFirstName() : userMemory.getFirstName());
            userMemory.setLastName(user.getLastName() != null ? user.getLastName() : userMemory.getLastName());
            userMemory.setEmail(user.getEmail() != null ? user.getEmail() : userMemory.getEmail());
            userMemory.setBirthDate(user.getBirthDate() != null ? user.getBirthDate() : userMemory.getBirthDate());
            userMemory.setAddress(user.getAddress() != null ? user.getAddress() : userMemory.getAddress());
            userMemory.setPhone(user.getPhone() != null ? user.getPhone() : userMemory.getPhone());
            result = userService.update(userMemory);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
