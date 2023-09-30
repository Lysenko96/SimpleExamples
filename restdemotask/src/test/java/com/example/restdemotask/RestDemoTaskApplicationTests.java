package com.example.restdemotask;

import com.example.restdemotask.config.Config;
import com.example.restdemotask.controller.UserController;
import com.example.restdemotask.entity.User;
import com.example.restdemotask.exception.AgeValidationException;
import com.example.restdemotask.repository.UserRepository;
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

    private User alex1;
    private User alex2;
    private User alex3;
    private User alexNotValid;

    @BeforeEach
    public void setUp() {
        alex1 = new User("email", "alex", "alex", LocalDate.now().minusYears(23));
        alex2 = new User("email", "alex", "alex", LocalDate.now().minusYears(36));
        alex3 = new User("email", "alex", "alex", LocalDate.now().minusYears(19));
        alexNotValid = new User("email", "alex", "alex", LocalDate.now().minusYears(10));
        userController.validAddUser(alex1);
        userController.validAddUser(alex2);
        userController.validAddUser(alex3);
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
    public void addTest() {
        Assertions.assertEquals(userController.validAddUser(alex1), ResponseEntity.ok(alex1));
        Assertions.assertThrows(AgeValidationException.class, () -> userController.validAddUser(alexNotValid));
    }

    @Test
    public void updateTest() {
        alex1 = new User("email2352", "alex235", "alex235", LocalDate.now().minusYears(23));
        Assertions.assertEquals(userController.updateUser(alex1), ResponseEntity.ok(alex1));
    }

    @Test
    public void updatePatchTest() {
        alex1.setEmail("email23525");
        Assertions.assertEquals(userController.updateUser(alex1), ResponseEntity.ok(alex1));
    }

    @Test
    public void deleteTest() {
        Assertions.assertEquals(userController.deleteUserById(alex1.getUniqueId()).getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
