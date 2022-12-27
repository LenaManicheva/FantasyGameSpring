package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Character;
import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;


    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }

    public Optional<Character> findById(int id) {
        return characterRepository.findById(id);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

}
