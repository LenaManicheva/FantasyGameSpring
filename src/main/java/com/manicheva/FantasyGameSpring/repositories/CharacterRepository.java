package com.manicheva.FantasyGameSpring.repositories;

import com.manicheva.FantasyGameSpring.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository <Character, Integer> {
    Optional <Character> findById(Integer integer);

}
