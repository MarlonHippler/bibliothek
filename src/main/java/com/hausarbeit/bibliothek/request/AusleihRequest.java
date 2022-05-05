package com.hausarbeit.bibliothek.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * RequestBody fürs Ausleihvorgänge
 * @author Marlon Hippler
 */

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class AusleihRequest {

    public Long pubID;
    public String name;
    public String vorname;
    public int matrikelnummer;

}
