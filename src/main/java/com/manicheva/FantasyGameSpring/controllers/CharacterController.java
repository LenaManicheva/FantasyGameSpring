package com.manicheva.FantasyGameSpring.controllers;

import com.manicheva.FantasyGameSpring.models.Character;
import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.services.CharacterService;
import com.manicheva.FantasyGameSpring.services.RegistrationService;
import com.manicheva.FantasyGameSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CharacterController {
    private final CharacterService characterService;
    private final UserService userService;
    private final RegistrationService registrationService;


    @Autowired
    public CharacterController(CharacterService characterService,
                               UserService userService, RegistrationService registrationService) {
        this.characterService = characterService;
        this.userService = userService;

        this.registrationService = registrationService;
    }

    @GetMapping("/character/{id}")
    public String showCharacter(@PathVariable("id") int id, Model model) {
        model.addAttribute("character", characterService.findById(id));
        return "character";
    }


    @GetMapping("/characters")
    public String index(Model model) {
        model.addAttribute("characters", characterService.findAll());
        return "characters";
    }

    @PatchMapping("/character/{id}")
    public String setCharacter(@PathVariable("id") int id) {
        User currentUser = userService.getCurrentUser();
        Character chosenCharacter = characterService.findById(id).get();
        currentUser.setCharacter(chosenCharacter);
        registrationService.save(currentUser);
        return "test";
    }

}
