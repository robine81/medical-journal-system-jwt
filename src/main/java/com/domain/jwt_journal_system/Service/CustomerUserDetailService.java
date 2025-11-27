package com.domain.jwt_journal_system.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return User.builder()
                    .username("admin")
                    .password("$2a$12$CXqSeBneszgxnW96G8KDZuk44Px5KeBTN3BHGnZKqv1jv8nkZBrTC") // admin123
                    .roles("ADMIN")
                    .build();
        } else if (username.equals("user")) {
            return User.builder()
                    .username("user")
                    .password("$2a$12$VAbgw3A6dpd75tEUudrqXOlelyuqecc54N9WNfxN7zStPQV7aY8EO") // 1234
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
