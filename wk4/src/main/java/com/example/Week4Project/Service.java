package com.example.Week4Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {
    @Autowired

    private ConsoleRepository consoleRepository;

    public List<Console> findByManufacturer(String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }


}
