package com.vmo_intern.manage_fresher.services;

import java.util.ArrayList;

import com.vmo_intern.manage_fresher.models.entities.AuthenticationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    AuthenticationService authenticationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticationEntity authenticationEntity = authenticationService.findByUsername(username);
        if (authenticationEntity != null) {
            return new User(authenticationEntity.getUsername(), authenticationEntity.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
