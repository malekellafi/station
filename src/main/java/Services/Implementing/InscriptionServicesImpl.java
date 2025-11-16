package Services.Implementing;

import Repositories.InscriptionRepository;
import Services.interfaces.IInscriptionService;
import org.example.station.entities.Inscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServicesImpl implements IInscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public InscriptionServicesImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscriptionsById(long id) {
        return null;
    }

    @Override
    public Inscription getInscriptionById(long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteInscription(long id) {
        inscriptionRepository.deleteById(id);
    }
}
