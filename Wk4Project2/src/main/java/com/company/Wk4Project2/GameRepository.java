package com.company.Wk4Project2;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByStudio (String studio);
    List<Game> findByESRB (String esrbRating);
    List<Game> findByTitle (String title);
}