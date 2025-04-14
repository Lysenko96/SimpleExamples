package com.lysenko.shoppingcart.config;

import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCustom user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new UserDetailsImpl(user);
    }
}
