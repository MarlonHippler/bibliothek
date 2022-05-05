package com.hausarbeit.bibliothek.model;

import java.util.Date;

/**
 * Modell Klasse für das Anzeigen von der Publikation inklusive der Schlagwörter
 * @author Marlon Hippler
 */
public class PublikationMitSchlagwort {

    public PublikationMitSchlagwort() {
    }

    public PublikationMitSchlagwort(Long publikationID,
                                    String titel,
                                    String autor,
                                    Date veroeffentlichung,
                                    String verlag,
                                    String publikationsart,
                                    String ISBN,
                                    String[] schlagwoerter,
                                    Integer bestandAnzahl) {
        this.publikationID = publikationID;
        this.titel = titel;
        this.autor = autor;
        this.veroeffentlichung = veroeffentlichung;
        this.verlag = verlag;
        this.publikationsart = publikationsart;
        this.ISBN = ISBN;
        this.schlagwoerter = schlagwoerter;
        this.bestandAnzahl = bestandAnzahl;
    }

    public Long publikationID;
    public String titel;
    public String autor;
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    public String[] schlagwoerter;
    public Integer bestandAnzahl;

    public Long getPublikationID() {
        return publikationID;
    }

    public void setPublikationID(Long publikationID) {
        this.publikationID = publikationID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getVeroeffentlichung() {
        return veroeffentlichung;
    }

    public void setVeroeffentlichung(Date veroeffentlichung) {
        this.veroeffentlichung = veroeffentlichung;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getPublikationsart() {
        return publikationsart;
    }

    public void setPublikationsart(String publikationsart) {
        this.publikationsart = publikationsart;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String[] getSchlagwoerter() {
        return schlagwoerter;
    }

    public void setSchlagwoerter(String[] schlagwoerter) {
        this.schlagwoerter = schlagwoerter;
    }

    public Integer getBestandAnzahl() {
        return bestandAnzahl;
    }

    public void setBestandAnzahl(Integer bestandAnzahl) {
        this.bestandAnzahl = bestandAnzahl;
    }
}
