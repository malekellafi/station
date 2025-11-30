package Services.Implementing;

import Repositories.InscriptionRepository;
import Repositories.SkieurRepository;
import Repositories.CoursRepository;
import Services.interfaces.ISkieurService;
import org.example.station.entities.Cours;
import org.example.station.entities.Inscription;
import org.example.station.entities.Skieur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkieurServicesImpl implements ISkieurService {

    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;

    public SkieurServicesImpl(SkieurRepository skieurRepository,
                              CoursRepository coursRepository,
                              InscriptionRepository inscriptionRepository) {
        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public List<Skieur> retrieveAllSkieur() {
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
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {

        Cours cours = coursRepository.findById(numCourse).orElseThrow();

        if (skier.getAbonnement() == null) {
            throw new RuntimeException("Skieur must contain an Abonnement object.");
        }

        Skieur savedSkieur = skieurRepository.save(skier);

        Inscription inscription = new Inscription();
        inscription.setSkieur(savedSkieur);
        inscription.setCours(cours);
        inscription.setNumSemaine(0);

        if (savedSkieur.getInscriptions() == null)
            savedSkieur.setInscriptions(new ArrayList<>());
        savedSkieur.getInscriptions().add(inscription);

        if (cours.getInscriptions() == null)
            cours.setInscriptions(new ArrayList<>());
        cours.getInscriptions().add(inscription);

        inscriptionRepository.save(inscription);

        return skieurRepository.save(savedSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }
}
