package Repositories;

import org.example.station.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
     Optional<Object> findBynumCourse(Long id);

}
