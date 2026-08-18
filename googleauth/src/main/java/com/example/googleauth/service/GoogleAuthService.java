package com.example.googleauth.service;

import com.example.googleauth.dto.UserLoginDto;
import com.example.googleauth.entity.UserRegisterData;
import com.example.googleauth.repository.GoogleAuthRepository;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthService {

    private GoogleAuthenticator gAuth = new GoogleAuthenticator();
    @Autowired
    private GoogleAuthRepository gAuthRepo;

    public String generateKey() {
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }

    public void addUser(UserRegisterData userRegisterData) {
        gAuthRepo.save(userRegisterData);
    }

    public boolean isValid(String secret, int code) {
        return gAuth.authorize(secret, code);
    }

    public String getSecretKey(UserLoginDto loginDto) {
        UserRegisterData userData = gAuthRepo.findAllByUsername(loginDto.getUsername());
        return userData.getSecretKey();
    }

}
