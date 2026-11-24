package org.web.ecom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web.ecom.dto.AddressDto;
import org.web.ecom.dto.UserRequest;
import org.web.ecom.dto.UserResponse;
import org.web.ecom.model.User;
import org.web.ecom.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.fetchAllUsers();
        List<UserResponse> userResponses = users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        return userService.fetchUser(id).map(u -> ResponseEntity.ok(mapToUserResponse(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<List<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        List<User> users = userService.fetchAllUsers();
        List<UserResponse> userResponses = users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponses);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        boolean updated = userService.updateUser(id, userRequest);
        if (updated) {
            User user = userService.mapToUser(User.builder().build(), userRequest);
            return ResponseEntity.ok(mapToUserResponse(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(String.valueOf(user.getId()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .email(user.getEmail())
                .phone(user.getPhone())
                .addressDto(user.getAddress() != null ? AddressDto.builder()
                        .id(String.valueOf(user.getAddress().getId()))
                        .city(user.getAddress().getCity())
                        .country(user.getAddress().getCountry())
                        .state(user.getAddress().getState())
                        .street(user.getAddress().getStreet())
                        .zipcode(user.getAddress().getZipcode())
                        .build() : null)
                .build();
    }
}
