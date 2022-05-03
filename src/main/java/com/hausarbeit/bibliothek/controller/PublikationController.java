package com.hausarbeit.bibliothek.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.hausarbeit.bibliothek.exception.InvalidExceptionPublikation;
import com.hausarbeit.bibliothek.exception.NeueException;
import com.hausarbeit.bibliothek.exception.PublikationException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import com.hausarbeit.bibliothek.services.Publikationservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PublikationController {


    private Publikationservices publikationservice;

    @Autowired
    public PublikationController(Publikationservices publikationservice) {
        this.publikationservice = publikationservice;
    }

    @PostMapping("publikation/anlegen")
    public void publikationAnlegen(@RequestBody PublikationRequest request){
                   publikationservice.publikationAnlegen(request);
    }

    @GetMapping("publikation/alleLaden")
    public List<Publikation> publikationenLaden() {
        return publikationservice.publikationenLaden();
    }


    @DeleteMapping(path = "publikation/loeschen/{publikationID}")
    public void publikationLoeschen(@PathVariable("publikationID") Long publikationID) {
        publikationservice.publikationLoeschen(publikationID);
    }

    @GetMapping(path = "publikation/laden/{publikationID}")
    public Publikation publikationLaden(@PathVariable Long publikationID) {
    return publikationservice.publikationLaden(publikationID);
    }

    @PutMapping("publikation/update/{publikationID}")
    public void publikationUpdate(@PathVariable Long publikationID, @RequestBody Publikation publikation){
            publikationservice.publikationUpdaten(publikationID,publikation);
    }

    @GetMapping("publikation/ausleihvorgaenge/{publikationID}")
    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(@PathVariable Long publikationID){
        return publikationservice.zugehoerigeAusleihvorgaenge(publikationID);
    }


    }
