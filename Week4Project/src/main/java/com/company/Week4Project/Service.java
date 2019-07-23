package com.company.Week4Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Component
public class Service {
    @Autowired
    private GameRepository gameRepository;

    //AddGame method for service layer
    public Game addGame(Game game){
        gameRepository.save(game);
        return game;
    }

    //show all method for service layer
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    //update game by gameId for service layer
    public void updateGame(Game game, int id){
        if(game.getGameId() != id) {
            throw new IllegalArgumentException("Id must match the id provided");
        }
        gameRepository.save(game);
    }

    //deletes game from inventory
    public void deleteGame( int gameId){
        gameRepository.deleteById(gameId);
    }

    //returns games by Studio
    public List<Game> findByStudio( String studio){
        return gameRepository.findByStudio((studio));
    }

    //returns games by ESRB
    public List<Game> findByEsrbRating(String esrbRating){
        return gameRepository.findByEsrbRating(esrbRating);
    }

    public List<Game> findByTitle(String title){
        return gameRepository.findByTitle(title);
    }

}
