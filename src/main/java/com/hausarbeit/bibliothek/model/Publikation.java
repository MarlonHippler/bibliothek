package com.hausarbeit.bibliothek.model;


import javax.persistence.*;
import java.io.Serializable;import java.util.Date;

/**
 * Model für Publikation
 *
 * @author Marlon Hippler
 */

@Entity
@Table
public class Publikation implements Serializable {

    public Publikation (){

    }

    public Publikation (String titel,
                        String autor,
                        Date veroeffentlichung,
                        String verlag,
                        String publikationsart,
                        String ISBN,
                        String schlagwoerter,
                        int bestandAnzahl )
    { this.titel = titel;
    this.autor= autor;
    this.veroeffentlichung = veroeffentlichung;
    this.verlag = verlag;
    this.publikationsart = publikationsart;
    this.ISBN = ISBN;
    this.schlagwoerter = schlagwoerter;
    this.bestandAnzahl = bestandAnzahl;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "publikation_sequence",
            sequenceName = "publikation_sequence",
            allocationSize = 1
    )
    public Long publikation_ID;
    public String titel;
    public String autor;
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    public String schlagwoerter;
    public int bestandAnzahl;


    public Long getPublikation_ID() {
        return publikation_ID;
    }

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public Date getVeroeffentlichung() {
        return veroeffentlichung;
    }

    public String getVerlag() {
        return verlag;
    }

    public String getPublikationsart() {
        return publikationsart;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getSchlagwoerter() {
        return schlagwoerter;
    }

    public int getBestandAnzahl() {
        return bestandAnzahl;
    }

    public void setPublikation_ID(Long buch_ID) {
        this.publikation_ID = buch_ID;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setVeroeffentlichung(Date veroeffentlichung) {
        this.veroeffentlichung = veroeffentlichung;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public void setPublikationsart(String publikationsart) {
        this.publikationsart = publikationsart;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setSchlagwoerter(String schlagwoerter) {
        this.schlagwoerter = schlagwoerter;
    }

    public void setBestandAnzahl(int bestandAnzahl) {
        this.bestandAnzahl = bestandAnzahl;
    }
}
