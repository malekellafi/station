package Repositories;

import org.example.station.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    @Query("select i from Inscription i where i.endDate between :today and :sevenDaysLater")
    List<Inscription> findInscriptionsExpiringSoon(@Param("today") LocalDate today,
                                                   @Param("sevenDaysLater") LocalDate sevenDaysLater);
}
