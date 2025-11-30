package Repositories;

import org.example.station.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.Optional;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    static <T> ScopedValue<T> findBynumSkieur(Long numSkieur) {
    }

    Optional<Object> findByNumSkieur(Long numSkieur);
}
