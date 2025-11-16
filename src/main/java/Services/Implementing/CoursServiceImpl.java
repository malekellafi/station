package Services.Implementing;

import Repositories.CoursRepository;
import Services.interfaces.ICoursService;
import org.example.station.entities.Cours;

import java.util.List;

public class CoursServiceImpl implements ICoursService {
    private final CoursRepository coursRepository;
    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(long numCours) {
        return null;
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }
}
