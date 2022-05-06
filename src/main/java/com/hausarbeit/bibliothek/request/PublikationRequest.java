package com.hausarbeit.bibliothek.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.Date;


/**
 * RequestBody für Publikationen
 * @author Marlon Hippler
 */

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
    public String[] schlagwoerter;
    public Integer bestandAnzahl;
}
