package com.hausarbeit.bibliothek;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.model.Schlagwoerter;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.repo.SchlagwortRepo;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import com.hausarbeit.bibliothek.services.Ausleihservices;
import com.hausarbeit.bibliothek.services.Publikationservices;
import com.hausarbeit.bibliothek.services.UtilityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class BibliothekApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BibliothekApplication.class, args);
		}



}
