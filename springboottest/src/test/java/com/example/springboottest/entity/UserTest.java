package com.example.springboottest.entity;

import com.example.springboottest.SpringBootTestApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

// @SpringBootTest get beans from SpringBootTestApplication app
@SpringBootTest(classes = SpringBootTestApplication.class)
class UserTest {

    private User user;
    private Hobby hobby;

    @Autowired
    private User userInject;

    @BeforeEach
    void setUp() {
        //user = new User(hobby);
        //user = userInject;
        System.out.println(userInject);
        hobby = Mockito.mock(Hobby.class);
        userInject.setHobby(hobby);

    }

    @Test
    void calculate() {
        userInject.setId(1L);
        assertEquals(15, userInject.calculate(3, 5, "*"), "3 * 5 = 15");
    }

    @Test
    void calculate1() {
        // if not scope prototype use singleton user for all test after autowired
        System.out.println(userInject);
        assertNotEquals(1, userInject.getId()); // if scope singleton fail
        assertEquals(3, userInject.calculate(1, 2, "+"), "1 + 2 = 3");
    }

    @Test
    void calculate2() {
        //result + delta = expected
        assertEquals(11.5, userInject.calculate(2.2, 5, "*"), 0.5, "3 * 5 = 15");
    }

    @Test
    void checkHobby(){
        String hobbyName = "sport";
        // when execute method hobby.generateHobby(String name) with this hobby name (sport)
        // return next result "You hobby sport is cool!"
        when(hobby.generateHobby(hobbyName)).thenReturn("You hobby sport is cool!");
        // user.checkHobby(String name) execute hobby.generateHobby(String name
        // and return next result "You hobby sport is cool!"
        System.out.println(userInject.checkHobby(hobbyName));
        // method hobby.generateHobby(String name) execute 2 times
        verify(hobby, times(2)).generateHobby(hobbyName);
    }
}