package org.example.station.controllers;

import Repositories.AbonnementRepository;
import Services.interfaces.IAbonnementService;
import org.example.station.entities.Abonnement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/abonnement")

public class AbonnementController implements IAbonnementService {
    private final IAbonnementService abonnementService;

    public AbonnementController(IAbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @GetMapping
    public List<Abonnement> getAll() {
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/{id}")
    public Abonnement getById(@PathVariable Long id) {
        return abonnementService.getAbonnementById(id);
    }

    @PostMapping
    public Abonnement add(@RequestBody Abonnement abonnement) {
        return abonnementService.addAbonnement(abonnement);
    }

    @PutMapping
    public Abonnement update(@RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(abonnement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
    }

    @Override
    public List<Abonnement> getAllAbonnements() {
        return List.of();
    }

    @Override
    public Abonnement getAbonnementById(long id) {
        return null;
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnemenet) {
        return null;
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnemenet) {
        return null;
    }

    @Override
    public void deleteAbonnement(long id) {

    }
}
