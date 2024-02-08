package com.poc.ecard.exception.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class BadRequestException extends EcardException {

    /**
     * Use the constructor with cause
     * @param messageFormat
     * @param args
     */
    @Deprecated
    public BadRequestException(String messageFormat, Object... args) {
        super(HttpStatus.BAD_REQUEST, String.format(messageFormat, args));
    }

    public BadRequestException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }

}
