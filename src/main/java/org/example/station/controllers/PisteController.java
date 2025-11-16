package org.example.station.controllers;

import Services.interfaces.IPisteService;
import org.example.station.entities.Piste;
import org.example.station.entities.Skieur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pistes")
public class PisteController implements IPisteService {

    private final IPisteService pisteService;

    public PisteController(IPisteService pisteService) {
        this.pisteService = pisteService;
    }

    @PostMapping("/addSkieur")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/{id}")
    public Skieur retrievePiste(@PathVariable long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @GetMapping("/All")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();

    }


}