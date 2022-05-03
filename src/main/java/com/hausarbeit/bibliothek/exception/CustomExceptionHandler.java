package com.hausarbeit.bibliothek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {PublikationException.class})
    public ResponseEntity<Object> handlePublikationException(PublikationException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        BibliothekException bibliothekException = new BibliothekException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(bibliothekException, badRequest);
    }

    @ExceptionHandler(InvalidExceptionPublikation.class)
    public ResponseEntity<Object> processJsonInvalidFormatException(InvalidExceptionPublikation e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        NeueException neueException = new NeueException(
                e.getMessage(),
                e.getHttpInputMessage(),
                e.getCause());
        return new ResponseEntity<>(neueException, badRequest);
    }
}
