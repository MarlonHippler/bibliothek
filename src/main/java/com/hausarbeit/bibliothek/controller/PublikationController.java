package com.hausarbeit.bibliothek.controller;

import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import com.hausarbeit.bibliothek.services.Publikationservices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PublikationController {


    private Publikationservices publikationservice;

    @Autowired
    public PublikationController(Publikationservices publikationservice){
        this.publikationservice = publikationservice;
    }

    @PostMapping("publikation/anlegen")
    public void publikationAnlegen(@RequestBody PublikationRequest request)  {

        publikationservice.publikationAnlegen(request);

    }
    @PostMapping("publikation/laden")
    public List<Publikation> publikationenLaden() {
        return publikationservice.publikationenLaden();
    }



}
