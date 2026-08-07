//package com.example.integration.repository;
//
//import com.example.integration.service.IT;
//import com.example.spring.model.User;
//import com.example.spring.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@IT
//@RequiredArgsConstructor
//@Transactional
//public class UserRepositoryTest {
//
//    private final UserRepository userRepository;
//
//    @Test
//    void findAllByContainingFirstnameAndContainingLastname() {
//        List<User> users = userRepository.findAllByFirstnameContainingAndLastnameContaining("a", "d");
//        System.out.println(users);
//        Assertions.assertThat(users).hasSize(2);
//    }
//}
