package com.hausarbeit.bibliothek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schlagwoerter")
public class Schlagwoerter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "schlagwort_sequence",
            sequenceName = "schlagwort_sequence",
            allocationSize = 1
    )
    private Long schlagwoerterID;
    public String schlagwort;

    @JsonIgnore
    @ManyToMany(mappedBy = "schlagwoerter")
    public List<Publikation> publikationListe;

    public Long getId() {
        return schlagwoerterID;
    }

    public void setId(Long id) {
        this.schlagwoerterID = id;
    }

    public Schlagwoerter(String schlagwort) {
        this.schlagwort = schlagwort;
    }

    public Schlagwoerter() {

    }

    public String getSchlagwort() {
        return schlagwort;
    }

    public void setSchlagwort(String schlagwort) {
        this.schlagwort = schlagwort;
    }

    public void publikationZuweisen(Publikation publikation) {
        publikationListe.add(publikation);
    }
}
