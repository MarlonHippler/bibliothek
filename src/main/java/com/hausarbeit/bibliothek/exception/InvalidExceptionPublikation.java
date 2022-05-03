package com.hausarbeit.bibliothek.exception;

import com.fasterxml.jackson.core.JsonParser;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class InvalidExceptionPublikation extends HttpMessageNotReadableException {

    public InvalidExceptionPublikation(String msg, HttpInputMessage httpInputMessage) {
        super(msg, httpInputMessage);
    }

    public InvalidExceptionPublikation(String msg, Throwable cause, HttpInputMessage httpInputMessage) {
        super(msg, cause, httpInputMessage);
    }

    public InvalidExceptionPublikation(String msg) {
        super(msg);
    }
}
