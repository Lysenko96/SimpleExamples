package com.lysenko.shoppingcart.service;


import com.lysenko.shoppingcart.model.UserCustom;

import java.util.List;

public interface UserService {

    UserCustom saveUser(UserCustom userCustom);

    UserCustom getUserByEmail(String email);

    List<UserCustom> findAllUsersByRole(String role);

    Boolean updateUserStatus(Integer id, Boolean status);

    void increaseFailedAttempt(UserCustom userCustom);

    void userAccountLock(UserCustom userCustom);

    Boolean unlockAccountTimeExpired(UserCustom userCustom);

    void resetAttempt(Integer userId);

    void updateUserResetToken(String email, String resetToken);

    UserCustom getUserByToken(String token);

    UserCustom updateUser(UserCustom userCustom);
}
