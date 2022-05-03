package com.hausarbeit.bibliothek.exception;


import org.springframework.http.HttpInputMessage;

public class NeueException {
    String msg;
    HttpInputMessage httpInputMessage;
    Throwable throwable;


    public NeueException(String msg, HttpInputMessage httpInputMessage,Throwable throwable) {
        this.msg = msg;
        this.httpInputMessage = httpInputMessage;
        this.throwable = throwable;

    }
    public String getMsg() {
        return msg;
    }

    public HttpInputMessage getHttpInputMessage() {
        return httpInputMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
