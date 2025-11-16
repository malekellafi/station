package org.example.station.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;

public class Moniteur {
    @Id
    @GeneratedValue
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "moniteur")
    private Set<Cours> cours;


}
