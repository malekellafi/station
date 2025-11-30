package org.example.station.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter


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




    public Skieur getInscriptions() {
        return null;
    }



    public void setInscriptions( List<Inscription> inscriptions ) {
    }

    public Object getTypeCours() {
        return null;
    }
}
