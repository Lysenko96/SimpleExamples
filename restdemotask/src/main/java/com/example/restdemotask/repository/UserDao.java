package com.example.restdemotask.repository;

import com.example.restdemotask.entity.User;

import java.util.List;

public interface UserDao {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    User update(User user);

    void deleteById(Long id);
}
