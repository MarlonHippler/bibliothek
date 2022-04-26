package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class Publikationservices {

    private PublikationRepo publikationRepo;

    @Autowired
    public Publikationservices(PublikationRepo publikationRepo) {
        this.publikationRepo = publikationRepo;
    }

    public void publikationAnlegen(PublikationRequest request) {
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

    public void publikationUpdaten() {
    }

    public void publikationLoeschen(long publikationID) {
        boolean existiert = publikationRepo.existsById(publikationID);
        if (!existiert) {
            throw new IllegalStateException("Publikation mit ID" + publikationID + " existiert nicht");
        }
        publikationRepo.deleteById(publikationID);
    }


    public List<Publikation> publikationenLaden() {
        return this.publikationRepo.findAll();
    }

    public Publikation publikationLaden(Long publikationID) {
        if (publikationID == null) {
            throw new IllegalArgumentException("Publikations-ID ist notwendig!");}
            Publikation publikation;
            try {
                publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException(e.getMessage());

            }
            return publikation;
        }

    }


