package com.hausarbeit.bibliothek.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;import java.util.Date;
import java.util.List;
/**
 * Model für Buch
 *
 * @author Marlon Hippler
 */

@Entity
@NoArgsConstructor
public class Publikation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    public int buch_ID;
    public String titel;
    public String autor;
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    public String schlagwoerter;
    public int bestandAnzahl;


    public int getBuch_ID() {
        return buch_ID;
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

    public void setBuch_ID(int buch_ID) {
        this.buch_ID = buch_ID;
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
