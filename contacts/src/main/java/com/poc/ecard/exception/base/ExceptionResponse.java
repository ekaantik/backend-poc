package com.poc.ecard.exception.base;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Builder
@Slf4j
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = -4333387737003853249L;

    private final ZonedDateTime timestamp;
    private final String message;
    private final Integer responseCode;
    private final Details details;

    public ExceptionResponse() {
        super();
        this.timestamp = null;
        this.message = null;
        this.responseCode = null;
        this.details = null;
    }

    public ExceptionResponse(ZonedDateTime timestamp, String message, Integer responseCode, Details details) {
        this.timestamp = timestamp;
        this.message = message;
        this.responseCode = responseCode;
        this.details = details;
    }

}
