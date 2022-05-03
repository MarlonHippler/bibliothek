package com.hausarbeit.bibliothek.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.Date;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PublikationRequest {
    public String titel;
    public String autor;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public Date veroeffentlichung;
    public String verlag;
    public String publikationsart;
    public String ISBN;
    public String schlagwoerter;
    public Integer bestandAnzahl;
}
