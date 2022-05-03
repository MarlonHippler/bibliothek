package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.PublikationException;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.repo.AusleihRepo;
import com.hausarbeit.bibliothek.repo.PublikationRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Publikationservices {

    private PublikationRepo publikationRepo;
    private AusleihRepo ausleihRepo;

    @Autowired
    public Publikationservices(PublikationRepo publikationRepo, AusleihRepo ausleihRepo) {
        this.publikationRepo = publikationRepo;
        this.ausleihRepo = ausleihRepo;
    }

    public void publikationAnlegen(PublikationRequest request) {

        if (request==null ||request.getTitel() == null|| request.getBestandAnzahl()== null){
            throw new PublikationException("Die Felder Titel und Bestandsanzahl müssen ausgefüllt sein");
        }
        if (request.getBestandAnzahl() < 1){
            throw new PublikationException("Die Bestandsanzahl muss größer als null sein.");
        } else {

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
    }

    public void publikationUpdaten(Long publikationID, Publikation request) {
        if (request.getBestandAnzahl() < 1){
            throw new PublikationException("Die Bestandsanzahl muss größer als null sein.");
        }
        Publikation publikationneu = publikationRepo.findPublikationByPublikationID(publikationID);
        publikationneu.setTitel(request.getTitel());
        publikationneu.setPublikationsart(request.getPublikationsart());
        publikationneu.setAutor(request.getAutor());
        publikationneu.setISBN(request.getISBN());
        publikationneu.setBestandAnzahl(request.getBestandAnzahl());
        publikationneu.setVerlag(request.getVerlag());
        publikationneu.setSchlagwoerter(request.getSchlagwoerter());
        publikationneu.setVeroeffentlichung(request.getVeroeffentlichung());
        publikationRepo.save(publikationneu);
    }

    public void publikationLoeschen(long publikationID) {
        boolean existiert = publikationRepo.existsById(publikationID);
        if (!existiert) {
            throw new IllegalStateException("Publikation mit ID" + publikationID + " existiert nicht");
        }
        publikationRepo.deleteById(publikationID);
    }


    public List<Publikation> publikationenLaden() {
        return this.publikationRepo.findAll();
    }

    public Publikation publikationLaden(Long publikationID) {
        if (publikationID == null) {
            throw new IllegalArgumentException("Publikations-ID ist notwendig!");}
            Publikation publikation;
            try {
                publikation = this.publikationRepo.findPublikationByPublikationID(publikationID);
            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException(e.getMessage());

            }
            return publikation;
        }

    public List<Ausleihvorgang> zugehoerigeAusleihvorgaenge(Long publikationID) {
        return ausleihRepo.findByPublikationID(publikationID);
    }

//    public boolean checkISBN (String ISBN){
//        String regex ="^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(ISBN);
//        boolean stimmtÜberein = matcher.matches();
//        if (stimmtÜberein = true){
//            // declare variable
//            int length = 0;
//
//            // remove all hyphens
//            ISBN = ISBN.replace("-", "");
//            // remove all spaces
//            ISBN = ISBN.replace(" ", "");
//
//            // check result string is a number or not
//            try {
//                // except for the case where
//                // ISBN-10 ends with X or x
//                char ch = ISBN.charAt(9);
//                ch = Character.toUpperCase(ch);
//                if( ch != 'X') {
//                    // don't store, only check
//                    Long.parseLong(ISBN);
//                }
//            } catch(NumberFormatException nfe) {
//                // not a number
//                return false;
//            }
//
//            // find length
//            length = ISBN.length();
//            if(length==13)
//                return istISBN13(ISBN);
//            else if(length==10)
//                return istISBN10(ISBN);
//
//            return false;
//        }else {
//            return false;
//    }
//}
//    private static boolean istISBN10(String ISBN) {
//
//        // declare variables
//        int sum = 0;
//        int digit = 0;
//        char ch = '\0';
//
//        // add upto 9th digit
//        for(int i=1; i<=9; i++) {
//            ch = ISBN.charAt(i-1);
//            digit = Character.getNumericValue(ch);
//            sum += (i* digit);
//        }
//
//        // last digit
//        ch = ISBN.charAt(9);
//        ch = Character.toUpperCase(ch);
//        if(ch =='X')
//            sum += (10*10);
//        else {
//            digit = Character.getNumericValue(ch);
//            sum += (digit * 10);
//        }
//
//        // check sum
//        if(sum % 11 == 0)
//            return true;
//
//        return false;
//    }
//    private static boolean istISBN13(String ISBN) {
//
//        // declare variables
//        int sum = 0;
//        int multiple = 0;
//        char ch = '\0';
//        int digit = 0;
//
//        // add digits
//        for(int i=1; i<=13; i++) {
//
//            if(i % 2 == 0)
//                multiple = 3;
//            else multiple = 1;
//
//            // fetch digit
//            ch = ISBN.charAt(i-1);
//            // convert it to number
//            digit = Character.getNumericValue(ch);
//
//            // addition
//            sum += (multiple*digit);
//        }
//
//        // check sum
//        if(sum%10 == 0)
//            return true;
//        return false;
//    }
}


