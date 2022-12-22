package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Person;
import com.manicheva.FantasyGameSpring.repositories.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;


    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

   @Transactional
    public void register (Person person) {
        peopleRepository.save(person);
    }
}
