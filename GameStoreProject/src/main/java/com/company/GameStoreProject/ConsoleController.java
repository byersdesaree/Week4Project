package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    private ConsoleRepository consoleRepo;

    @RequestMapping (value = "/console", method = RequestMethod.POST)
    public Console createConsole(@RequestBody @Valid Console console) {
        consoleRepo.save(console);
        return console;
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    public Console getConsoleById (@PathVariable Integer id){
        return consoleRepo.getOne(id);
    }

    @RequestMapping(value = "/console",method = RequestMethod.GET)
    public List<Console> getAllConsoles(){
        return consoleRepo.findAll();
    }
    @RequestMapping(value = "/console/{id}",method = RequestMethod.PUT)
    public void updateConsole(@RequestBody Console console, @PathVariable Integer id) {
        consoleRepo.save(console);
    }
    @RequestMapping(value = "/console/id}",method = RequestMethod.DELETE)
    public void deleteConsole(@PathVariable Integer id){
        consoleRepo.deleteById(id);
    }

    @RequestMapping(value = "/consoleByManufacturer/{manufacturer}", method = RequestMethod.GET)
    public List<Console> getConsoleByManufacturer (@PathVariable String manufacturer) {
        return consoleRepo.findByManufacturer(manufacturer);
    }




}
