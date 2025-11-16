package Services.Implementing;

import Repositories.MoniteurRepository;
import Services.interfaces.IMoniteurService;
import org.example.station.entities.Moniteur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoniteurServicesImpl implements IMoniteurService {

    private final MoniteurRepository moniteurRepository;

    public MoniteurServicesImpl(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
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
        retrieveMoniteur(num);
        return null;
    }
}



