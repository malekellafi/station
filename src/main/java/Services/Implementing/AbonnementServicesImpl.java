package Services.Implementing;

import Repositories.AbonnementRepository;
import Services.interfaces.IAbonnementService;
import org.example.station.entities.Abonnement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementServicesImpl implements IAbonnementService {

    private final AbonnementRepository abonnementRepository;

    public AbonnementServicesImpl(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement getAbonnementById(long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void deleteAbonnement(long id) {

        abonnementRepository.deleteById(id);
    }
}
