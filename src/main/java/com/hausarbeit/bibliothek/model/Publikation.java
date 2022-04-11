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
    @ElementCollection
    public List<String> autor;
    public Date veroeffentlichung;
    public String verlag;
    public Publikationsart publikationsart;
    public String ISBN;
    @ElementCollection
    public List<String> schlagwoerter;
    public int bestandAnzahl;


    public int getBuch_ID() {
        return buch_ID;
    }

    public String getTitel() {
        return titel;
    }

    public List<String> getAutor() {
        return autor;
    }

    public Date getVeroeffentlichung() {
        return veroeffentlichung;
    }

    public String getVerlag() {
        return verlag;
    }

    public Publikationsart getPublikationsart() {
        return publikationsart;
    }

    public String getISBN() {
        return ISBN;
    }

    public List<String> getSchlagwoerter() {
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

    public void setAutor(List<String> autor) {
        this.autor = autor;
    }

    public void setVeroeffentlichung(Date veroeffentlichung) {
        this.veroeffentlichung = veroeffentlichung;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public void setPublikationsart(Publikationsart publikationsart) {
        this.publikationsart = publikationsart;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setSchlagwoerter(List<String> schlagwoerter) {
        this.schlagwoerter = schlagwoerter;
    }

    public void setBestandAnzahl(int bestandAnzahl) {
        this.bestandAnzahl = bestandAnzahl;
    }
}
