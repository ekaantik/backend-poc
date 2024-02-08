package com.poc.ecard.exception.base;

import org.springframework.http.HttpStatus;

public class EcardException extends RuntimeException {

    private final HttpStatus status;

    /**
     * use the once with cause
     */
    @Deprecated
    public EcardException(HttpStatus status, String message) {
        this(status, message, null);
    }

    public EcardException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

}
