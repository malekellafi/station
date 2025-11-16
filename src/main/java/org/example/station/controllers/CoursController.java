package org.example.station.controllers;

import Services.interfaces.ICoursService;
import org.example.station.entities.Cours;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")

public class CoursController implements ICoursService {
    private ICoursService coursService;


    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }


    @GetMapping("/all")
    public List<Cours> retrieveAllCours() {
        return coursService.retrieveAllCours();
    }


    @PutMapping("/update")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }


    @GetMapping("/{id}")
    public Cours retrieveCours(@PathVariable("id") long numCours) {
        return coursService.retrieveCours(numCours);
    }
}