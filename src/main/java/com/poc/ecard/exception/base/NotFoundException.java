package com.poc.ecard.exception.base;

public class NotFoundException extends BadRequestException {

    public NotFoundException(String messageFormat, Object... args) {
        super(messageFormat, args);
    }

}
