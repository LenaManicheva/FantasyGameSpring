package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.repositories.UserRepository;
import com.manicheva.FantasyGameSpring.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsSecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    public UserDetailsSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user.get());
    }


}
