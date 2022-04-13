package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.stereotype.Service;

@Service
public class Publikationservices {

    PublikationRepo publikationRepo;

    public void publikationAnlegen(PublikationRequest request){
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

    public void publikationUpdaten(){}

    public void publikationLoeschen(){}

    public void publikationAnzeigen(){}
}
