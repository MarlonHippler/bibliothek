package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.PublikationException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Publikationservices {

    private PublikationRepo publikationRepo;
    private AusleihRepo ausleihRepo;

    @Autowired
    public Publikationservices(PublikationRepo publikationRepo, AusleihRepo ausleihRepo) {
        this.publikationRepo = publikationRepo;
        this.ausleihRepo = ausleihRepo;
    }

    public void publikationAnlegen(PublikationRequest request) {

        if (request.getBestandAnzahl() < 1){
            throw new PublikationException("Die Bestandsanzahl muss größer als null sein.");
        } else {
            if(request.getISBN() != null){
            UtilityService utilityService = new UtilityService();
            boolean check = utilityService.checkISBN(request.getISBN());
            if (check == false) {
                throw new PublikationException("ISBN Format falsch");
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

    public void publikationUpdaten(Long publikationID, Publikation request) {
        if (request.getBestandAnzahl() < 1){
            throw new PublikationException("Die Bestandsanzahl muss größer als null sein.");
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

    public void publikationLoeschen(long publikationID) {
        boolean existiert = publikationRepo.existsById(publikationID);
        if (!existiert) {
            throw new PublikationException("Publikation mit ID" + publikationID + " existiert nicht");
        }
        publikationRepo.deleteById(publikationID);
    }


    public List<Publikation> publikationenLaden() {
        return this.publikationRepo.findAll();
    }

    public Publikation publikationLaden(Long publikationID) {
        if (publikationID == null) {
            throw new PublikationException("Publikations-ID ist notwendig!");}
            Publikation publikation;
            try {
                publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException(e.getMessage());

            }
            return publikation;
        }

    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(Long publikationID) {
        return ausleihRepo.findByPublikationID(publikationID);
    }


}


