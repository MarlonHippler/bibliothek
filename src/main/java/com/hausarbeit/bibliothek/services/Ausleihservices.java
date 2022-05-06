package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.RequestBibliothekException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Services für die Ausleihvorgänge von Publikationen
 * @author Marlon Hippler
 */
@Service
public class Ausleihservices {

    private AusleihRepo ausleihRepo;
    private PublikationRepo publikationRepo;

    @Autowired
    public Ausleihservices (AusleihRepo ausleihRepo, PublikationRepo publikationRepo){
        this.ausleihRepo = ausleihRepo;
        this.publikationRepo = publikationRepo;
    }

    /**
     * Leiht eine Publikation aus dem Publikationbestand aus
     * @param ausleihRequest
     */
    public void ausleihen(AusleihRequest ausleihRequest){
        boolean existiert = publikationRepo.existsById(ausleihRequest.getPubID());
        if (existiert == false){
            throw new RequestBibliothekException("Die angegebene PublikationsID existiert nicht.");
        }
        Publikation publikation = publikationRepo.findPublikationByPublikationID(ausleihRequest.getPubID());
        Integer Bestandsanzahl = publikation.getBestandAnzahl();
        if(Bestandsanzahl<1){
            throw new RequestBibliothekException("Es sind nicht mehr genügend Exemplare verfügbar");
        } else {
            Ausleihvorgang ausleihvorgang = new Ausleihvorgang();
            ausleihvorgang.setMatrikelnummer(ausleihRequest.getMatrikelnummer());
            ausleihvorgang.setName(ausleihRequest.getName());
            ausleihvorgang.setVorname(ausleihRequest.getVorname());
            ausleihvorgang.setPubID(ausleihRequest.getPubID());
            ausleihvorgang.setPubTitel(publikation.getTitel());
            ausleihvorgang.setAusleihCounter(0);
            Calendar calendar = Calendar.getInstance();
            Date ausgabedatum = calendar.getTime();
            calendar.setTime(ausgabedatum);
            ausleihvorgang.setAusgabedatum(ausgabedatum);
            calendar.add(Calendar.DATE, Ausleihvorgang.ausleihzeitraum);
            Date rueckgabedatum = calendar.getTime();
            ausleihvorgang.setRueckgabedatum(rueckgabedatum);
            ausleihRepo.save(ausleihvorgang);


            Integer neueBestandsAnzahl = Bestandsanzahl - 1;
            publikation.setBestandAnzahl(neueBestandsAnzahl);
            publikationRepo.save(publikation);
        }
    }

    /**
     * Gibt alle Ausleihvorgänge wieder
     * @return List<Ausleihvorgang>
     */
    public List<Ausleihvorgang> ausleihvorgaengeLaden(){
        return this.ausleihRepo.findAll();
    }

    /**
     * Lädt einen einzelnen Ausleihvorgang anhand der ID
     * @param vorgangID
     * @return Ausleihvorgang
     */
    public Ausleihvorgang ausleihvorgangLaden(Long vorgangID) {

        Ausleihvorgang ausleihvorgang;
        ausleihvorgang = this.ausleihRepo.findAusleihvorgangByVorgangID(vorgangID);
        return ausleihvorgang;
    }

    /**
     * Gibt eine Publikation an den Bestand zurück, schließt Ausleihvorgang
     * @param vorgangID
     */
    public void zurueckgeben(Long vorgangID){

        Long pubID = ausleihRepo.findAusleihvorgangByVorgangID(vorgangID).getPubID();
        Integer neueAnzahl = publikationRepo.findPublikationByPublikationID(pubID).getBestandAnzahl()+1;

        Publikation publikation = publikationRepo.findPublikationByPublikationID(pubID);
        publikation.setBestandAnzahl(neueAnzahl);
        publikationRepo.save(publikation);

        ausleihRepo.deleteById(vorgangID);

    }

    /**
     * Verlängert die Ausleihperiode eines Ausleihvorgangs
     * @param vorgangID
     */
    public void verlaengern(Long vorgangID){

        Ausleihvorgang ausleihvorgang = ausleihRepo.findAusleihvorgangByVorgangID(vorgangID);
        int counter = ausleihvorgang.getAusleihCounter();
        if (counter>1){
            throw new RequestBibliothekException("Maximale Anzahl von Verlängerungen erreicht");
        } else {
            counter ++;
            Calendar calendar = Calendar.getInstance();
            Date altesRueckgabedatum = ausleihvorgang.getRueckgabedatum();
            calendar.setTime(altesRueckgabedatum);
            calendar.add(Calendar.DATE, Ausleihvorgang.ausleihzeitraum);
            Date neuesRueckgabedatum = calendar.getTime();
            ausleihvorgang.setRueckgabedatum(neuesRueckgabedatum);
            ausleihvorgang.setAusleihCounter(counter);
            ausleihRepo.save(ausleihvorgang);
        }

    }
}
