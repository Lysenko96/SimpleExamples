package com.example.restdemotask.repository;

import com.example.restdemotask.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserDao {

    public static List<Users> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public UserRepository(List<Users> users) {
        this.users = users;
    }

    @Override
    public Users save(Users user) {
        users.add(user);
        return user;
    }

    @Override
    public Users getById(Long id) {
        return users.stream().filter(u -> u.getUniqueId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<Users> getAll() {
        return users;
    }

    @Override
    public Users update(Users user) {
      Users userMemory = users.stream().filter(u -> u.getUniqueId().equals(user.getUniqueId())).findAny().orElse(null);
      users.remove(userMemory);
      users.add(user);
      return user;
    }

    @Override
    public void deleteById(Long id) {
        users.stream().filter(u -> Users.id == id).findAny().ifPresent(user -> users.remove(user));
    }
}
