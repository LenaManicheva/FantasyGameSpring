package com.manicheva.FantasyGameSpring.controllers;

import com.manicheva.FantasyGameSpring.models.Character;
import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.services.CharacterService;
import com.manicheva.FantasyGameSpring.services.GameService;
import com.manicheva.FantasyGameSpring.services.RegistrationService;
import com.manicheva.FantasyGameSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    private final CharacterService characterService;
    private final UserService userService;
    private final RegistrationService registrationService;
    private final GameService gameService;


    @Autowired
    public GameController(CharacterService characterService,
                          UserService userService, RegistrationService registrationService, GameService gameService) {
        this.characterService = characterService;
        this.userService = userService;
        this.registrationService = registrationService;
        this.gameService = gameService;
    }

    @GetMapping("/character/{id}")
    public String showCharacter(@PathVariable("id") int id, Model model) {
        model.addAttribute("character", characterService.findById(id));
        return "game/character";
    }


    @GetMapping("/characters")
    public String index(Model model) {
        model.addAttribute("characters", characterService.findAll());
        return "game/characters";
    }

    @PatchMapping("/character/{id}")
    public String setCharacter(@PathVariable("id") int id) {
        User currentUser = userService.getCurrentUser();
        Character chosenCharacter = characterService.findById(id).get();
        currentUser.setCharacter(chosenCharacter);
        registrationService.save(currentUser);
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String goToUserPage(Model model) {

        User currentUser = userService.getCurrentUser();

        model.addAttribute("user", currentUser);

        if (currentUser.getCharacter() != null) {
            model.addAttribute("user_character", currentUser.getCharacter().getName());
        } else {
            model.addAttribute("no_character", new Object());
        }

        return "game/home";
    }

    @GetMapping("/battle")
    public String startBattle(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("bot", gameService.generateBot());
        return "game/battle";
    }

    @GetMapping("/fight")
    public String battle(Model model) {
        User currentUser = userService.getCurrentUser();
        int pointsRound = gameService.getWinner();
        gameService.update(currentUser, pointsRound);
        model.addAttribute("user", currentUser);
        model.addAttribute("points_round", pointsRound);
        model.addAttribute("bot", gameService.generateBot());
        if (pointsRound > 0) {
            model.addAttribute("txt", "WIN! ;)");
        } else {
            model.addAttribute("txt", "LOSS :(");
        }
        return "game/battle";
    }

}
