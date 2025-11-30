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

    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Inscription addRegistrationAndAssignToSkieur(Inscription inscription, Long numSkier);

    Inscription addRegistrationAndAssignToSkierAndCourse(
            Inscription inscription,
            Long numSkieur,
            Long numCours);

    List<Inscription> getExpiringInscriptions();
}
