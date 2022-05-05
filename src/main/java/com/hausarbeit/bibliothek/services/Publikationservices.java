package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.RequestBibliothekException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Services rund ums Anlegen, löschen, laden und Bearbeiten von Publikationen
 * @author Marlon Hippler
 */
@Service
public class Publikationservices {

    private PublikationRepo publikationRepo;
    private AusleihRepo ausleihRepo;

    @Autowired
    public Publikationservices(PublikationRepo publikationRepo, AusleihRepo ausleihRepo) {
        this.publikationRepo = publikationRepo;
        this.ausleihRepo = ausleihRepo;
    }

    /**
     * Legt neue Publikation an
     * @param request
     */
    public void publikationAnlegen(PublikationRequest request) {

        if (request.getBestandAnzahl() < 1){
            throw new RequestBibliothekException("Die Bestandsanzahl muss größer als null sein.");
        } else {
            if(request.getISBN() != null){
            UtilityService utilityService = new UtilityService();
            boolean check = utilityService.checkISBN(request.getISBN());
            if (check == false) {
                throw new RequestBibliothekException("ISBN Format falsch");
            }
            }
            Publikation publikation = new Publikation();
            publikation.setTitel(request.getTitel());
            publikation.setPublikationsart(request.getPublikationsart());
            publikation.setAutor(request.getAutor());
            publikation.setISBN(request.getISBN());
            publikation.setBestandAnzahl(request.getBestandAnzahl());
            publikation.setVerlag(request.getVerlag());
            publikation.setSchlagwoerter(request.getSchlagwoerter());
            publikation.setVeroeffentlichung(request.getVeroeffentlichung());
            publikationRepo.save(publikation);
        }
    }

    /**
     * Updatet eine bestimmte Publikation anhand der ID
     * @param publikationID
     * @param request
     */
    public void publikationUpdaten(Long publikationID, Publikation request) {
        if (request.getBestandAnzahl() < 1){
            throw new RequestBibliothekException("Die Bestandsanzahl muss größer als null sein.");
        }
        Publikation publikationneu = publikationRepo.findPublikationByPublikationID(publikationID);
        publikationneu.setTitel(request.getTitel());
        publikationneu.setPublikationsart(request.getPublikationsart());
        publikationneu.setAutor(request.getAutor());
        publikationneu.setISBN(request.getISBN());
        publikationneu.setBestandAnzahl(request.getBestandAnzahl());
        publikationneu.setVerlag(request.getVerlag());
        publikationneu.setSchlagwoerter(request.getSchlagwoerter());
        publikationneu.setVeroeffentlichung(request.getVeroeffentlichung());
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
     * Gibt alle Publikationen wider
     * @return
     */
    public List<Publikation> publikationenLaden() {
        return this.publikationRepo.findAll();
    }

    /**
     * Gibt anhand der publikationID eine Publikation wider
     * @param publikationID
     * @return
     */
    public Publikation publikationLaden(Long publikationID) {
        if (publikationID == null) {
            throw new RequestBibliothekException("Publikations-ID ist notwendig!");}
            Publikation publikation;
            try {
                publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException(e.getMessage());

            }
            return publikation;
        }

    /**
     * Gibt die zu einer Publikation gehörenden Ausleihvorgänge anhand der publikationID wider
     * @param publikationID
     * @return
     */
    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(Long publikationID) {
        return ausleihRepo.findByPublikationID(publikationID);
    }


}


