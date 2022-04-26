package com.hausarbeit.bibliothek.controller;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import com.hausarbeit.bibliothek.services.Ausleihservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AusleihController {


    private Ausleihservices ausleihservice;

    @Autowired
    public AusleihController(Ausleihservices ausleihservice){
        this.ausleihservice = ausleihservice;
    }

    @PostMapping("ausleihen")
    public void publikationAusleihen(@RequestBody AusleihRequest request)  {

        ausleihservice.ausleihen(request);

    }
    @GetMapping("ausleihen/leihvorgaengeLaden")
    public List<Ausleihvorgang> ausleihvorgaengeLaden() {
        return ausleihservice.ausleihvorgaengeLaden();
    }

    @GetMapping("ausleihen/leihvorgangLaden/{vorgangID}")
    public Ausleihvorgang ausleihvorgangLaden(@PathVariable("vorgangID") Long vorgangID){
        return ausleihservice.ausleihvorgangLaden(vorgangID);
    }

    @PutMapping("ausleihen/zurueckgeben/{vorgangID}")
    public void zurueckgeben(@PathVariable Long vorgangID){
        ausleihservice.zurueckgeben(vorgangID);

    }

    @PutMapping("ausleihen/verlaengern/{vorgangID}")
    public void verlaengern(@PathVariable Long vorgangID){
        ausleihservice.verlaengern(vorgangID);
    }

}
