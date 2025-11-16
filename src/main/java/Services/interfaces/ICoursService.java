package Services.interfaces;

import org.example.station.entities.Abonnement;
import org.example.station.entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCours();
    Cours updateCours(Cours cours);
    Cours retrieveCours(long numCours);
    Cours addCours(Cours cours);


}
