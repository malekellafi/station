package Services.Implementing;

import Repositories.SkieurRepository;
import Services.interfaces.ISkieurService;
import org.example.station.entities.Skieur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkieurServicesImpl implements ISkieurService {

    private final SkieurRepository skieurRepository;

    public SkieurServicesImpl(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
    }

    @Override
    public List<Skieur>retrieveAllSkieur(){
        return skieurRepository.findAll();
    }


    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }
    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).get();

    }
}
