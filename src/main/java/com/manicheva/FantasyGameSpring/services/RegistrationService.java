package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }






}
