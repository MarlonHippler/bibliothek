package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.RequestBibliothekException;
import com.hausarbeit.bibliothek.model.Publikation;
import com.hausarbeit.bibliothek.model.PublikationMitSchlagwort;
import com.hausarbeit.bibliothek.model.Schlagwoerter;
import com.hausarbeit.bibliothek.repo.SchlagwortRepo;
import com.hausarbeit.bibliothek.request.PublikationRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse für Methoden, die dupliziert vorkamen oder nicht zu Publikationsservices oder Ausleihservices passen
 * @author Marlon Hippler
 */
public class UtilityService {
    public UtilityService() {
    }

    /**
     * Überprüft, ob es sich um eine ISBN handelt
     * Quelle: https://www.knowprogram.com/java/isbn-number-in-java/
     * Quelle: https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/
     * @param ISBN
     * @return
     */
    public boolean checkISBN (String ISBN){
        String regex ="^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ISBN);
        boolean stimmtÜberein = matcher.matches();
        if (stimmtÜberein = true){
            // declare variable
            int length = 0;


            // remove all hyphens
            ISBN = ISBN.replace("-", "");
            // remove all spaces
            ISBN = ISBN.replace(" ", "");

            length = ISBN.length();
            if(length<10){
                throw new RequestBibliothekException("Falsches ISBN Format, die ISBN muss mindestens 10 Zahlen enthalten");
            }
            // check result string is a number or not
            try {
                // except for the case where
                // ISBN-10 ends with X or x
                char ch = ISBN.charAt(9);
                ch = Character.toUpperCase(ch);
                if( ch != 'X') {
                    // don't store, only check
                    Long.parseLong(ISBN);
                }
            } catch(NumberFormatException nfe) {
                // not a number
                return false;
            }

            // find length

            if(length==13)
                return istISBN13(ISBN);
            else if(length==10)
                return istISBN10(ISBN);

            return false;
        }else {
            return false;
    }
}

    /**
     * Checkt ob es sich bei einer 10-stelligen Nummer um eine ISBN handelt
     * @param ISBN
     * @return
     */
    private static boolean istISBN10(String ISBN) {

        // declare variables
        int sum = 0;
        int digit = 0;
        char ch = '\0';

        // add upto 9th digit
        for(int i=1; i<=9; i++) {
            ch = ISBN.charAt(i-1);
            digit = Character.getNumericValue(ch);
            sum += (i* digit);
        }

        // last digit
        ch = ISBN.charAt(9);
        ch = Character.toUpperCase(ch);
        if(ch =='X')
            sum += (10*10);
        else {
            digit = Character.getNumericValue(ch);
            sum += (digit * 10);
        }

        // check sum
        if(sum % 11 == 0)
            return true;

        return false;
    }

    /**
     * Checkt ob es sich bei einer 13-stelligen Nummer um eine ISBN handelt
     * @param ISBN
     * @return
     */
    private static boolean istISBN13(String ISBN) {

        // declare variables
        int sum = 0;
        int multiple = 0;
        char ch = '\0';
        int digit = 0;

        // add digits
        for(int i=1; i<=13; i++) {

            if(i % 2 == 0)
                multiple = 3;
            else multiple = 1;

            // fetch digit
            ch = ISBN.charAt(i-1);
            // convert it to number
            digit = Character.getNumericValue(ch);

            // addition
            sum += (multiple*digit);
        }

        // check sum
        if(sum%10 == 0)
            return true;
        return false;
    }

    /**
     * Überprüft die Eingabe auf gültige Bestandsanzahl und ISBN
     * @param request
     */
    public void eingabenCheck(PublikationRequest request) {
        if (request.getBestandAnzahl() < 1) {
            throw new RequestBibliothekException("Die Bestandsanzahl muss größer als null sein.");
        }
        if (request.getISBN() != "") {
            boolean check = checkISBN(request.getISBN());
            if (check == false) {
                throw new RequestBibliothekException("Keine gültige ISBN");
            }
        }

    }

    /**
     * Formatiert eine Publikation zu einer Publikation mit Schlagwortarray
     * @param publikation
     * @return
     */
    public PublikationMitSchlagwort publikationMitSchlagwortFormatierung (Publikation publikation){
        PublikationMitSchlagwort publikationMitSchlagwort= new PublikationMitSchlagwort();
        List<Schlagwoerter> schlagwoerterList= publikation.getSchlagwoerter();
        int laengeZwei = schlagwoerterList.size();
        String[] schlagwortArray = new String[laengeZwei];
        while (laengeZwei > 0){
            int arrayPlatzZwei = laengeZwei -1;
            Schlagwoerter schlagwortObjekt = schlagwoerterList.get(arrayPlatzZwei);
            String schlagwort = schlagwortObjekt.getSchlagwort();
            schlagwortArray[arrayPlatzZwei] = schlagwort;
            laengeZwei = laengeZwei -1;
        }
        publikationMitSchlagwort.setTitel(publikation.getTitel());
        publikationMitSchlagwort.setPublikationID(publikation.getPublikationID());
        publikationMitSchlagwort.setPublikationsart(publikation.getPublikationsart());
        publikationMitSchlagwort.setSchlagwoerter(schlagwortArray);
        publikationMitSchlagwort.setAutor(publikation.getAutor());
        publikationMitSchlagwort.setBestandAnzahl(publikation.getBestandAnzahl());
        publikationMitSchlagwort.setISBN(publikation.getISBN());
        publikationMitSchlagwort.setVerlag(publikation.getVerlag());
        publikationMitSchlagwort.setVeroeffentlichung(publikation.getVeroeffentlichung());
        return publikationMitSchlagwort;
    }

    /**
     * Weist beim erstellen oder updaten die Werte aus dem Request der neuen Publikation zu
     * @param publikation
     * @param request
     * @param schlagwortRepo
     * @return
     */
    public Publikation zuweisenPublikationswerte (Publikation publikation, PublikationRequest request, SchlagwortRepo schlagwortRepo){
        publikation.setTitel(request.getTitel());
        publikation.setPublikationsart(request.getPublikationsart());
        publikation.setAutor(request.getAutor());
        publikation.setISBN(request.getISBN());
        publikation.setBestandAnzahl(request.getBestandAnzahl());
        publikation.setVerlag(request.getVerlag());
        publikation.setVeroeffentlichung(request.getVeroeffentlichung());
        publikation.schlagwoerter = new ArrayList<Schlagwoerter>();
        String[] schlagwoerter = request.getSchlagwoerter();
        int laenge = schlagwoerter.length;
        while (laenge > 0){
            int arrayStelle = laenge-1;
            String schlagwortString = schlagwoerter[arrayStelle];
            Long id = schlagwortRepo.findBySchlagwort(schlagwortString);
            Schlagwoerter schlagwort = schlagwortRepo.findSchlagwoerterBySchlagwoerterID(id);
            publikation.schlagwörterZuweisen(schlagwort);
            laenge = laenge-1;
        }
        return publikation;
    }

}
