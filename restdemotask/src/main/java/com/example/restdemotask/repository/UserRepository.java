package com.example.restdemotask.repository;

import com.example.restdemotask.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserDao {

    List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public UserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return users.stream().filter(u -> u.getUniqueId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User update(User user) {
      User userMemory = users.stream().filter(u -> u.getUniqueId().equals(user.getUniqueId())).findAny().orElse(null);
      users.remove(userMemory);
      users.add(user);
      return user;
    }

    @Override
    public void deleteById(Long id) {
        users.stream().filter(u -> User.id == id).findAny().ifPresent(user -> users.remove(user));
    }
}
