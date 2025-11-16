package Services.interfaces;

import org.example.station.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    List<Abonnement>getAllAbonnements();
    Abonnement getAbonnementById(long id);
    Abonnement updateAbonnement(Abonnement abonnemenet);
    Abonnement addAbonnement(Abonnement abonnemenet);
    void deleteAbonnement(long id);


}
