package com.hausarbeit.bibliothek.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Enthält das Model für eine Publikation
 *
 * @author Marlon Hippler
 */

@Entity
@Table(name = "publikation")
public class Publikation implements Serializable {

    public Publikation (){

    }

    public Publikation (String titel,
                        String autor,
                        Date veroeffentlichung,
                        String verlag,
                        String publikationsart,
                        String ISBN,
                        List<Schlagwoerter> schlagwoerter,
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "publikation_sequence",
            sequenceName = "publikation_sequence",
            allocationSize = 1
    )
    public Long publikationID;
    public String titel;
    public String autor;
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    @ManyToMany
    @JoinTable(
            name = "SchlagwoerterPublikation",
            joinColumns = @JoinColumn(name= "publikation_id"),
            inverseJoinColumns = @JoinColumn(name="schlagwoerter_id")
    )
    public List<Schlagwoerter> schlagwoerter;
    public Integer bestandAnzahl;

    public void schlagwörterZuweisen(Schlagwoerter schlagwort) {
        schlagwoerter.add(schlagwort);
    }


    public Long getPublikationID() {
        return publikationID;
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

    public List<Schlagwoerter> getSchlagwoerter() {
        return schlagwoerter;
    }

    public Integer getBestandAnzahl() {
        return bestandAnzahl;
    }

    public void setPublikationID(Long buch_ID) {
        this.publikationID = buch_ID;
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

    public void setSchlagwoerter(List<Schlagwoerter> schlagwoerter) {
        this.schlagwoerter = schlagwoerter;
    }

    public void setBestandAnzahl(Integer bestandAnzahl) {
        this.bestandAnzahl = bestandAnzahl;
    }
}
