package com.lysenko.shoppingcart.config;

import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.repository.UserRepository;
import com.lysenko.shoppingcart.service.UserService;
import com.lysenko.shoppingcart.util.AppConstant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

    private final UserRepository userRepository;
    private final UserService userService;



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("username");
        UserCustom user = userRepository.findByEmail(email);
        if (user.getIsEnabled() == null) {
            log.error("isEnabled is null");
            return;
        }
        if (user.getIsEnabled().equals(Boolean.TRUE)) {
            if (user.getAccountNonLocked().equals(Boolean.TRUE)) {
                if (user.getFailedAttempt() <= AppConstant.ATTEMPT_TIME) {
                    userService.increaseFailedAttempt(user);
                } else {
                    userService.userAccountLock(user);
                    exception = new LockedException("You account is locked! Failed attempt " + AppConstant.ATTEMPT_TIME);
                }
            } else {
                if (userService.unlockAccountTimeExpired(user).equals(Boolean.TRUE)) {
                    exception = new LockedException("You account is unlocked! Please try again");
                } else {
                    exception = new LockedException("You account is locked! Please try later");
                }
            }
        } else {
            exception = new LockedException("Your account has been inactivated");
        }
        setDefaultFailureUrl("/shopping-cart/main-login?error");
        super.onAuthenticationFailure(request, response, exception);
    }


}
