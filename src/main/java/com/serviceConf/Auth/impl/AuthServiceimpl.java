package com.serviceConf.Auth.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Service
public class AuthServiceimpl implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String[] roles = new String[]{"ADMIN", "USER"};
        return User
                .builder()
                .username(username)
                .roles(roles)
                .build();
    }
}
