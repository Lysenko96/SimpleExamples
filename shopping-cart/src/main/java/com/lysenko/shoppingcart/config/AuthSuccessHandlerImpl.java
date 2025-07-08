package com.lysenko.shoppingcart.config;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

@Service
@Slf4j
public class AuthSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Set<String> roles = AuthorityUtils.authorityListToSet(authorities);
        RequestDispatcher dispatcherAdmin = request.getRequestDispatcher("/shopping-cart/admin");
        RequestDispatcher dispatcherUser = request.getRequestDispatcher("/shopping-cart/user");
        try {
            if (roles.contains("ROLE_ADMIN")) {
//                response.sendRedirect("/shopping-cart/admin");
                dispatcherAdmin.forward(request, response);
            } else {
//                response.sendRedirect("/shopping-cart/user");
                dispatcherUser.forward(request, response);
            }
        } catch (ServletException e) {
            log.error("Error while trying to redirect to the login page", e);
        }
    }
}
