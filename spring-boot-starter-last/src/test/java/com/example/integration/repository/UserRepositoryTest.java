package com.example.integration.repository;

import com.example.spring.SpringRunner;
import com.example.spring.model.Role;
import com.example.spring.model.User;
import com.example.spring.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    void checkPageable() {
        var pageable = PageRequest.of(0, 1, Sort.by("id"));
        var page = userRepository.findAllBy(pageable);
        page.forEach(System.out::println);
        while (page.hasNext()) {
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(System.out::println);
            System.out.println(page.getTotalPages());
        }
    }

    @Test
    void findFirst2BySort() {
        var users = userRepository.findFirst2By(Sort.by(Sort.Order.desc("firstname"))
                .and(Sort.by(Sort.Order.desc("lastname"))));
//        var users = userRepository.findFirst2By(Sort.by("id").descending());
        org.junit.jupiter.api.Assertions.assertFalse(users.isEmpty());
        Assertions.assertThat(users).hasSize(2);

    }

    @Test
    void findFirst3ByCompanyIsNotNullOrderByIdTest() {
        var users = userRepository.findFirst3ByCompanyIsNotNullOrderByIdDesc();
        org.junit.jupiter.api.Assertions.assertFalse(users.isEmpty());
        Assertions.assertThat(users).hasSize(2);
    }


    @Test
    void findFirstByCompanyIsNotNullOrderByIdTest() {
        var user = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();
        org.junit.jupiter.api.Assertions.assertTrue(user.isPresent());
        user.ifPresent(u -> org.junit.jupiter.api.Assertions.assertEquals("apple", user.get().getFirstname()));
    }

    @Test
    void checkProjections() {
        var users = userRepository.findAllByCompanyId(1);
        Assertions.assertThat(users).hasSize(1);
    }

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
