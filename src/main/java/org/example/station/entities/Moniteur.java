package org.example.station.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Calendar;

public class Moniteur {
    @Id
    @GeneratedValue
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    @ManyToOne
    private Cours cours;


    public Calendar getCours() {
        return null;
    }

    public void setCours(Cours objects) {
    }
}
