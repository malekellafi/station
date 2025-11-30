package org.example.station.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class Inscription {
    @Id
    @GeneratedValue
    private Long numinscription;
    private int numsemaine;
    @ManyToOne
    private Skieur skieur;
    @ManyToOne
    private Cours cours;

    public int getNumSemaine() {
        return this.numsemaine;
    }

    public void setSkieur(Skieur skieur) {
    }

    public void setCours(Cours cours) {
        this.cours = (Cours) cours;
    }

    public void setNumSemaine(int i) {
        this.numsemaine = i;
    }


    public Object getSkieur() {
        return null;
    }

    public String getIdInscription() {

return  null;  }

    public Object getCours() {
        return null;
    }
}

