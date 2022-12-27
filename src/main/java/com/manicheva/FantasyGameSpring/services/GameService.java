package com.manicheva.FantasyGameSpring.services;

import com.manicheva.FantasyGameSpring.models.Bot;
import com.manicheva.FantasyGameSpring.models.User;
import com.manicheva.FantasyGameSpring.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final BotService botService;
    private final UserRepository userRepository;


    public GameService(BotService botService, UserRepository userRepository) {
        this.botService = botService;

        this.userRepository = userRepository;
    }

    //Random choosing of Bot from DB
    public Bot generateBot() {
        Bot newBot = botService.findById((int) (Math.random() * 6 + 1)).orElse(new Bot());
        return newBot;
    }

    public int getWinner() {
        if (isWin()) {
            return 10;
        } else {
            return 0;
        }
    }

    //Random defining winner, user (true) or bot (false)
    public boolean isWin() {
        int userScore;
        int botScore;
        userScore = (int) (Math.random() * 10);
        botScore = (int) (Math.random() * 10);
        if (userScore > botScore) {
            return true;
        } else {
            return false;
        }
    }

    public void update(User currentUser, int pointsRound) {
        int newPoints = currentUser.getPoints() + pointsRound;
        System.out.println(newPoints);
        currentUser.setPoints(newPoints);
        System.out.println(currentUser.getPoints());
        if (newPoints % 100 == 0) {
            currentUser.setLevel(currentUser.getPoints()/100);
        }
        userRepository.save(currentUser);
    }
}
