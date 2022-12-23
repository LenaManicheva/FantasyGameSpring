package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.GameCharacter;
import com.manicheva.FantasyGameSpring.repositories.GameCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameCharacterService {
    private final GameCharacterRepository gameCharacterRepository;

    @Autowired
    public GameCharacterService(GameCharacterRepository gameCharacterRepository) {
        this.gameCharacterRepository = gameCharacterRepository;
    }

    public Optional <GameCharacter> findById (int id) {
        return gameCharacterRepository.findById(id);
    }

    public List<GameCharacter> findAll() {
        return gameCharacterRepository.findAll();
    }

}
