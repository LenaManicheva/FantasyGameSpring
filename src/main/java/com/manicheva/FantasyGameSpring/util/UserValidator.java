package com.manicheva.FantasyGameSpring.util;

import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Optional<User> personDatabase= userService.findUserByUsername(user.getUsername());
        if (personDatabase.isPresent()) {
            errors.rejectValue("username", "","User with this name already exists");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "", "Passwords don't match");
        }
    }
}
