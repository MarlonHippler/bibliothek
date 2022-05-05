package com.hausarbeit.bibliothek.services;

import com.hausarbeit.bibliothek.exception.RequestBibliothekException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse für Methoden, die nicht zu Publikationservices oder Ausleihservices passen
 * @author Marlon Hippler
 */
public class UtilityService {
    public UtilityService() {
    }

    /**
     * Überprüft, ob es sich um eine ISBN handelt
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
            length = ISBN.length();
            if(length<10){
                throw new RequestBibliothekException("Falsches ISBN Format, die ISBN muss mindestens 10 Zahlen enthalten");
            }

            // remove all hyphens
            ISBN = ISBN.replace("-", "");
            // remove all spaces
            ISBN = ISBN.replace(" ", "");

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

}
