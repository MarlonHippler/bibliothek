package com.hausarbeit.bibliothek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * CustomExceptionHandler
 * @author Marlon Hippler
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {RequestBibliothekException.class})
    public ResponseEntity<Object> handlePublikationException(RequestBibliothekException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        BibliothekException bibliothekException = new BibliothekException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(bibliothekException, badRequest);
    }

}
