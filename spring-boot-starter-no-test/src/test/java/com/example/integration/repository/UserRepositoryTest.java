package com.example.integration.repository;

import com.example.spring.SpringRunner;
import com.example.spring.model.Role;
import com.example.spring.model.User;
import com.example.spring.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest(classes = SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAllByContainingFirstnameAndContainingLastname() {
        List<User> users = userRepository.findAllByFirstnameContainingAndLastnameContaining("p", "i");
        System.out.println(users);
        org.junit.jupiter.api.Assertions.assertFalse(users.isEmpty());
        Assertions.assertThat(users).hasSize(1);
    }

    @Test
    void updateRoleTest() {
        var user1 = userRepository.findById(1L);
        org.junit.jupiter.api.Assertions.assertTrue(user1.isPresent());
        org.junit.jupiter.api.Assertions.assertEquals(Role.ADMIN, user1.get().getRole());
        var result = userRepository.updateRole(Role.USER, 1L);
        org.junit.jupiter.api.Assertions.assertEquals(1L, result);
        var user2 = userRepository.findById(1L);
        org.junit.jupiter.api.Assertions.assertTrue(user2.isPresent());
        org.junit.jupiter.api.Assertions.assertEquals(Role.USER, user2.get().getRole());
    }
}
