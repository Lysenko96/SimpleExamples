package com.example.restdemotask;

import com.example.restdemotask.config.Config;
import com.example.restdemotask.controller.UserController;
import com.example.restdemotask.entity.Users;
import com.example.restdemotask.exception.AgeValidationException;
import com.example.restdemotask.exception.InvalidArgumentException;
import com.example.restdemotask.repository.UserRepository;
import com.example.restdemotask.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
@Import(Config.class)
class RestDemoTaskApplicationTests {

    @Autowired
    private UserController userController;

    private Users alex1;
    private Users alex2;
    private Users alex3;
    private Users alexNotValid;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        alex1 = new Users("email@gmail.com", "alex", "alex", LocalDate.now().minusYears(23));
        alex2 = new Users("email@gmail.com", "alex", "alex", LocalDate.now().minusYears(36));
        alex3 = new Users("email@gmail.com", "alex", "alex", LocalDate.now().minusYears(19));
        alexNotValid = new Users("email@gmail.com", "alex", "alex", LocalDate.now().minusYears(10));
        userController.validAddUser(alex1);
        userController.validAddUser(alex2);
        userController.validAddUser(alex3);
        System.out.println(userService.getAll());
    }

    @AfterEach
    public void clear(){
        UserRepository.users = new ArrayList<>();
    }

    @Test
    public void getAllByBirthDateRangeTest() {
        Assertions.assertEquals(userController.getAllByBirthDateRange("1995-01-01", "2004-01-01"), ResponseEntity.ok(Collections.singletonList(alex1)));
    }

    @Test
    public void validCreateUser() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> userController.validAddUser(new Users("emailgmail.com", "alex", "alex", LocalDate.now().minusYears(10))));
        Assertions.assertThrows(InvalidArgumentException.class, () -> userController.validAddUser(new Users("email@gmail.com", "alex", "alex", LocalDate.now().plusDays(1))));
    }

    @Test
    public void addTest() {
        Assertions.assertEquals(userController.validAddUser(alex1), ResponseEntity.ok(alex1));
        Assertions.assertThrows(AgeValidationException.class, () -> userController.validAddUser(alexNotValid));
    }

    @Test
    public void updateTest() {
        alex1 = new Users("email@gmail.com", "alex235", "alex235", LocalDate.now().minusYears(23));
        System.out.println(userService.getAll());
        Assertions.assertEquals(userController.updateUser(alex1), ResponseEntity.ok(alex1));
    }

    @Test
    public void updatePatchTest() {
        alex1.setEmail("email1@gmail.com");
        Assertions.assertEquals(userController.updateUser(alex1), ResponseEntity.ok(alex1));
    }

    @Test
    public void deleteTest() {
        Assertions.assertEquals(userController.deleteUserById(alex1.getUniqueId()).getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
