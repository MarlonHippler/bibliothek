package com.hausarbeit.bibliothek.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Ausleihvorgang implements Serializable {



    public Ausleihvorgang (){

    }

    public Ausleihvorgang (Date ausgabedatum,
                           String pubTitel,
                           Date rueckgabedatum,
                           int ausleihzeitraum,
                           int ausleihCounter,
                           Long pubID,
                           String name,
                           String vorname,
                           int matrikelnummer )
    { this.ausgabedatum = ausgabedatum;
        this.rueckgabedatum= rueckgabedatum;
        this.ausleihzeitraum = ausleihzeitraum;
        this.ausleihCounter = ausleihCounter;
        this.pubID = pubID;
        this.pubTitel = pubTitel;
        this.name = name;
        this.vorname = vorname;
        this.matrikelnummer = matrikelnummer;}





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    public Long vorgangID;
    public String pubTitel;
    public Date ausgabedatum;
    public Date rueckgabedatum;
    public static int ausleihzeitraum = 14;
    public int ausleihCounter;
    public Long pubID;
    public String name;
    public String vorname;
    public int matrikelnummer;

    public Long getVorgangID() {
        return vorgangID;
    }

    public void setVorgangID(Long vorgangID) {
        this.vorgangID = vorgangID;
    }

    public Date getAusgabedatum() {
        return ausgabedatum;
    }

    public void setAusgabedatum(Date ausgabedatum) {
        this.ausgabedatum = ausgabedatum;
    }

    public Date getRueckgabedatum() {
        return rueckgabedatum;
    }

    public void setRueckgabedatum(Date rueckgabedatum) {
        this.rueckgabedatum = rueckgabedatum;
    }

    public int getAusleihzeitraum() {
        return ausleihzeitraum;
    }

    public void setAusleihzeitraum(int ausleihzeitraum) {
        this.ausleihzeitraum = ausleihzeitraum;
    }

    public int getAusleihCounter() {
        return ausleihCounter;
    }

    public void setAusleihCounter(int ausleihCounter) {
        this.ausleihCounter = ausleihCounter;
    }

    public Long getPubID() {
        return pubID;
    }

    public void setPubID(Long pubID) {
        this.pubID = pubID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname= vorname;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getPubTitel() {
        return pubTitel;
    }

    public void setPubTitel(String pubTitel) {
        this.pubTitel = pubTitel;
    }
}
