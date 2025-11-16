package Services.Implementing;

import Repositories.PisteRepository;
import Services.interfaces.IPisteService;
import org.example.station.entities.Piste;
import org.example.station.entities.Skieur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PisteServicesImpl implements IPisteService {

    private final PisteRepository pisteRepository;

    public PisteServicesImpl(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }
    @Override
    public Skieur retrievePiste(long numPiste) {
       retrievePiste(numPiste);
        return null;
    }
}
