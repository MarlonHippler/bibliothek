package com.hausarbeit.bibliothek.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * BibliothekException beinhaltet die Daten,
 * die ans FrontEnd weitergegeben werden, wenn eine RequestBibliothekException geworfen wird.
 * @author Marlon Hippler
 */
public class BibliothekException {

    private final String nachricht;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public BibliothekException(String nachricht,
                               HttpStatus httpStatus,
                               ZonedDateTime timestamp){
        this.nachricht = nachricht;

        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getNachricht() {
        return nachricht;
    }



    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
