package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
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

    @Autowired
    public Ausleihservices (AusleihRepo ausleihRepo){
        this.ausleihRepo = ausleihRepo;
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

    public void zurueckgeben(){}

    public void verlaengern(){}
}
