package Services.interfaces;

import org.example.station.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {


    Moniteur addMoniteur(Moniteur moniteur);

    List<Moniteur> retrieveAllMoniteurs();

    Moniteur updateMoniteur(Moniteur moniteur);
    Moniteur retrieveMoniteur(long numMoniteur);


}
