package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.repository.UserRepository;
import com.lysenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCustom saveUser(UserCustom user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
