package org.example.station.entities;

import jakarta.persistence.*;

import java.util.Set;

public class Cours {
    @Id
    @GeneratedValue
    private Long numCours;
    private int niveau;
    private float prix;
    private int creneau;
    @Enumerated(EnumType.STRING)
    private Typecours typecours;
    private Support support;
    @ManyToOne
    private Moniteur moniteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy ="cours")
    private Set<Inscription> inscription;



}
