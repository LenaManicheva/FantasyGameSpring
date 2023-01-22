package com.manicheva.FantasyGameSpring.controllers;

import com.manicheva.FantasyGameSpring.models.Character;
import com.manicheva.FantasyGameSpring.repositories.CharacterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public final CharacterRepository characterRepository;

    public AdminController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters")
    public String showAllCharacters(Model model) {
        model.addAttribute("characters", characterRepository.findAll());
        return "admin/show-characters";
    }

    @GetMapping("/characters/{id}")
    public String showCharacter(Model model, @PathVariable("id") int id) {
        model.addAttribute("character", characterRepository.findById(id));
        return "admin/show-character";
    }

    @GetMapping("/characters/new")
    public String newCharacter(@ModelAttribute("character") Character character) {
        return "admin/new-character";
    }

    @PostMapping("/characters")
    public String createCharacter(@ModelAttribute("character") @Valid Character character,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/new-character";
        }
        characterRepository.save(character);
        return "redirect:/admin/characters";
    }
}
