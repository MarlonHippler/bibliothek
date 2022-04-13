package com.hausarbeit.bibliothek.request;

import com.hausarbeit.bibliothek.model.Publikationsart;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PublikationRequest {

    public String titel;
    public String autor;
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    public String schlagwoerter;
    public int bestandAnzahl;
}
