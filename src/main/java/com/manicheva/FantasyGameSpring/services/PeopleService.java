package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Person;
import com.manicheva.FantasyGameSpring.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findUserByUsername(String username) {
        return peopleRepository.findByName(username);
    }
}