package com.hausarbeit.bibliothek;

import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.model.Schlagwoerter;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.repo.SchlagwortRepo;
import com.hausarbeit.bibliothek.request.AusleihRequest;
import com.hausarbeit.bibliothek.services.Ausleihservices;
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
	@Bean
	CommandLineRunner commandLineRunner(PublikationRepo publikationrepo, AusleihRepo ausleihRepo, SchlagwortRepo schlagwortRepo) {
		return args -> {

			Schlagwoerter schlagwort1 = new Schlagwoerter("Wissenschaft");
			Schlagwoerter schlagwort2 = new Schlagwoerter("Fantasy");
			Schlagwoerter schlagwort3 = new Schlagwoerter("Roman");
			Schlagwoerter schlagwort4 = new Schlagwoerter("Geschichte");
			schlagwortRepo.save(schlagwort1);
			schlagwortRepo.save(schlagwort2);
			schlagwortRepo.save(schlagwort3);
			schlagwortRepo.save(schlagwort4);
			String[] schlagwoerter = {"Hans","Franz"};
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			String datumStringBuch1 = "1997-01-01";
			String datumStringBuch2 = "1998-01-01";
			String datumStringBuch3 = "1999-01-01";
			String datumStringBuch4 = "2000-01-01";
			String datumStringBuch5 = "2003-01-01";
			String datumStringBuch6 = "2005-01-01";
			String datumStringBuch7 = "2007-01-01";
			Date buchdatum1 = dt.parse(datumStringBuch1);
			Date buchdatum2 = dt.parse(datumStringBuch2);
			Date buchdatum3 = dt.parse(datumStringBuch3);
			Date buchdatum4 = dt.parse(datumStringBuch4);
			Date buchdatum5 = dt.parse(datumStringBuch5);
			Date buchdatum6 = dt.parse(datumStringBuch6);
			Date buchdatum7 = dt.parse(datumStringBuch7);
			Date buchdatum8 = dt.parse(datumStringBuch7);
			String datumStringAusgabe = "2022-05-03";
			String datumStringRueckgabe= "2022-05-17";
			Date ausgabe1 = dt.parse(datumStringAusgabe);
			Date rueckgabe1 = dt.parse(datumStringRueckgabe);

//			Publikation harryPotter1 = new Publikation("Harry Potter und der Stein der Weisen",
//					"J.K.Rowling",
//					buchdatum1,
//					"randomVerlag",
//					"Buch",
//					"3-551-55167-7",
//					schlagwoerter,
//					3);
//			publikationrepo.save(harryPotter1);
//
//			Publikation harryPotter2 = new Publikation("Harry Potter und die Kammer des Schreckens",
//					"J.K.Rowling",
//					buchdatum2,
//					"randomVerlag",
//					"Buch",
//					"3-551-55168-5",
//					"schlagwort",
//					53);
//			publikationrepo.save(harryPotter2);
//
//			Publikation harryPotter3 = new Publikation("Harry Potter und der Gefangene von Askaban",
//					"J.K.Rowling",
//					buchdatum3,
//					"randomVerlag",
//					"Buch",
//					"3-551-55169-3",
//					"schlagwort",
//					1);
//			publikationrepo.save(harryPotter3);
//
//			Publikation harryPotter4 = new Publikation("Harry Potter und der Feuerkelch",
//					"J.K.Rowling",
//					buchdatum4,
//					"randomVerlag",
//					"Buch",
//					"3-551-55193-6",
//					"schlagwort",
//					2);
//			publikationrepo.save(harryPotter4);
//
//			Publikation harryPotter5 = new Publikation("Harry Potter und der Orden des Phönix",
//					"J.K.Rowling",
//					buchdatum5,
//					"randomVerlag",
//					"Buch",
//					"3-551-55555-9",
//					"schlagwort",
//					17);
//			publikationrepo.save(harryPotter5);
//
//			Publikation harryPotter6 = new Publikation("Harry Potter und der Halbblutprinz",
//					"J.K.Rowling",
//					buchdatum6,
//					"randomVerlag",
//					"Buch",
//					"3-551-56666-6",
//					"schlagwort",
//					8);
//			publikationrepo.save(harryPotter6);
//
//			Publikation harryPotter7 = new Publikation("Harry Potter und die Heiligtümer des Todes",
//					"J.K.Rowling",
//					buchdatum7,
//					"randomVerlag",
//					"Buch",
//					"3-551-57777-3",
//					"schlagwort",
//					100);
//			publikationrepo.save(harryPotter7);
//
//			Long pubID = 1L;
//			Ausleihvorgang vorgang = new Ausleihvorgang(ausgabe1,"Harry Potter und der Stein der Weisen",rueckgabe1,14,2,pubID,"Rowling","J.K",12314);
//			ausleihRepo.save(vorgang);
		};
	};


}
