// java
package Services.Implementing;

import Repositories.CoursRepository;
import Repositories.InscriptionRepository;
import Repositories.SkieurRepository;
import Services.interfaces.IInscriptionService;
import lombok.Getter;
import lombok.Setter;
import org.example.station.entities.Cours;
import org.example.station.entities.Inscription;
import org.example.station.entities.Skieur;
import org.example.station.entities.Typecours;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class InscriptionServicesImpl implements IInscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    public InscriptionServicesImpl(
            InscriptionRepository inscriptionRepository,
            SkieurRepository skieurRepository,
            CoursRepository coursRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscriptionsById(long id) {
        return inscriptionRepository.findById(id).orElse(null);
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
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow();
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.findById(numRegistration).orElseThrow();
        Cours cours = coursRepository.findById(numCourse).orElseThrow();
        inscription.setCours(cours);

        List<Inscription> inscriptions = (List<Inscription>) cours.getInscriptions();
        if (inscriptions == null) {
            inscriptions = new ArrayList<>();
            cours.setInscriptions(inscriptions);
        }
        if (!inscriptions.contains(inscription)) {
            inscriptions.add(inscription);
        }
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        return null;
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteInscription(long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(
            Inscription inscription,
            Long numSkieur,
            Long numCours) {

        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow();
        Cours cours = coursRepository.findById(numCours).orElseThrow();

        if (cours.getTypeCours() == Typecours.COLLECTIF_ENFANT ||
                cours.getTypeCours() == Typecours.COLLECTIF_ADULTE) {

            if (cours.getInscriptions() != null && cours.getInscriptions().size() >= 6) {
                throw new RuntimeException("Cannot register: Course already has 6 skiers.");
            }
        }

        int age = Period.between(skieur.getDateNaissance(), LocalDate.now()).getYears();

        if (cours.getTypeCours() == Typecours.COLLECTIF_ENFANT && age > 12) {
            throw new RuntimeException("Skieur too old for COLLECTIF_ENFANT course.");
        }

        if (cours.getTypeCours() == Typecours.COLLECTIF_ADULTE && age <= 12) {
            throw new RuntimeException("Skieur too young for COLLECTIF_ADULTE course.");
        }

        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        if (skieur.getInscriptions() == null)
            skieur.setInscriptions(new ArrayList<>());
        skieur.getInscriptions().add(inscription);

        if (cours.getInscriptions() == null)
            cours.setInscriptions(new ArrayList<>());
        cours.getInscriptions().add(inscription);

        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> getExpiringInscriptions() {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysLater = today.plusDays(7);

        return inscriptionRepository.findInscriptionsExpiringSoon(today, sevenDaysLater);
    }

    // ---------------- TÂCHE PLANIFIÉE ----------------
    @Scheduled(cron = "0 0 8 * * *") // tous les jours à 08h
    public void retrieveSubscriptions() {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysLater = today.plusDays(7);

        // Récupère les inscriptions qui expirent dans les 7 prochains jours
        List<Inscription> expiringSubscriptions =
                inscriptionRepository.findInscriptionsExpiringSoon(today, sevenDaysLater);

        // Parcours chaque inscription et affiche les infos
        expiringSubscriptions.forEach(sub -> {

            Skieur aSkieur = (Skieur) sub.getSkieur();

            //log.info(sub.getIdInscription().toString() + " | "
                   // + sub.getCours().getEndDate().toString() + " | "
                 //   + aSkieur.getFirstName() + " " + aSkieur.getLastName());

        });
    }
}




