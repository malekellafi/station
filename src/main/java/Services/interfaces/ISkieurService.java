package Services.interfaces;

import org.example.station.entities.Moniteur;
import org.example.station.entities.Skieur;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieur();



    Skieur addSkieur(Skieur skieur);



    void removeSkieur(Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
}
