package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {


    @Autowired
    TShirtService tShirtService;

    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    public TShirt createTShirt(@RequestBody @Valid TShirt tshirt){
        return tShirtService.addTShirtIntoInv(tshirt);
    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    public List<TShirt> getAllTShirts(){
        return tShirtService.getAllTShirtsFromInv();
    }



    @RequestMapping(value="/tshirt/{id}", method = RequestMethod.GET)
    public TShirt getTShirtById(@PathVariable Integer id){
        return tShirtService.getTShirtByIdFromInv(id);
    }

    @RequestMapping(value="/tshirt/color/{color}", method = RequestMethod.GET)
    public List<TShirt> getTShirtByColor(@PathVariable String color){
        return tShirtService.getAllTShirtsByColor(color);
    }

    @RequestMapping(value="/tshirt/size/{size}", method = RequestMethod.GET)
    public List<TShirt> getTShirtBySize(@PathVariable String size){
        return tShirtService.getAllTShirtsBySize(size);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.PUT)
    public TShirt updateTShirt(@RequestBody @Valid TShirt tshirt, @PathVariable Integer id){
        return tShirtService.updateTShirtInInv(tshirt, id);
    }


    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    public void deleteTShirt(@PathVariable Integer id){
        tShirtService.removeTShirtFromInv(id);
    }

}
