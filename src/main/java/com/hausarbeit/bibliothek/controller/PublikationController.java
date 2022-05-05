package com.hausarbeit.bibliothek.controller;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.model.PublikationMitSchlagwort;
import com.hausarbeit.bibliothek.model.Schlagwoerter;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import com.hausarbeit.bibliothek.services.Publikationservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller für Publikationen
 * @author Marlon Hippler
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PublikationController {


    private Publikationservices publikationservice;

    @Autowired
    public PublikationController(Publikationservices publikationservice) {
        this.publikationservice = publikationservice;
    }

    /**
     * Anlegen von einer neuen Publikation
     * @param request
     */
    @PostMapping("publikation/anlegen")
    public void publikationAnlegen(@RequestBody PublikationRequest request){
                   publikationservice.publikationAnlegen(request);
    }

    /**
     * Gibt alle Publikationen wieder
     * @return
     */
    @GetMapping("publikation/alleLaden")
    public List<PublikationMitSchlagwort> publikationenLaden() {
        return publikationservice.publikationenLaden();
    }

    /**
     * Löscht eine einzelne Publikation
     * @param publikationID
     */
    @DeleteMapping(path = "publikation/loeschen/{publikationID}")
    public void publikationLoeschen(@PathVariable("publikationID") Long publikationID) {
        publikationservice.publikationLoeschen(publikationID);
    }

    /**
     * Gibt eine einzelne Publikation wieder
     * @param publikationID
     * @return
     */
    @GetMapping(path = "publikation/laden/{publikationID}")
    public Publikation publikationLaden(@PathVariable Long publikationID) {
    return publikationservice.publikationLaden(publikationID);
    }

    /**
     * Updaten einer Publikation
     * @param publikationID
     * @param request
     */
    @PutMapping("publikation/update/{publikationID}")
    public void publikationUpdate(@PathVariable Long publikationID, @RequestBody PublikationRequest request){
            publikationservice.publikationUpdaten(publikationID,request);
    }

    /**
     * Gibt die zu einer Publikation gehörenden Ausleihvorgänge wieder
     * @param publikationID
     * @return
     */
    @GetMapping("publikation/ausleihvorgaenge/{publikationID}")
    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(@PathVariable Long publikationID){
        return publikationservice.zugehoerigeAusleihvorgaenge(publikationID);
    }

    }
