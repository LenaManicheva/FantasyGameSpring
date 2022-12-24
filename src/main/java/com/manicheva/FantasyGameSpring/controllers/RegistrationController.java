package com.manicheva.FantasyGameSpring.controllers;

import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.services.RegistrationService;
import com.manicheva.FantasyGameSpring.services.UserService;
import com.manicheva.FantasyGameSpring.util.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserValidator userValidator;
    private final RegistrationService registrationService;
    private final UserService userService;

    @Autowired
    public RegistrationController(UserValidator userValidator, RegistrationService registrationService,
                                  UserService userService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        registrationService.save(user);
        return "redirect:/login";
    }
}
