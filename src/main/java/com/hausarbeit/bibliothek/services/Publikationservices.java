package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.RequestBibliothekException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.model.PublikationMitSchlagwort;
import com.hausarbeit.bibliothek.model.Schlagwoerter;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.repo.SchlagwortRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Services rund ums Anlegen, löschen, laden und Bearbeiten von Publikationen
 * @author Marlon Hippler
 */
@Service
public class Publikationservices {

    private PublikationRepo publikationRepo;
    private AusleihRepo ausleihRepo;
    private SchlagwortRepo schlagwortRepo;
    private UtilityService utilityService = new UtilityService();

    @Autowired
    public Publikationservices(PublikationRepo publikationRepo, AusleihRepo ausleihRepo,SchlagwortRepo schlagwortRepo) {
        this.publikationRepo = publikationRepo;
        this.ausleihRepo = ausleihRepo;
        this.schlagwortRepo =schlagwortRepo;
    }

    /**
     * Legt neue Publikation an
     * @param request
     */
    public void publikationAnlegen(PublikationRequest request) {
        utilityService.eingabenCheck(request);
        Publikation publikationZumReinwerfen = new Publikation();
        Publikation publikation = utilityService.zuweisenPublikationswerte(publikationZumReinwerfen,request,schlagwortRepo);
        publikationRepo.save(publikation);
    }

    /**
     * Updatet eine bestimmte Publikation anhand der ID
     * @param publikationID
     * @param request
     */
    public void publikationUpdaten(Long publikationID, PublikationRequest request) {

        utilityService.eingabenCheck(request);

        Publikation publikationalt = publikationRepo.findPublikationByPublikationID(publikationID);
        Publikation publikationneu = utilityService.zuweisenPublikationswerte(publikationalt,request,schlagwortRepo);
        publikationRepo.save(publikationneu);

    }

    /**
     * Löscht eine Publikation
     * @param publikationID
     */
    public void publikationLoeschen(long publikationID) {
        boolean existiert = publikationRepo.existsById(publikationID);
        if (!existiert) {
            throw new RequestBibliothekException("Publikation mit ID" + publikationID + " existiert nicht");
        }
        publikationRepo.deleteById(publikationID);
    }

    /**
     * Gibt alle Publikationen wieder in Form von PublikationMitSchlagwort,
     * da beim Objekt Publikation die Schlagwörter nicht auf der Frontend-Oberfläche angezeigt werden
     * @return List<PublikationMitSchlagwort>
     */
    public List<PublikationMitSchlagwort> publikationenLaden() {
        List<Publikation> publikationList = publikationRepo.findAll();
        List<PublikationMitSchlagwort> publikationMitSchlagwortList= new ArrayList<PublikationMitSchlagwort>();
        int laenge = publikationList.size();
        while (laenge > 0){
            int arrayPlatz = laenge -1;
            Publikation publikation;
            publikation = publikationList.get(arrayPlatz);
            PublikationMitSchlagwort publikationMitSchlagwort = utilityService.publikationMitSchlagwortFormatierung(publikation);
            publikationMitSchlagwortList.add(publikationMitSchlagwort);
            laenge = laenge -1;
        }
        return publikationMitSchlagwortList;
    }

    /**
     * Gibt anhand der publikationID eine PublikationMitSchlagwort wieder
     * @param publikationID
     * @return PublikationMitSchlagwort
     */
    public PublikationMitSchlagwort publikationLaden(Long publikationID) {

        Publikation publikation;
        publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
        PublikationMitSchlagwort publikationMitSchlagwort = utilityService.publikationMitSchlagwortFormatierung(publikation);
        return publikationMitSchlagwort;

        }

    /**
     * Gibt die zu einer Publikation gehörenden Ausleihvorgänge anhand der publikationID wieder
     * @param publikationID
     * @return List<Ausleihvorgang>
     */
    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(Long publikationID) {
        return ausleihRepo.findByPublikationID(publikationID);
    }


}


