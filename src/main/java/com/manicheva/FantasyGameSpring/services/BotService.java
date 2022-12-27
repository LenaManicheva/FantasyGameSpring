package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Bot;
import com.manicheva.FantasyGameSpring.repositories.BotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BotService {

    private final BotRepository botRepository;

    public BotService(BotRepository botRepository) {
        this.botRepository = botRepository;
    }

    public Optional<Bot> findById(int id) {
        return botRepository.findById(id);
    }
}
