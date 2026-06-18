package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.repository.UserRepository;
import com.lysenko.shoppingcart.service.UserService;
import com.lysenko.shoppingcart.util.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Configuration
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserCustom saveUser(UserCustom user) {
        user.setRole("ROLE_USER");
        user.setIsEnabled(true);
        user.setAccountNonLocked(true);
        user.setFailedAttempt(0);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserCustom getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserCustom> findAllUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public Boolean updateUserStatus(Integer id, Boolean status) {
        Optional<UserCustom> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserCustom userCustom = user.get();
            userCustom.setIsEnabled(status);
            userRepository.save(userCustom);
            return true;
        }
        return false;
    }

    @Override
    public void increaseFailedAttempt(UserCustom userCustom) {
        userCustom.setFailedAttempt(userCustom.getFailedAttempt() + 1);
        userRepository.save(userCustom);
    }

    @Override
    public void userAccountLock(UserCustom userCustom) {
        userCustom.setAccountNonLocked(false);
        userCustom.setLockTime(new Date());
        userRepository.save(userCustom);
    }

    @Override
    public Boolean unlockAccountTimeExpired(UserCustom userCustom) {
        long lockTime = userCustom.getLockTime().getTime();
        long unlockTime = AppConstant.UNLOCK_DURATION_TIME_1H + lockTime;
        long now = System.currentTimeMillis();
        if (now < unlockTime) {
            userCustom.setAccountNonLocked(true);
            userCustom.setFailedAttempt(0);
            userCustom.setLockTime(null);
            userRepository.save(userCustom);
            return true;
        }
        return false;
    }

    @Override
    public void resetAttempt(Integer userId) {

    }

    @Override
    public void updateUserResetToken(String email, String resetToken) {
        UserCustom findByEmail = userRepository.findByEmail(email);
        findByEmail.setResetToken(resetToken);
        userRepository.save(findByEmail);
    }

    @Override
    public UserCustom getUserByToken(String token) {
        return userRepository.findByResetToken(token);
    }

    @Override
    public UserCustom updateUser(UserCustom userCustom) {
        return userRepository.save(userCustom);
    }
}
