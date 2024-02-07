package com.poc.ecard.exception.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class InternalServerErrorException extends EcardException {


    /**
     * Use the once with Throwable cause
     * @param messageFormat
     * @param args
     */
    @Deprecated
    public InternalServerErrorException(String messageFormat, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, String.format(messageFormat, args));
    }

    public InternalServerErrorException(String messageFormat, Throwable cause, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, String.format(messageFormat, args), cause);
    }

}
