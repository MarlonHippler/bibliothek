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

        if (request.getBestandAnzahl() < 1){
            throw new RequestBibliothekException("Die Bestandsanzahl muss größer als null sein.");
        } else {
            System.out.println(request.getISBN());
            if(request.getISBN() != ""){
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
            publikation.setVeroeffentlichung(request.getVeroeffentlichung());
            publikation.schlagwoerter = new ArrayList<Schlagwoerter>();
            String[] schlagwoerter = request.getSchlagwoerter();
            int laenge = schlagwoerter.length;
            while (laenge > 0){
                int arrayStelle = laenge-1;
                String schlagwortString = schlagwoerter[arrayStelle];
                Long id = schlagwortRepo.findBySchlagwort(schlagwortString);
                Schlagwoerter schlagwort = schlagwortRepo.findSchlagwoerterBySchlagwoerterID(id);
                publikation.schlagwörterZuweisen(schlagwort);
                laenge = laenge-1;
            }
            publikationRepo.save(publikation);

        }
    }

    /**
     * Updatet eine bestimmte Publikation anhand der ID
     * @param publikationID
     * @param request
     */
    public void publikationUpdaten(Long publikationID, PublikationRequest request) {
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
        publikationneu.setVeroeffentlichung(request.getVeroeffentlichung());
        publikationneu.schlagwoerter = new ArrayList<Schlagwoerter>();
        String[] schlagwoerter = request.getSchlagwoerter();
        int laenge = schlagwoerter.length;
        while (laenge > 0){
            int arrayStelle = laenge-1;
            String schlagwortString = schlagwoerter[arrayStelle];
            Long id = schlagwortRepo.findBySchlagwort(schlagwortString);
            Schlagwoerter schlagwort = schlagwortRepo.findSchlagwoerterBySchlagwoerterID(id);
            publikationneu.schlagwörterZuweisen(schlagwort);
            laenge = laenge-1;
        }
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
    public List<PublikationMitSchlagwort> publikationenLaden() {
        List<Publikation> publikationList = publikationRepo.findAll();
        List<PublikationMitSchlagwort> publikationMitSchlagwortList= new ArrayList<PublikationMitSchlagwort>();
        int laenge = publikationList.size();
        while (laenge > 0){
            int arrayPlatz = laenge -1;
            Publikation publikation;
            PublikationMitSchlagwort publikationMitSchlagwort= new PublikationMitSchlagwort();
            publikation = publikationList.get(arrayPlatz);
            List<Schlagwoerter> schlagwoerterList= publikation.getSchlagwoerter();
            int laengeZwei = schlagwoerterList.size();
            String[] schlagwortArray = new String[laengeZwei];
            while (laengeZwei > 0){
                int arrayPlatzZwei = laengeZwei -1;
                Schlagwoerter schlagwortObjekt = schlagwoerterList.get(arrayPlatzZwei);
                String schlagwort = schlagwortObjekt.getSchlagwort();
                schlagwortArray[arrayPlatzZwei] = schlagwort;
                laengeZwei = laengeZwei -1;
            }
            publikationMitSchlagwort.setTitel(publikation.getTitel());
            publikationMitSchlagwort.setPublikationID(publikation.getPublikationID());
            publikationMitSchlagwort.setPublikationsart(publikation.getPublikationsart());
            publikationMitSchlagwort.setSchlagwoerter(schlagwortArray);
            publikationMitSchlagwort.setAutor(publikation.getAutor());
            publikationMitSchlagwort.setBestandAnzahl(publikation.getBestandAnzahl());
            publikationMitSchlagwort.setISBN(publikation.getISBN());
            publikationMitSchlagwort.setVerlag(publikation.getVerlag());
            publikationMitSchlagwort.setVeroeffentlichung(publikation.getVeroeffentlichung());
            publikationMitSchlagwortList.add(publikationMitSchlagwort);
            laenge = laenge -1;
        }
        return publikationMitSchlagwortList;
    }

    /**
     * Gibt anhand der publikationID eine Publikation wider
     * @param publikationID
     * @return
     */
    public Publikation publikationLaden(Long publikationID) {

        Publikation publikation;
        publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
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


    public void verbindungSuP(Long schlagwoerterID, Long publikationID) {
        Schlagwoerter schlagwort = schlagwortRepo.getById(schlagwoerterID);
        Publikation publikation = publikationRepo.getById(publikationID);
        schlagwort.publikationZuweisen(publikation);
        schlagwortRepo.save(schlagwort);
    }
}


