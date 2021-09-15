package com.example.homework.repository;

import com.example.homework.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    Game findByTitle(String title);

    @Modifying
    Optional<Game> findById(Long id);
}
