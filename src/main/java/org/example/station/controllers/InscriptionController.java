package org.example.station.controllers;

import Services.interfaces.IInscriptionService;
import org.example.station.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController implements IInscriptionService {

    private final IInscriptionService inscriptionService;

    public InscriptionController(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }

    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription inscription) {
        return inscriptionService.updateInscription(inscription);
    }

    @Override
    public void deleteInscription(long id) {

    }

    @Override
    public Inscription getInscriptionById(long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @Override
    public Inscription getInscriptionsById(long id) {
        return null;
    }

    @GetMapping("/{id}")
    public Inscription getInscription(@PathVariable Long id) {
        return inscriptionService.getInscriptionById(id);
    }
}
