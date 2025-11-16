package Services.interfaces;

import org.example.station.entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    List<Inscription> getAllInscriptions();
    Inscription getInscriptionsById(long id);
    Inscription updateInscription(Inscription inscription);
    void deleteInscription(long id);

    Inscription getInscriptionById(long id);

    Inscription addInscription(Inscription inscription);
}
