package com.manicheva.FantasyGameSpring.controllers;

import com.manicheva.FantasyGameSpring.models.GameCharacter;
import com.manicheva.FantasyGameSpring.services.GameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameCharacterController {
    private final GameCharacterService gameCharacterService;

    @Autowired
    public GameCharacterController(GameCharacterService gameCharacterService) {
        this.gameCharacterService = gameCharacterService;
    }

    @GetMapping("/character/{id}")
    public String showCharacter(@PathVariable("id") int id, Model model) {
        model.addAttribute("character", gameCharacterService.findById(id));
        return "character";
    }

    @GetMapping("/characters")
    public String index(Model model) {
        model.addAttribute("characters", gameCharacterService.findAll());
        return "characters";
    }


}
