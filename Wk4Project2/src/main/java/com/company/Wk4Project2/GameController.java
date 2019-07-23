package com.company.Wk4Project2;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    //returns all games
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<Game> getAllGames(){return gameRepository.findAll();}

    //adds a game to database
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public Game addGame(@RequestBody @Valid Game game){
        gameRepository.save(game);
        return game;
    }

    //updates game information
    @RequestMapping(value = "/games/{id}", method = RequestMethod.PUT)
    public Game updateGame(@RequestBody @Valid Game game, @PathVariable Integer id) {
        gameRepository.save(game);
        return game;
    }

    //deletes game from inventory
    @RequestMapping(value = "/games/{id}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable Integer id){
        gameRepository.deleteById(id);
    }

    //returns games by Studio
    @RequestMapping(value = "/games/{studio}", method = RequestMethod.GET)
    public List<Game> findByStudio(@PathVariable String studio){
        return gameRepository.findByStudio((studio));
    }

    //returns games by ESRB
    @RequestMapping(value = "/games/{esrb}", method = RequestMethod.GET)
    public List<Game> findByESRB(@PathVariable String esrbRating){
        return gameRepository.findByESRB(esrbRating);
    }

    //returns games by Title
    @RequestMapping(value = "/games/{title}", method = RequestMethod.GET)
    public List<Game> findByTitle(@PathVariable String title){
        return gameRepository.findByTitle(title);

    }
}

