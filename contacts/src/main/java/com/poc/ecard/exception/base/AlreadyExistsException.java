package com.poc.ecard.exception.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlreadyExistsException extends BadRequestException {

    public AlreadyExistsException(String messageFormat, Object... args) {
        super(messageFormat, args);
    }

}
