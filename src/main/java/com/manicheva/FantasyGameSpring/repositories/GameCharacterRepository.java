package com.manicheva.FantasyGameSpring.repositories;

import com.manicheva.FantasyGameSpring.models.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameCharacterRepository extends JpaRepository <GameCharacter, Integer> {
    Optional <GameCharacter> findById(Integer integer);

}
