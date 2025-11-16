package org.example.station.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    private int longeur;
    private int pente;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    @ManyToMany(mappedBy = "pistes")
    private Set<Skieur> skieurs;
}
