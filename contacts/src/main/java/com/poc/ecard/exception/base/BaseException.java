package com.poc.ecard.exception.base;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Slf4j
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4333387737003853249L;

    private final ZonedDateTime timestamp;
    private final String message;
    private final Integer responseCode;
    private final Details details;

    public BaseException() {
        super();
        this.timestamp = null;
        this.message = null;
        this.responseCode = null;
        this.details = null;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ZonedDateTime timestamp, String message1, Integer responseCode, Details details) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.timestamp = timestamp;
        this.message = message1;
        this.responseCode = responseCode;
        this.details = details;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression,
                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.timestamp = null;
        this.message = null;
        this.responseCode = null;
        this.details = null;
    }

    public BaseException(String message, Integer responseCode, Details details, Throwable ex) {
        super(message,ex,false,false);
        this.timestamp = null;
        this.message = message;
        this.responseCode = responseCode;
        this.details = details;
    }

    public BaseException(ZonedDateTime timestamp, String message) {
        super(null,null,false,false);
        this.timestamp = timestamp;
        this.message = message;
        this.responseCode = null;
        this.details = null;
    }
}
