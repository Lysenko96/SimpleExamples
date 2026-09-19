package com.example.integration.service;

import com.example.spring.SpringRunner;
import com.example.spring.dto.UserCreateEditDto;
import com.example.spring.dto.UserReadDto;
import com.example.spring.model.Role;
import com.example.spring.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
//@Commit
public class UserServiceIT {

    private static final Long USER_ID = 1L;
    private static final Integer COMPANY_ID = 1;

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        Assertions.assertThat(result).hasSize(2);
    }

    @Test
    void findById() {
        Optional<UserReadDto> result = userService.findById(USER_ID);
        org.junit.jupiter.api.Assertions.assertTrue(result.isPresent());
        result.ifPresent(user-> org.junit.jupiter.api.Assertions.assertEquals("johndoe", user.getUsername()));
    }

    @Test
    void create() {
        UserCreateEditDto createDto = UserCreateEditDto.builder()
                .username("username")
                .firstname("firstname")
                .lastname("lastname")
                .birthDate(LocalDateTime.now())
                .role(Role.USER)
                .companyId(COMPANY_ID)
                .build();
        UserReadDto actual = userService.create(createDto);
        org.junit.jupiter.api.Assertions.assertEquals(createDto.getUsername(), actual.getUsername());
        org.junit.jupiter.api.Assertions.assertEquals(createDto.getFirstname(), actual.getFirstname());
        org.junit.jupiter.api.Assertions.assertEquals(createDto.getLastname(), actual.getLastname());
        org.junit.jupiter.api.Assertions.assertEquals(createDto.getBirthDate(), actual.getBirthDate());
        org.junit.jupiter.api.Assertions.assertSame(createDto.getRole(), actual.getRole());
        org.junit.jupiter.api.Assertions.assertEquals(createDto.getCompanyId(), actual.getCompany().id());
    }

    @Test
    void update() {
        UserCreateEditDto updateDto = UserCreateEditDto.builder()
                .username("username")
                .firstname("firstname")
                .lastname("lastname")
                .birthDate(LocalDateTime.now())
                .role(Role.USER)
                .companyId(COMPANY_ID)
                .build();
        Optional<UserReadDto> actual = userService.update(USER_ID, updateDto);
        org.junit.jupiter.api.Assertions.assertTrue(actual.isPresent());
        actual.ifPresent(user -> {
            org.junit.jupiter.api.Assertions.assertEquals(updateDto.getUsername(), user.getUsername());
            org.junit.jupiter.api.Assertions.assertEquals(updateDto.getFirstname(), user.getFirstname());
            org.junit.jupiter.api.Assertions.assertEquals(updateDto.getLastname(), user.getLastname());
            org.junit.jupiter.api.Assertions.assertEquals(updateDto.getBirthDate(), user.getBirthDate());
            org.junit.jupiter.api.Assertions.assertSame(updateDto.getRole(), user.getRole());
            org.junit.jupiter.api.Assertions.assertEquals(updateDto.getCompanyId(), user.getCompany().id());
        });
    }

    @Test
    void delete() {
        org.junit.jupiter.api.Assertions.assertFalse(userService.delete(-1L));
        org.junit.jupiter.api.Assertions.assertTrue(userService.delete(USER_ID));
    }
}
