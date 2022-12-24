package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Character;
import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.repositories.UserRepository;
import com.manicheva.FantasyGameSpring.security.UsersDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getCurrentUser() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails) authentication.getPrincipal();
        User currentUser=usersDetails.getUser();
        return currentUser;
    }
}