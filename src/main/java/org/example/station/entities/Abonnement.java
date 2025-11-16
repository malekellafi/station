package org.example.station.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbon;

    private LocalDateTime dateDeb;
    private LocalDateTime dateFin;
    private float prix;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

    @OneToOne(mappedBy = "abonnement")
    private Skieur skieur;
}
