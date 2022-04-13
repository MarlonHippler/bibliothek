package com.hausarbeit.bibliothek.controller;

import com.hausarbeit.bibliothek.request.PublikationRequest;
import com.hausarbeit.bibliothek.services.Publikationservices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class PublikationController {
    @Autowired
    private Publikationservices publikationservice;

    @PostMapping("publikation/anlegen")
    public void publikationAnlegen(@RequestBody PublikationRequest request)  {

        publikationservice.publikationAnlegen(request);
    }

}
