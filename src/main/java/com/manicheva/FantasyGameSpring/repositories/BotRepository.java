package com.manicheva.FantasyGameSpring.repositories;

import com.manicheva.FantasyGameSpring.models.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotRepository extends JpaRepository<Bot, Integer> {
    Optional<Bot> findById(Integer integer);
}
