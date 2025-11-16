package org.example.station.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.station.entities.Abonnement;
import org.example.station.entities.Piste;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateDeNaissance;
    private String ville;

    @OneToOne
    private Abonnement abonnement;

    @ManyToMany(mappedBy = "skieur")
    private Set<Piste> pistes;
}
