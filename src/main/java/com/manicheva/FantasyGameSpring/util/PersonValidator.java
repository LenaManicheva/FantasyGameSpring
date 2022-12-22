package com.manicheva.FantasyGameSpring.util;

import com.manicheva.FantasyGameSpring.models.Person;
import com.manicheva.FantasyGameSpring.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> personDatabase=peopleService.findUserByUsername(person.getName());
        if (personDatabase.isPresent()) {
            errors.rejectValue("name", "","User with this name already exists");
        }
        if(!person.getPassword().equals(person.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "", "Passwords don't match");
        }
    }
}
