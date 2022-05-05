package com.hausarbeit.bibliothek.controller;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import com.hausarbeit.bibliothek.services.Ausleihservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller für Ausleihvorgänge
 * @author Marlon Hippler
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AusleihController {


    private Ausleihservices ausleihservice;

    @Autowired
    public AusleihController(Ausleihservices ausleihservice){
        this.ausleihservice = ausleihservice;
    }

    /**
     * Ausleihen von Publikationen
     * @param request
     */
    @PostMapping("ausleihen")
    public void publikationAusleihen(@RequestBody AusleihRequest request)  {

        ausleihservice.ausleihen(request);

    }

    /**
     * Gibt alle Ausleihvorgänge wider
     * @return
     */
    @GetMapping("ausleihen/leihvorgaengeLaden")
    public List<Ausleihvorgang> ausleihvorgaengeLaden() {
        return ausleihservice.ausleihvorgaengeLaden();
    }

    /**
     * Gibt einen einzelnen Ausleihvorgang anhand der vorgangID wider
     * @param vorgangID
     * @return
     */
    @GetMapping("ausleihen/leihvorgangLaden/{vorgangID}")
    public Ausleihvorgang ausleihvorgangLaden(@PathVariable("vorgangID") Long vorgangID){
        return ausleihservice.ausleihvorgangLaden(vorgangID);
    }

    /**
     * Zurückgeben einer Publikation
     * @param vorgangID
     */
    @PutMapping("ausleihen/zurueckgeben/{vorgangID}")
    public void zurueckgeben(@PathVariable Long vorgangID){
        ausleihservice.zurueckgeben(vorgangID);

    }

    /**
     * Verlängern eines Ausleihvorgangs
     * @param vorgangID
     */
    @PutMapping("ausleihen/verlaengern/{vorgangID}")
    public void verlaengern(@PathVariable Long vorgangID){
        ausleihservice.verlaengern(vorgangID);
    }

}
