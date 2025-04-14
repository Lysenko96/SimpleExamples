package com.lysenko.shoppingcart.repository;

import com.lysenko.shoppingcart.model.UserCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserCustom, Integer> {

    UserCustom findByEmail(String email);
}
