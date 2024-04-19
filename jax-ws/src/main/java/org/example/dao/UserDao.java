package org.example.dao;

import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> users = new ArrayList<>(); {{
        users.add(new User(1, "John", "Mohawk", 1999));
        users.add(new User());
    }}

    public List<User> findAll() {
        return users;
    }
}
