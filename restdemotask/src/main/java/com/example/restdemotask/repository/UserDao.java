package com.example.restdemotask.repository;

import com.example.restdemotask.entity.Users;

import java.util.List;

public interface UserDao {

    Users save(Users user);

    Users getById(Long id);

    List<Users> getAll();

    Users update(Users user);

    void deleteById(Long id);
}
