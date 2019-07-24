package com.company.Week4Project;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public Invoice addInvoice(@RequestBody Invoice invoice){
        service.addInvoice(invoice);
        return invoice;
    }

    //returns all games
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<Game> getAllGames(){return service.getAllGames();}

    //adds a game to database
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public Game addGame(@RequestBody Game game){
        service.addGame(game);
        return game;
    }

    //updates game information
    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.PUT)
    public Game updateGame(@RequestBody @Valid Game game, @PathVariable Integer gameId) {
        service.addGame(game);
        return game;
    }

    //deletes game from inventory
    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable Integer gameId){
        service.deleteGame(gameId);
    }

    //returns games by Studio
    @RequestMapping(value = "/games/{studio}", method = RequestMethod.GET)
    public List<Game> findByStudio(@PathVariable String studio){
        return service.findByStudio((studio));
    }

    //returns games by ESRB
    @RequestMapping(value = "/games/{esrb}", method = RequestMethod.GET)
    public List<Game> findByEsrbRating(@PathVariable String esrbRating){
        return service.findByEsrbRating(esrbRating);
    }

    //returns games by Title
    @RequestMapping(value = "/games/{title}", method = RequestMethod.GET)
    public List<Game> findByTitle(@PathVariable String title){
        return service.findByTitle(title);

    }


}
