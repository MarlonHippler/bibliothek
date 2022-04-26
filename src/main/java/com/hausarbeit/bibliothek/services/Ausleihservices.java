package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Ausleihservices {

    private AusleihRepo ausleihRepo;
    private PublikationRepo publikationRepo;

    @Autowired
    public Ausleihservices (AusleihRepo ausleihRepo, PublikationRepo publikationRepo){
        this.ausleihRepo = ausleihRepo;
        this.publikationRepo = publikationRepo;
    }

    public void ausleihen(AusleihRequest ausleihRequest){
        Ausleihvorgang ausleihvorgang = new Ausleihvorgang();
        ausleihvorgang.setMatrikelnummer(ausleihRequest.getMatrikelnummer());
        ausleihvorgang.setName(ausleihRequest.getName());
        ausleihvorgang.setVorname(ausleihRequest.getVorname());
        ausleihvorgang.setPubID(ausleihRequest.getPubID());
        ausleihvorgang.setAusleihCounter(0);
        Calendar calendar = Calendar.getInstance();
        Date ausgabedatum = calendar.getTime();
        calendar.setTime(ausgabedatum);
        ausleihvorgang.setAusgabedatum(ausgabedatum);
        calendar.add(Calendar.DATE, Ausleihvorgang.ausleihzeitraum);
        Date rueckgabedatum = calendar.getTime();
        ausleihvorgang.setRueckgabedatum(rueckgabedatum);
        ausleihRepo.save(ausleihvorgang);

        Publikation publikation = publikationRepo.findPublikationByPublikationID(ausleihRequest.getPubID());
        Integer neueBestandsAnzahl = publikation.getBestandAnzahl() - 1;
        publikation.setBestandAnzahl(neueBestandsAnzahl);
        publikationRepo.save(publikation);
    }

    public List<Ausleihvorgang> ausleihvorgaengeLaden(){
        return this.ausleihRepo.findAll();
    }

    public Ausleihvorgang ausleihvorgangLaden(Long vorgangID) {
        if (vorgangID == null) {
            throw new IllegalArgumentException("Vorgang-ID ist notwendig!");}
        Ausleihvorgang ausleihvorgang;
        try {
            ausleihvorgang = this.ausleihRepo.findAusleihvorgangByVorgangID(vorgangID);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());

        }
        return ausleihvorgang;
    }

    public void zurueckgeben(Long vorgangID){

        Long pubID = ausleihRepo.findAusleihvorgangByVorgangID(vorgangID).getPubID();
        Integer neueAnzahl = publikationRepo.findPublikationByPublikationID(pubID).getBestandAnzahl()+1;

        Publikation publikation = publikationRepo.findPublikationByPublikationID(pubID);
        publikation.setBestandAnzahl(neueAnzahl);
        publikationRepo.save(publikation);

        ausleihRepo.deleteById(vorgangID);

    }

    public void verlaengern(Long vorgangID){

        Ausleihvorgang ausleihvorgang = ausleihRepo.findAusleihvorgangByVorgangID(vorgangID);
        int counter = ausleihvorgang.getAusleihCounter();
        if (counter>1){
            throw new IllegalArgumentException("Maximale Anzahl von Verlängerungen erreicht");
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
