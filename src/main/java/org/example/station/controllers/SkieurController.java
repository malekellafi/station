package org.example.station.controllers;

import Services.interfaces.ISkieurService;
import org.example.station.entities.Skieur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skieurs")
public class SkieurController implements ISkieurService {

    private final ISkieurService skieurService;

    public SkieurController(ISkieurService skieurService) {
        this.skieurService = skieurService;
    }


    @Override
    public List<Skieur> retrieveAllSkieur() {
        return List.of();
    }

    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {

    }



    @DeleteMapping("/removeSkieur")
    public void removeSkieur(long numSkieur) {
        skieurService.removeSkieur(numSkieur);
    }

    @GetMapping("/{id}")
    public Skieur retrieveSkieur(@PathVariable Long id) {
        return skieurService.retrieveSkieur(id);
    }

    @GetMapping("/All")
    public List<Skieur> retrieveAllSkieurs() {
        return null;
    }
    @PostMapping("/addAndAssignCourse/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable Long numCourse) {
        return skieurService.addSkierAndAssignToCourse(skieur, numCourse);
    }



}