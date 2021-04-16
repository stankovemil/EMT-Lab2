package com.example.emillab.security;

import com.example.emillab.AppUser;
import com.example.emillab.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsManager implements UserDetailsManager {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {
        userRepository.save((AppUser) user);
    }

    @Override
    public void updateUser(UserDetails user) {
        userRepository.save((AppUser) user);

    }

    @Override
    public void deleteUser(String username) {
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
