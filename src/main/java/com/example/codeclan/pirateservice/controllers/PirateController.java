package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    private PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
//    @RequestMapping(value = "/pirates", method = RequestMethod.GET)
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirateById(@PathVariable Long id) {
        return pirateRepository.findById(id);
    }
}
