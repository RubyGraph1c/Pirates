package com.example.codeclan.pirateservice.controllers;
import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

//AL:
@RestController
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;
    //inject instance of pirate repo into controller:
    @GetMapping(value = "/pirates") //"localhost:8080/pirates" - assigns this function to an url.
    public List<Pirate> getAllPirates(){
        //returns a list populated with pirate objects
        return pirateRepository.findAll();
    }

    //GET req.
    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){
        return pirateRepository.findById(id);
    }
    //Will return something containing a pirate or return null.
    //Optional allows us to return null.
}
