package com.example.googleauth.repository;

import com.example.googleauth.entity.UserRegisterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleAuthRepository extends JpaRepository<UserRegisterData, Long> {

    UserRegisterData findAllByUsername(String username);

}
