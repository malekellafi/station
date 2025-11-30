package Services.Implementing;

import Repositories.CoursRepository;
import Repositories.MoniteurRepository;
import Services.interfaces.IMoniteurService;
import org.example.station.entities.Cours;
import org.example.station.entities.Moniteur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoniteurServicesImpl implements IMoniteurService {

    private final MoniteurRepository moniteurRepository;
    private final CoursRepository coursRepository;

    public MoniteurServicesImpl(MoniteurRepository moniteurRepository, CoursRepository coursRepository) {
        this.moniteurRepository = moniteurRepository;
        this.coursRepository = coursRepository;
    }


    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }


    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(long num) {
        return moniteurRepository.findById(num).orElse(null);
    }


    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {

        Cours cours = (Cours) coursRepository.findBynumCourse(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + numCourse));

        moniteur.setCours(cours);

        return moniteurRepository.save(moniteur);
    }
}



