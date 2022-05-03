package com.hausarbeit.bibliothek;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import com.hausarbeit.bibliothek.services.Ausleihservices;
import com.hausarbeit.bibliothek.services.UtilityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class BibliothekApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BibliothekApplication.class, args);


		}
	@Bean
	CommandLineRunner commandLineRunner(PublikationRepo publikationrepo, AusleihRepo ausleihRepo) {
		return args -> {
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			String datumStringBuch = "1998-01-01";
			Date buchdatum= dt.parse(datumStringBuch);
			String datumStringAusgabe = "2022-05-03";
			String datumStringRueckgabe= "2022-05-17";
			Date ausgabe1 = dt.parse(datumStringAusgabe);
			Date rueckgabe1 = dt.parse(datumStringRueckgabe);

			Publikation harryPotter1 = new Publikation("Harry Potter und der Stein der Weisen",
					"J.K.Rowling",
					buchdatum,
					"randomVerlag",
					"Buch",
					"978-3551551672",
					"schlagwort",
					5);
			publikationrepo.save(harryPotter1);
			Long pubID = 1L;
			Ausleihvorgang vorgang = new Ausleihvorgang(ausgabe1,"Harry Potter und der Stein der Weisen",rueckgabe1,14,2,pubID,"Rowling","J.K",12314);
			ausleihRepo.save(vorgang);
		};
	};


}
