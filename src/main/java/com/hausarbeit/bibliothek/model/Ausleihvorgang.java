package com.hausarbeit.bibliothek.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ausleihvorgang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    public int vorgangID;
    public Date ausgabedatum;
    public Date rueckgabedatum;
    public Date ausleihzeitraum;
    public int ausleihCounter;
    //public Publikation ausgeliehenesobjekt;
    //public Student ausleiher;

    public int getVorgangID() {
        return vorgangID;
    }

    public void setVorgangID(int vorgangID) {
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

    public Date getAusleihzeitraum() {
        return ausleihzeitraum;
    }

    public void setAusleihzeitraum(Date ausleihzeitraum) {
        this.ausleihzeitraum = ausleihzeitraum;
    }

    public int getAusleihCounter() {
        return ausleihCounter;
    }

    public void setAusleihCounter(int ausleihCounter) {
        this.ausleihCounter = ausleihCounter;
    }

   // public Publikation getAusgeliehenesobjekt() {
  //      return ausgeliehenesobjekt;
   // }

  //  public void setAusgeliehenesobjekt(Publikation ausgeliehenesobjekt) {
   //     this.ausgeliehenesobjekt = ausgeliehenesobjekt;
   // }

//    public Student getAusleiher() {
  //      return ausleiher;
  //  }

  //  public void setAusleiher(Student ausleiher) {
   //     this.ausleiher = ausleiher;
   // }
}
