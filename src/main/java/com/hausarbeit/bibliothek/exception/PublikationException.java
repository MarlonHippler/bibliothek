package com.hausarbeit.bibliothek.exception;

public class PublikationException extends RuntimeException{

    public PublikationException(String nachricht){
        super(nachricht);
    }
    public PublikationException (String nachricht, Throwable grund){
        super(nachricht,grund);
    }
}
