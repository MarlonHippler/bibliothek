package com.hausarbeit.bibliothek.exception;

/**
 * Eigene Exception die Runtime extended
 * @author Marlon Hippler
 */
public class RequestBibliothekException extends RuntimeException{

    public RequestBibliothekException(String nachricht){
        super(nachricht);
    }
    public RequestBibliothekException(String nachricht, Throwable grund){
        super(nachricht,grund);
    }
}
