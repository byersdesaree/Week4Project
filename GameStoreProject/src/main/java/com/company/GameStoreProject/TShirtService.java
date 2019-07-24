package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TShirtService {

    @Autowired
    TShirtRepository tshirtRepo;

    public List<TShirt> getAllTShirtsFromInv(){
        return tshirtRepo.findAll();
    }

    public List<TShirt> getAllTShirtsByColor(String color){
        return tshirtRepo.findTShirtByColor(color);
    }

    public List<TShirt> getAllTShirtsBySize(String size){
        return tshirtRepo.findTShirtBySize(size);
    }


    public TShirt getTShirtByIdFromInv(Integer id){

        return tshirtRepo.getOne(id);
    }

    public TShirt addTShirtIntoInv(TShirt tshirt){
        return tshirtRepo.save(tshirt);
    }

    public TShirt updateTShirtInInv(TShirt tshirt, Integer id){
        if(tshirt.gettShirtId() != id)
        {
            throw new IllegalArgumentException("TShirt ID doesnt match with the Id passed in URL");
        }
        return tshirtRepo.save(tshirt);
    }

    public void removeTShirtFromInv(Integer id){

        tshirtRepo.deleteById(id);
    }
}
