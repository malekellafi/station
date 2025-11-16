package Services.interfaces;

import org.example.station.entities.Piste;
import org.example.station.entities.Skieur;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();


    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Skieur retrievePiste(long numPiste);
}
