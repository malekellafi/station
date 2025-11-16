package org.example.station.controllers;

import Services.interfaces.IMoniteurService;
import org.example.station.entities.Moniteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/moniteurs")
public class MoniteurController {


    private IMoniteurService moniteurService;


    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }


    @GetMapping("/all")
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }


    @PutMapping("/update")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @GetMapping("/{id}")
    public Moniteur retrieveMoniteur(@PathVariable("id") long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }
}